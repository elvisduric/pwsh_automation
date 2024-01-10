# Start Production Process
$endpoint = "$baseUrl/productionproxy"

$headers = @{
    "Authorization" = "Basic $base64Auth"
    "Cookie"        = "JSESSIONID=$jsessionIdValue; XSRF-TOKEN=$xsrfTokenValue"
    "X-XSRF-TOKEN"  = "$xsrfTokenValue"
    "Content-Type"  = "text/xml"
}

# Path to the XML file
$xmlPayload = "$filePath"

# Request Body
$body = Get-Content -Path $xmlPayload -Raw

# Convert Body to XML object
$xmlBody = [xml]$body

# Find and update the 'language' parameter value
$languageNode = $xmlBody.ProductionRequest.TrafoParameters.Parameter | Where-Object { $_.name -eq "language" }
if ($languageNode) {
    $languageNode.value = "$language"
}

# Find and update the 'objectURI' parameter value
$objectUriNode = $xmlBody.ProductionRequest.Parameter.Structure.Branch.Object.RefControl | Where-Object { $_.checkedState -eq "true" }
    foreach ($node in $objectUriNode) {
        $node.objectURI = ""
        $node.TargetTitle = ""
        $node.versionLabel = ""
    }

<# Find and update the 'bookUrl' parameter value
$uriNode = $xmlBody.ProductionRequest.TrafoParameters.Parameter | Where-Object { $_.name -eq "uri" }
$bookUrlNode = $xmlBody.ProductionRequest.TrafoParameters.Parameter | Where-Object { $_.name -eq "bookURL" }
if ($uriNode -and $bookUrlNode) {
    $uriNode.value = "$objectUri"
    $bookUrlNode.value = "$objectUri"
}
#>

# Find and update the 'brokerUrl' parameter value
$brokerUrlNode = $xmlBody.ProductionRequest.TrafoParameters.Parameter | Where-Object { $_.name -eq "brokerURL" }
if ($brokerUrlNode) {
    $brokerUrlNode.value = "$brokerUrl"
}

# Find and update the 'versionLabel' parameter value
$versionNode = $xmlBody.ProductionRequest.TrafoParameters.Parameter | Where-Object { $_.name -eq "versionLabel" }

if ($specificVersion) {
    Write-Host "Version: $specificVersion"
    $versionNode.value = "$specificVersion"
} else { 
    Write-Host "Version: $version"
    $versionNode.value = "$version" 
}

# Find and update the 'diffVersionLabel' parameter value
$diffVersionNode = $xmlBody.ProductionRequest.TrafoParameters.Parameter | Where-Object { $_.name -eq "diffVersionLabel" }
if ($diffVersionNode) {
    Write-Host "Diff Version: $diffVersion"
    $diffExportNodes = $xmlBody.ProductionRequest.TrafoParameters.Parameter | Where-Object { $_.name -eq "diffExport" }

    $diffVersionNode.value = "$diffVersion"
        foreach ($node in $diffExportNodes) {
        $node.value = "true"
        }
}

# Convert the modified XML back to string
$updatedBody = $xmlBody.OuterXml

# Make the request using Invoke-RestMethod
$postResponse = Invoke-RestMethod -Method POST -Uri $endpoint -Headers $headers -Body $updatedBody
# Extract downloadUrl from the response
$xmlResponse = [xml]$postResponse
$taskId = $xmlResponse.ProductionResponse.Parameter | Select-Object -ExpandProperty value
# Write-Output $taskId
Write-Output $taskId