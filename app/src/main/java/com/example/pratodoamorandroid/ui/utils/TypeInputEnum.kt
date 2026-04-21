package com.example.pratodoamorandroid.ui.utils

enum class TypeInputEnum(val id: Int) {
    STRING(0),
    EMAIL(1),
    PASSWORD(2)
}

enum class TypeTextLabelEnum(val id: String) {
    STRING(""),
    EMAIL("nome@exemplo.com"),
    PASSWORD("senha")
}

enum class TypeTextTitleEnum(val id: String) {
    TOTAL("TOTAL"),
    VISITS("VISITAS"),
}