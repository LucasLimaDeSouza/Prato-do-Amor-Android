package com.example.pratodoamorandroid.domain.model

import com.example.pratodoamorandroid.ui.utils.TypeSexEnum

data class PeopleModel (
    val name: String,
    val cpf: String = "",
    val sex: String = TypeSexEnum.M.id,
    val location: String = "",
    val tell: String = "",
    val specialNeeds: String = "",
    val allergies: String = "",
)