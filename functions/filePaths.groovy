// Returns file path of XML Payload based on Book and Category jenkins parameters
def getFilePath(category) {
    if (params.BOOK == 'X20SA4430') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SA4430\\X20SA4430_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SA4430\\X20SA4430_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SA4430\\X20SA4430_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SA4430\\X20SA4430_AsHelp.xml'
                break;
            default: 'Category name was not recognized.'
        }
    } else if (params.BOOK == 'Titelseite - Sicherheitstechnik (ab AH 4.6)') {
        switch (category) {
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\TitelseiteSicherheitstechnik\\TitelseiteSicherheitstechnik_AsHelp.xml'
                break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'b_Allgemeines') {
        switch (category) {
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_Allgemeines\\b_Allgemeines_AsHelp.xml'
                break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'b_Bestimmungsgemasse Verwendung') {
        switch (category) {
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_BestimmungsgemasseVerwendung\\b_BestimmungsgemasseVerwendung_AsHelp.xml'
                break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'b_Verwendung von Sensoren und Aktoren') {
        switch (category) {
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_VerwendungVonSensorenUndAktoren\\b_VerwendungVonSensorenUndAktoren_AsHelp.xml'
                break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'b_Hardware') {
        switch (category) {
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_Hardware\\b_Hardware_AsHelp.xml'
                break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'b_mapp Safety') {
        switch (category) {
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_mappSafety\\b_mappSafety_AsHelp.xml'
                break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'b_Sicherheitstechnik') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_Sicherheitstechnik\\b_Sicherheitstechnik_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_Sicherheitstechnik\\b_Sicherheitstechnik_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_Sicherheitstechnik\\b_Sicherheitstechnik_Homepage.xml'
                break;
            case 'For Franz':
                return 'C:\\Projekte\\DocuTeam\\payloads\\b_Sicherheitstechnik\\b_Sicherheitstechnik_ForFranz.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SO6300') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SO6300\\X20SO6300_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SO6300\\X20SO6300_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SO6300\\X20SO6300_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SO6300\\X20SO6300_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SOx1x0') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SOx1x0\\X20SOx1x0_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SOx1x0\\X20SOx1x0_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SOx1x0\\X20SOx1x0_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SOx1x0\\X20SOx1x0_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SIx1x0') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SIx1x0\\X20SIx1x0_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SIx1x0\\X20SIx1x0_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SIx1x0\\X20SIx1x0_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SIx1x0\\X20SIx1x0_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SC0xxx') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC0xxx\\X20SC0xxx_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC0xxx\\X20SC0xxx_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC0xxx\\X20SC0xxx_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC0xxx\\X20SC0xxx_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SC2212') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC2212\\X20SC2212_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC2212\\X20SC2212_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC2212\\X20SC2212_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC2212\\X20SC2212_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SC2432') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC2432\\X20SC2432_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC2432\\X20SC2432_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC2432\\X20SC2432_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SC2432\\X20SC2432_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SP1130') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SP1130\\X20SP1130_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SP1130\\X20SP1130_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SP1130\\X20SP1130_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SP1130\\X20SP1130_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SLXx1x') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SLXx1x\\X20SLXx1x_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SLXx1x\\X20SLXx1x_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SLXx1x\\X20SLXx1x_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SLXx1x\\X20SLXx1x_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SLXxxx') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SLXxxx\\X20SLXxxx_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SLXxxx\\X20SLXxxx_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SLXxxx\\X20SLXxxx_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SLXxxx\\X20SLXxxx_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SRTxxx') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SRTxxx\\X20SRTxxx_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SRTxxx\\X20SRTxxx_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SRTxxx\\X20SRTxxx_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SRTxxx\\X20SRTxxx_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SL81xx') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SL81xx\\X20SL81xx_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SL81xx\\X20SL81xx_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SL81xx\\X20SL81xx_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SL81xx\\X20SL81xx_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20ST4492') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20ST4492\\X20ST4492_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20ST4492\\X20ST4492_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20ST4492\\X20ST4492_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20ST4492\\X20ST4492_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SD1207') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SD1207\\X20SD1207_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SD1207\\X20SD1207_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SD1207\\X20SD1207_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SD1207\\X20SD1207_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X67SI8103') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X67SI8103\\X67SI8103_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X67SI8103\\X67SI8103_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X67SI8103\\X67SI8103_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X67SI8103\\X67SI8103_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X67SC4122.L12') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X67SC4122.L12\\X67SC4122.L12_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X67SC4122.L12\\X67SC4122.L12_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X67SC4122.L12\\X67SC4122.L12_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X67SC4122.L12\\X67SC4122.L12_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'B050006543xx-yy und B050006677xx-yy') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\B050006543xx-yy-und-B050006677xx-yy\\B050006543xx-yy-und-B050006677xx-yy_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\B050006543xx-yy-und-B050006677xx-yy\\B050006543xx-yy-und-B050006677xx-yy_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\B050006543xx-yy-und-B050006677xx-yy\\B050006543xx-yy-und-B050006677xx-yy_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\B050006543xx-yy-und-B050006677xx-yy\\B050006543xx-yy-und-B050006677xx-yy_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20BM23, X20BM26, X20BM33, X20BM36') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20BM23-X20BM26-X20BM33-X20BM36\\X20BM23-X20BM26-X20BM33-X20BM36_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20BM23-X20BM26-X20BM33-X20BM36\\X20BM23-X20BM26-X20BM33-X20BM36_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20BM23-X20BM26-X20BM33-X20BM36\\X20BM23-X20BM26-X20BM33-X20BM36_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20BM23-X20BM26-X20BM33-X20BM36\\X20BM23-X20BM26-X20BM33-X20BM36_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20TB52, X20TB72, X20TB5E, X20TB5F') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20TB52-X20TB72-X20TB5E-X20TB5F\\X20TB52-X20TB72-X20TB5E-X20TB5F_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20TB52-X20TB72-X20TB5E-X20TB5F\\X20TB52-X20TB72-X20TB5E-X20TB5F_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20TB52-X20TB72-X20TB5E-X20TB5F\\X20TB52-X20TB72-X20TB5E-X20TB5F_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20TB52-X20TB72-X20TB5E-X20TB5F\\X20TB52-X20TB72-X20TB5E-X20TB5F_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20SOx530') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SOx530\\X20SOx530_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SOx530\\X20SOx530_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SOx530\\X20SOx530_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20SOx530\\X20SOx530_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else if (params.BOOK == 'X20MK0223') {
        switch (category) {
            case 'TUV':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20MK0223\\X20MK0223_TUV.xml'
                break;
            case 'TUV (diff)':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20MK0223\\X20MK0223_TUV_Diff.xml'
                break;
            case 'Homepage':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20MK0223\\X20MK0223_Homepage.xml'
                break;
            case 'AS Help':
                return 'C:\\Projekte\\DocuTeam\\payloads\\X20MK0223\\X20MK0223_AsHelp.xml'
            break;
            default: "Category name was not recognized."
        }
    } else {
        return "Values don't match criteria";
    }
}

return this