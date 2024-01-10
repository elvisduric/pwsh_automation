<#
$base64Auth = "ZXh0X2R1cmljZTpTYW1vamUxRE9NLjIwMjQ="
$baseUrl = "http://smc-qs.br-automation.co.at"
$taskId = "df17ce2b-02b5-464a-ad5f-e3d536203ba5"
$bookName = "X20SA4430"
$internalId = "130"
$langSufix = "DE"
$docVersion = "2.10"
$category = "TUV";
#>

# Download Document on Local Storage
$endpoint = "$baseUrl/api/tasks/task-production/url?taskId=$taskId"
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
Write-Host $fileDownloadUrl
$fileName = $fileUrl.Substring($lastSlashIndex + 1)

# Define the local file path where you want to save the downloaded files
$localPath = "C:\\Projekte\\DocuTeam\\downloadedFiles\\"

# Define the file naming
if ($category -eq "Homepage") {
    $name = 'MASAFETY-' + $bookName + '-' + $langSufix + '_V' + $docVersion + '.pdf'
} else {
    $name = $internalId + "_" + $fileName
}

# Construct the full local file path
$localFilePath = $localPath + $name

Invoke-WebRequest -Uri $fileDownloadUrl -OutFile $localFilePath -Headers $headers
Write-Output "File successfully downloaded to $localFilePath"


# $destination = "Y:\\TuM\\BuControls\\Produkte\\Safety\\Exchange\\Elvis\\downloadedFiles"
# Copy-Item -path $localFilePath -destination $destination -Recurse


# $username = "brategge\ext_durice"
# $password = ConvertTo-SecureString "Samoje1DOM.2024" -AsPlainText -Force
# $credentials = New-Object System.Management.Automation.PSCredential($username, $password)

# Map the network drive
New-PSDrive -Name "Y" -PSProvider "FileSystem" -Root "\\br-automation.co.at\brdfs01"

# Change directory to the specific folder on the mapped drive
Set-Location -Path "Y:\TuM\BuControls\Produkte\Safety\Exchange\Elvis\downloadedFiles\"

Copy-Item -path $localFilePath -destination $destination -Recurse

<#
$serverPath = "Y:\\TuM\\BuControls\\Produkte\\Safety\\Exchange\\Elvis\\downloadedFiles\\"
$serverFilePath = $serverPath + $name

# Download file directly to the server
Invoke-WebRequest -Uri $fileDownloadUrl -OutFile $serverFilePath -Headers $headers -AllowUnencryptedAuthentication
#>