# Get Object URI
$endpoint = "$baseUrl/api/object/$objectId/uri"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

# Make the GET request to get object uri data
$response = Invoke-RestMethod -Method GET -Uri $endpoint -Headers $headers

# Get Object URI value
# $objectUri = $response.objectUri
$objectUri = $response.objectUri

# Output the latest version label
Write-Output $objectUri