# Get Production TaskID
$endpoint = "$baseUrl/api/tasks/task-production/$taskId/"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

# Make the GET request to retrive the version of generated document
$response = Invoke-RestMethod -Method GET -Uri $endpoint -Headers $headers

# Retrieve the version value from the response
$docVersion = $response.version
$formattedValue = $docVersion.Replace(".", "")
Write-Output $formattedValue