# Provide User Credentials
$username = '$env:USERNAME'
$password = '$env:PASSWORD'

# Base64 encode the credentials
$base64Auth = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes(("{0}:{1}" -f $username, $password)))
Write-Output $base64Auth
