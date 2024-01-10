# Get Production TaskID
$endpoint = "$baseUrl/api/tasks/task-production/$taskId/"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

$reqTimeout = 3000  # 30 minutes - Maximum timeout in seconds if 400 (Bad Request)
$elapsedReqTime = 0
$retryReqInterval = 5 # Optional delay before retry

do {
    $elapsedReqTime++
    try {
        $status = ''
        $timeout = 5400  # 1,5 hours - Timeout in seconds to wait for document to be generated
        $elapsedTime = 0
        $retryInterval = 5  # Interval between retries in seconds

        # Loop until the status is "FINISHED" or until timeout
        while ($status -ne "FINISHED" -and $elapsedTime -lt $timeout) {
            # Make the GET request to check the task status
            $response = Invoke-WebRequest -Method GET -Uri $endpoint -Headers $headers -ErrorAction Stop
            $jsonObject = $response.Content | ConvertFrom-Json
            $statusValue = $jsonObject.status
            Write-Host (Get-Date).ToString("HH:mm:ss") $statusValue

            # Retrieve the task status from the response
            $status = $jsonObject.status

            if ($status -ne "FINISHED") {
                # Increment the elapsed time by the retry interval
                $elapsedTime += $retryInterval

                # Add a delay before the next check to avoid excessive requests
                Start-Sleep -Seconds $retryInterval
            }
        }

        if ($elapsedTime -ge $timeout) {
            Write-Output "Timeout reached. Process not finished within the specified time. Please check TaskId: $taskId"
        }

        $internalId = $jsonObject.internalTaskID
        # Set the values as output for Jenkins to capture
        Write-Output $internalId
        break  # Break the loop if successful
    } catch {
        if ($null -ne $_.Exception.Response) {
            $statusCode = $_.Exception.Response.StatusCode.value__
            if ($statusCode -eq 400 && $elapsedReqTime -lt $reqTimeout) {
                Write-Host (Get-Date).ToString("HH:mm:ss") "Bad Request. Retrying..."
                Start-Sleep -Seconds $retryReqInterval  # Optional delay before retry
                continue  # Retry the request
            }
        }
    }
} while ($elapsedReqTime -lt $reqTimeout)

if ($elapsedReqTime -ge $reqTimeout) {
    throw "Request failed. Timeout reached after $reqTimeout seconds."
}