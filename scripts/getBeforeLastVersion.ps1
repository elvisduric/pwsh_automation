# Get Before Last Object Version
$endpoint = "$baseUrl/api/object/$objectId/item/version-history"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

# Make the GET request to get all object versions
$response = Invoke-WebRequest -Method GET -Uri $endpoint -Headers $headers

# Convert JSON to PowerShell objects
$objects = $response | ConvertFrom-Json

# Get the previousVersionLabel from the objects list
$beforeLastVersionLabel = $objects[-2].versionLabel

# Output the before last version label
Write-Output $beforeLastVersionLabel