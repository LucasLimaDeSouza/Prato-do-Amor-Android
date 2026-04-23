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

enum class TextLabelEnum(val id: String) {
    SEARCH("Buscar por nome ou endereço..."),
    IDENTIFICATION("Como a pessoa prefere ser chamada?"),
    LOCATION("Ex: Praça Central, Marquise do Banco..."),
    DETAILSOFVISIT("Ex: Tatuagem no braço, vestindo casaco azul..."),
    ABOUTVISIT("detalhes sobre o atendimento...")
}

enum class TextTitleEnum(val id: String) {
    TOTAL("TOTAL"),
    VISITS("VISITAS"),
}