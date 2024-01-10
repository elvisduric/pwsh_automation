// Returns document language based on Language jenkins parameter
def getLanguage() {
    switch (params.LANGUAGE) {
        case "Deutsch & English":
            return "de,en"
            break;
        case "Deutsch":
            return "de"
            break;
        case "English":
            return "en"
            break;
        // Add more languages
    }
}

def langSufix(language) {
    switch (language) {
        case 'de': 
            return 'GER'
            break;
        case 'en': return 'ENG'
            break;
        // Add more languages
    }
} 

return this