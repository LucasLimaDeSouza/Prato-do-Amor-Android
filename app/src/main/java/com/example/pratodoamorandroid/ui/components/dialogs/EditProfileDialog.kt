package com.example.pratodoamorandroid.ui.components.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.pratodoamorandroid.ui.components.ButtonComponent
import com.example.pratodoamorandroid.ui.components.TextComponent
import com.example.pratodoamorandroid.ui.components.TextFieldComponent
import com.example.pratodoamorandroid.ui.theme.CardColor
import com.example.pratodoamorandroid.ui.theme.ColorLabel
import com.example.pratodoamorandroid.ui.theme.RedTitle
import com.example.pratodoamorandroid.ui.theme.TextColor
import com.example.pratodoamorandroid.ui.utils.TypeTextLabelEnum

@Composable
fun EditProfileDialog(
    onDismiss: () -> Unit,
    onSave: (phone: String, needs: String, allergies: String) -> Unit
) {
    // Estados para os campos de texto
    var cpf by remember { mutableStateOf("000.000.000-00") }
    var phone by remember { mutableStateOf("(11) 98765-4321") }
    var location by remember { mutableStateOf("Porto Novo; Rua Maria Rita") }
    var specialNeeds by remember { mutableStateOf("Mobilidade Reduzida , respiração pesada e sobrepeso impedindo a movimentação") }
    var allergies by remember { mutableStateOf("Lactose, Dipirona") }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = CardColor),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    TextComponent(
                        text = "Editar Informações\nPessoais",
                        fontSize = 22,
                        fontWeight = FontWeight.ExtraBold,
                        color = RedTitle,
                        isTitleOrNo = true,
                        alignCenter = false
                    )
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Fechar",
                            tint = Color.LightGray
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = Color.LightGray.copy(alpha = 0.3f))

                LazyColumn(
                    modifier = Modifier
                        .height(500.dp)
                        .fillMaxWidth(),
                ) {

                    item {

                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            Column {
                                Spacer(modifier = Modifier.height(8.dp))
                                TextComponent(
                                    text = "CPF",
                                    fontSize = 11,
                                    fontWeight = FontWeight.Bold,
                                    color = ColorLabel,
                                    isTitleOrNo = false
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                TextFieldComponent(
                                    value = cpf,
                                    onValueChange = { cpf = it },
                                    textLabel = TypeTextLabelEnum.STRING,

                                    )
                            }
                            Column {
                                TextComponent(
                                    text = "TELEFONE CONTATO",
                                    fontSize = 11,
                                    fontWeight = FontWeight.Bold,
                                    color = ColorLabel,
                                    isTitleOrNo = false
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                TextFieldComponent(
                                    value = phone,
                                    onValueChange = { phone = it },
                                    textLabel = TypeTextLabelEnum.STRING
                                )
                            }
                            Column {
                                TextComponent(
                                    text = "LOCALIZAÇÃO",
                                    fontSize = 11,
                                    fontWeight = FontWeight.Bold,
                                    color = ColorLabel,
                                    isTitleOrNo = false
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                TextFieldComponent(
                                    value = location,
                                    onValueChange = { location = it },
                                    textLabel = TypeTextLabelEnum.STRING
                                )
                            }
                            Column {
                                TextComponent(
                                    text = "NECESSIDADES ESPECIAIS",
                                    fontSize = 11,
                                    fontWeight = FontWeight.Bold,
                                    color = ColorLabel,
                                    isTitleOrNo = false
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                TextFieldComponent(
                                    modifier = Modifier.height(100.dp),
                                    value = specialNeeds,
                                    onValueChange = { specialNeeds = it },
                                    textLabel = TypeTextLabelEnum.STRING,
                                    singleLine = false
                                )
                            }
                            Column {
                                TextComponent(
                                    text = "ALERGIAS",
                                    fontSize = 11,
                                    fontWeight = FontWeight.Bold,
                                    color = ColorLabel,
                                    isTitleOrNo = false
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                TextFieldComponent(
                                    modifier = Modifier.height(100.dp),
                                    value = allergies,
                                    onValueChange = { allergies = it },
                                    textLabel = TypeTextLabelEnum.STRING,
                                    singleLine = false
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        }


                    }
                }
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    // Botão: Salvar
                    ButtonComponent(
                        onClick = { onSave(phone, specialNeeds, allergies) },
                        text = {
                            TextComponent(
                                text = "Salvar Alterações",
                                color = TextColor,
                                fontSize = 16,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    )

                    // Botão: Cancelar
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = ButtonDefaults.outlinedButtonBorder(enabled = true)
                            .copy(width = 1.dp)
                    ) {
                        TextComponent(
                            text = "Cancelar",
                            color = Color.Gray,
                            fontSize = 16,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditProfileDialogPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        EditProfileDialog(
            onDismiss = {},
            onSave = { _, _, _ -> }
        )
    }
}