# Provide User Credentials
$username = "safetybuildserver"
$password = "Buildserver2023+=21"

# Base64 encode the credentials
$base64Auth = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes(("{0}:{1}" -f $username, $password)))
Write-Output $base64Auth