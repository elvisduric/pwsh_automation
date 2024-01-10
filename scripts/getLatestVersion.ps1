# Get Last Object Version
$endpoint = "$baseUrl/api/object/$objectId/item/version-history"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

# Make the GET request to get all object versions
$response = Invoke-WebRequest -Method GET -Uri $endpoint -Headers $headers

# Convert JSON to PowerShell objects
$objects = $response | ConvertFrom-Json

# Get the versionLabel from the latest object
$latestVersionLabel = $objects[-1].versionLabel

# Output the latest version label
Write-Output $latestVersionLabel