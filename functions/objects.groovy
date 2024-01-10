// Returns Book Object ID based on Book jenkins parameter
def getObjectId() {
    switch (params.BOOK) {
        case "b_Sicherheitstechnik":
            return "1516132311485"
            break;
        case "Titelseite - Sicherheitstechnik (ab AH 4.6)":
            return "1518393541144"
            break;
        case "b_Allgemeines":
            return "1531249320151"
            break;
        case "b_Bestimmungsgemasse Verwendung":
            return "1516132310678"
            break;
        case "b_Verwendung von Sensoren und Aktoren":
            return "1516132314357"
            break;
        case "b_Hardware":
            return "1512108759773"
            break;
        case "b_mapp Safety":
            return "1512108760206"
            break;
        case "X20SA4430":
            return "1512108773341"
            break;
        case "X20SO6300":
            return "1512108774559"
            break;
        case "X20SOx1x0":
            return "1512108774950"
            break;
        case "X20SIx1x0":
            return "1512108775907"
            break;
        case "X20SC0xxx":
            return "1512108777205"
            break;
        case "X20SC2212":
            return "1512108777804"
            break;
        case "X20SC2432":
            return "1512108778317"
            break;
        case "X20SP1130":
            return "1513366066748"
            break;
        case "X20SLXx1x":
            return "1512108776683"
            break;
        case "X20SLXxxx":
            return "1513366066246"
            break;
        case "X20SRTxxx":
            return "1513366066475"
            break;
        case "X20SL81xx":
            return "1513366067559"
            break;
        case "X20ST4492":
            return "1512108773473"
            break;
        case "X20SD1207":
            return "1513366068987"
            break;
        case "X67SI8103":
            return "1513366069209"
            break;
        case "X67SC4122.L12":
            return "1513366069929"
            break;
        case "B050006543xx-yy und B050006677xx-yy":
            return "1513366071774"
            break;
        case "X20BM23, X20BM26, X20BM33, X20BM36":
            return "1512108773776"
            break;
        case "X20TB52, X20TB72, X20TB5E, X20TB5F":
            return "1513366066894"
            break;
        case "X20SOx530":
            return "1512108774317"
            break;
        case "X20MK0223":
            return "1513366071755"
            break;
        }
}

return this