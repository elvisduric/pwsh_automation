# Get running processes
$endpoint = "$baseUrl/api/tasks/task-production?serverId=JACKRABBIT&status=RUNNING"
$headers = @{
    "Authorization" = "Basic $base64Auth"
}

# Make the GET request to check if any running processes
$response = Invoke-WebRequest -Method GET -Uri $endpoint -Headers $headers

# Capture cookies from the response headers
$cookiesHeader = $response.Headers["Set-Cookie"]

# Split the cookies into individual items
$cookies = $cookiesHeader -split '; '

# Find the JSESSIONID cookie and extract its value
$jsessionIdValue = ($cookies | Where-Object { $_ -match 'JSESSIONID=' }) -replace 'JSESSIONID=', ''

# Set the values as output for Jenkins to capture
Write-Output $jsessionIdValue