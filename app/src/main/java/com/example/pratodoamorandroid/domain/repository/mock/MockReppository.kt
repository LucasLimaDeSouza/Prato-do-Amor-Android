package com.example.pratodoamorandroid.domain.repository.mock

import com.example.pratodoamorandroid.domain.model.HelpModel
import com.example.pratodoamorandroid.domain.model.PeopleModel
import com.example.pratodoamorandroid.ui.utils.TypeSexEnum

class MockReppository {

    fun getHelpHistory(): List<HelpModel> {
        return listOf(
            HelpModel(
                help = "Ajuda Alimentícia",
                description = "Entrega de cesta básica e marmitas prontas.",
                date = "10/10/2023"
            ),
            HelpModel(
                help = "Ajuda de Higiene",
                description = "Entrega de kit de higiene pessoal e banho.",
                date = "11/10/2023"
            ),
            HelpModel(
                help = "Ajuda de Medicamento",
                description = "Fornecimento de medicamentos prescritos e curativos.",
                date = "12/10/2023"
            )
        )
    }

    fun getPeople(): List<PeopleModel> {
        return listOf(
            PeopleModel(
                name = "Reginaldo Fonseca da Silva",
                cpf = "000.000.000-00",
                sex = TypeSexEnum.M.id,
                location = "Porto Novo; Rua Maria Rita",
                tell = "(21) 9 9999-9999",
                specialNeeds = "Sem registro",
                allergies = "Sem registro"


            ),


            PeopleModel(
                name = "Reginaldo Fonseca da Silva",
                cpf = "000.000.000-00",
                sex = TypeSexEnum.F.id,
                location = "Porto Novo; Rua Maria Rita",
                tell = "(21) 9 9999-9999",
                specialNeeds = "Sem registro",
                allergies = "Sem registro"


            ),

            PeopleModel(
                name = "Reginaldo Fonseca da Silva",
                cpf = "000.000.000-00",
                sex = TypeSexEnum.O.id,
                location = "Porto Novo; Rua Maria Rita",
                tell = "(21) 9 9999-9999",
                specialNeeds = "Sem registro",
                allergies = "Sem registro"


            )
        )
    }
}