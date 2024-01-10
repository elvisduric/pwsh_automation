# Set your credentials
$username = "safetybuildserver"
$password = "Buildserver2023+=21"

# Base64 encode the credentials
$base64Auth = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes(("{0}:{1}" -f $username, $password)))

# SMC Environment
$baseUrl = "http://smc-qs.br-automation.co.at/api"

# Get running processes
$endpoint = "$baseUrl/tasks/task-production?serverId=JACKRABBIT&status=RUNNING"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

# Make the GET request to check if any running processes
$response = Invoke-WebRequest -Method GET -Uri $endpoint -Headers $headers

# Capture cookies from the response headers
$cookiesHeader = $response.Headers["Set-Cookie"]

# Split the cookies into individual items
$cookies = $cookiesHeader -split '; '

# Find the XSRF-TOKEN cookie and extract its value
$xsrfTokenValue = ($cookies | Where-Object { $_ -match 'XSRF-TOKEN=' }) -replace 'XSRF-TOKEN=', ''

# Find the JSESSIONID cookie and extract its value
$jsessionIdValue = ($cookies | Where-Object { $_ -match 'JSESSIONID=' }) -replace 'JSESSIONID=', ''

# Check if the response body is an empty object
if (-not $response.Content.Equals("[]")) {
    throw "There are some tasks under processing!"
}

#############################################################################################

# Start Production Process
$endpoint = "$baseUrl/tasks/task-production"

$headers = @{
    "Authorization" = "Basic $base64Auth"
    "X-XSRF-TOKEN"  = "$xsrfTokenValue"
    "Cookie"        = "JSESSIONID=$jsessionIdValue; XSRF-TOKEN=$xsrfTokenValue"
    "Content-Type"  = "application/json"
}

# Request Body
$body = @{
    "bookId"              = "1512108773341"
    "serverId"            = "JACKRABBIT"
    "productionProfileId" = "1326395392417"
    "language"            = "de"
    "synchronous"         = "true"
} | ConvertTo-Json

# Make the request using Invoke-RestMethod
$postResponse = Invoke-RestMethod -Method POST -Uri $endpoint -Headers $headers -Body $body
# Extract downloadUrl from the response
$taskId = $postResponse.taskId

#############################################################################################

# Get Production TaskID
$endpoint = "$baseUrl/tasks/task-production/$taskId/"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

$status = ""
$timeout = 600  # Timeout in seconds
$elapsedTime = 0
$retryInterval = 5  # Interval between retries in seconds

# Loop until the status is "FINISHED" or until timeout
while ($status -ne "FINISHED" -and $elapsedTime -lt $timeout) {
    # Make the GET request to check the task status
    $response = Invoke-RestMethod -Method GET -Uri $endpoint -Headers $headers

    # Retrieve the task status from the response
    $status = $response.status

    if ($status -eq "FINISHED") {
        # Increment the elapsed time by the retry interval
        $elapsedTime += $retryInterval

        # Add a delay before the next check to avoid excessive requests
        Start-Sleep -Seconds $retryInterval
    }
}

if ($elapsedTime -ge $timeout) {
    Write-Output "Timeout reached. Process not finished within the specified time. Please check TaskId: $taskId"
}

$internalId = $response.internalTaskID

#############################################################################################

$endpoint = "$baseUrl/tasks/task-production/url?taskId=$taskId"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

# Make the GET request to check the status
$response = Invoke-RestMethod -Method GET -Uri $endpoint -Headers $headers
$fileUrl = $response.downloadUrl

# Finding the position of the last "/"
$lastSlashIndex = $fileUrl.LastIndexOf("/")

# Extracting the two parts
$fileDownloadUrl = $fileUrl.Substring(0, $lastSlashIndex)
$fileName = $fileUrl.Substring($lastSlashIndex + 1)

# Define the local file path where you want to save the downloaded file
$localFilePath = "C:\Projekte\DocuTeam\downloadedFiles\${internalId}_${fileName}" # Replace with your desired local file path and name

Invoke-WebRequest -Uri $fileDownloadUrl -OutFile $localFilePath -Headers $headers
Write-Host "File successfully downloaded to $localFilePath"

#############################################################################################