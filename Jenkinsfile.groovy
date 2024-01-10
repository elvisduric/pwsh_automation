// Function definitions

// Returns selected SMC environment based on Environment jenkins parameter
def getEnvironment() {
    def PRODUCTION = 'http://smc.br-automation.com'
    def TEST = 'http://smc-qs.br-automation.co.at'
    
    if (params.ENVIRONMENT == 'Production') {
        return PRODUCTION;
    } else { 
        return TEST;
    }
}

// Jenkins Pipeline Definition
pipeline {
    agent any

    parameters {
        // Default choice is the first one in array
        choice(name: 'ENVIRONMENT', choices: ['Test', 'Production'], description: 'SMC Application Environment')
        choice(name: 'BOOK', choices: [
            'Please select...',
            'b_Sicherheitstechnik',
            'Titelseite - Sicherheitstechnik (ab AH 4.6)',
            'b_Allgemeines',
            'b_Bestimmungsgemasse Verwendung',
            'b_Verwendung von Sensoren und Aktoren',
            'b_Hardware',
            'b_mapp Safety',
            'X20SA4430',
            'X20SO6300',
            'X20SOx1x0',
            'X20SIx1x0',
            'X20SC0xxx',
            'X20SC2212',
            'X20SC2432',
            'X20SP1130',
            'X20SLXx1x',
            'X20SLXxxx',
            'X20SRTxxx',
            'X20SL81xx',
            'X20ST4492',
            'X20SD1207',
            'X67SI8103',
            'X67SC4122.L12',
            'B050006543xx-yy und B050006677xx-yy',
            'X20BM23, X20BM26, X20BM33, X20BM36',
            'X20TB52, X20TB72, X20TB5E, X20TB5F',
            'X20SOx530',
            'X20MK0223'] )
        string(name: 'VERSION', description: 'Latest would be used by default. Please enter if you want specific document version //e.g. 1.2')
        choice(name: 'LANGUAGE', choices: ['Deutsch & English', 'Deutsch', 'English'])
    }
    
    environment {
        // Get the selected environment URL
        BASEURL = getEnvironment();
        CATEGORY = "${CATEGORY}";
    }

    stages {
        stage('Authorization & Initialization') {
            steps {
                script {
                    // Execute PowerShell script to capture Base64Authentication
                    env.BASE64AUTH = pwsh(script: ('''\\Projekte\\DocuTeam\\scripts\\authorization.ps1'''), returnStdout: true).trim()

                    // Execute PowerShell script to capture xsrf Token
                    env.XSRFTOKEN = pwsh(script: ('''
                    $base64Auth = "''' + env.BASE64AUTH + '''"
                    $baseUrl = "''' + env.BASEURL + '''";
                    \\Projekte\\DocuTeam\\scripts\\getXsrfToken.ps1'''), returnStdout: true).trim()

                    // Execute PowerShell script to capture JSession Id
                    env.JSESSIONID = pwsh(script: ('''
                    $base64Auth = "''' + env.BASE64AUTH + '''"
                    $baseUrl = "''' + env.BASEURL + '''";
                    \\Projekte\\DocuTeam\\scripts\\getJSessionId.ps1'''), returnStdout: true).trim()
                }
            }
        }

        stage('Fetch Object Versions') {
            steps {
                script {
                    // Import the groovy Objects script
                    def objects = load 'C:\\Projekte\\DocuTeam\\functions\\objects.groovy'

                    // Execute PowerShell script to capture latest object version
                    env.LATEST_V = pwsh(script: ('''
                    $base64Auth = "''' + env.BASE64AUTH + '''"
                    $baseUrl = "''' + env.BASEURL + '''"
                    $objectId = "''' + objects.getObjectId() + '''";
                    \\Projekte\\DocuTeam\\scripts\\getLatestVersion.ps1'''), returnStdout: true).trim()

                    // Execute PowerShell script to capture before last version
                    env.BEFORELAST_V = pwsh(script: ('''
                    $base64Auth = "''' + env.BASE64AUTH + '''"
                    $baseUrl = "''' + env.BASEURL + '''"
                    $objectId = "''' + objects.getObjectId() + '''";
                    \\Projekte\\DocuTeam\\scripts\\getBeforeLastVersion.ps1'''), returnStdout: true).trim()

                    env.OBJECT_URI = pwsh(script: ('''
                    $base64Auth = "''' + env.BASE64AUTH + '''"
                    $baseUrl = "''' + env.BASEURL + '''"
                    $objectId = "''' + objects.getObjectId() + '''";
                    \\Projekte\\DocuTeam\\scripts\\getObjectUri.ps1'''), returnStdout: true).trim()
                }
            }
        }

        stage('Language Identification') {
            steps {
                script {
                    // Import the groovy scripts for Languages and Payload File Paths
                    def langs = load 'C:\\Projekte\\DocuTeam\\functions\\languages.groovy'
                    def filePaths = load 'C:\\Projekte\\DocuTeam\\functions\\filePaths.groovy'

                    def filePath = filePaths.getFilePath(env.CATEGORY);
                    println 'Payload File Path is: ' + filePath

                    def selectedLanguages = langs.getLanguage();
                    def languages = selectedLanguages.tokenize(',');
                    languages.each { language ->
                        stage("Generating version: ${language}") {
                            // Execute PowerShell script to capture task Id
                            env.TASKID = pwsh(script: ('''
                            $base64Auth = "''' + env.BASE64AUTH + '''"
                            $baseUrl = "''' + env.BASEURL + '''"
                            $xsrfTokenValue = "''' + env.XSRFTOKEN + '''"
                            $jsessionIdValue = "''' + env.JSESSIONID + '''"
                            $version = "''' + env.LATEST_V + '''"
                            $specificVersion = "''' + params.VERSION + '''"
                            $diffVersion = "''' + env.BEFORELAST_V + '''"
                            $filePath = "''' + filePath + '''"
                            $brokerUrl = "''' + getEnvironment() + '''"
                            $objectUri = "''' + env.OBJECT_URI + '''"
                            $language = "''' + language + '''";
                            \\Projekte\\DocuTeam\\scripts\\generateObjectDocument.ps1'''), returnStdout: true).trim()

                            println "Task ID is: " + env.TASKID

                            // Execute PowerShell script and capture internal Id
                            env.INTERNALID = pwsh(script: ('''
                            $base64Auth = "''' + env.BASE64AUTH + '''"
                            $baseUrl = "''' + env.BASEURL + '''"
                            $taskId = "''' + env.TASKID + '''";
                            \\Projekte\\DocuTeam\\scripts\\checkTaskStatusScript.ps1'''), returnStdout: true).trim()

                            // Execute PowerShell script and capture version
                            env.DOC_VERSION = pwsh(script: ('''
                            $base64Auth = "''' + env.BASE64AUTH + '''"
                            $baseUrl = "''' + env.BASEURL + '''"
                            $taskId = "''' + env.TASKID + '''";
                            \\Projekte\\DocuTeam\\scripts\\getDocumentVersion.ps1'''), returnStdout: true).trim()

                            // Execute PowerShell script to capture local File Path
                            env.OUTPUT_PATH = pwsh(script: ('''
                            $base64Auth = "''' + env.BASE64AUTH + '''"
                            $baseUrl = "''' + env.BASEURL + '''"
                            $taskId = "''' + env.TASKID + '''"
                            $bookName = "''' + params.BOOK + '''"
                            $internalId = "''' + env.INTERNALID + '''"
                            $langSufix = "''' + langs.langSufix(language) + '''"
                            $docVersion = "''' + env.DOC_VERSION + '''"
                            $category = "''' + env.CATEGORY + '''";
                            \\Projekte\\DocuTeam\\scripts\\downloadDocument.ps1'''), returnStdout: true).trim()

                            println "File Path is: " + env.OUTPUT_PATH
                        }
                    }
                }
            }
        }
    }
}