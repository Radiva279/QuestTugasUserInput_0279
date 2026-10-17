package com.example.tugas5

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.tugas5.R
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBiodata(modifier: Modifier = Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }

    var skillAndroid by remember { mutableStateOf(false) }
    var skillUiux by remember { mutableStateOf(false) }
    var skillWeb by remember { mutableStateOf(false) }

    var dropdownBuka by remember { mutableStateOf(false) }
    var kalenderBuka by remember { mutableStateOf(false) }
    var popupBuka by remember { mutableStateOf(false) }
    var dataValid by remember { mutableStateOf(false) }
    var hasilSkill by remember { mutableStateOf("") }

    val ungu = colorResource(R.color.primaryPurple)
    val putih = colorResource(R.color.surfaceWhite)
    val warnaTeks = colorResource(R.color.textPrimary)
    val warnaSekunder = colorResource(R.color.textSecondary)
    val warnaBorder = colorResource(R.color.borderColor)
    val warnaNonaktif = colorResource(R.color.disabledColor)

    val pilihanPengalaman = listOf(
        stringResource(R.string.experienceOne),
        stringResource(R.string.experienceTwo),
        stringResource(R.string.experienceMore)
    )

    val teksAndroid = stringResource(R.string.skillAndroid)
    val teksUiux = stringResource(R.string.skillUiux)
    val teksWeb = stringResource(R.string.skillWeb)
    val teksOk = stringResource(R.string.dialogOk)

    LaunchedEffect(popupBuka) {
        if (popupBuka) {
            delay(5000)
            popupBuka = false
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.bg_neon),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = dimensionResource(R.dimen.pagePadding),
                    vertical = 16.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(dimensionResource(R.dimen.cardRadius)),
                        clip = false
                    ),
                shape = RoundedCornerShape(
                    dimensionResource(R.dimen.cardRadius)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = putih
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 22.dp, vertical = 22.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = stringResource(R.string.formTitle),
                        modifier = Modifier.fillMaxWidth(),
                        color = ungu,
                        fontSize = dimensionResource(R.dimen.titleSize).value.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = stringResource(R.string.formSubtitle),
                        modifier = Modifier.fillMaxWidth(),
                        color = warnaSekunder,
                        fontSize = dimensionResource(R.dimen.subtitleSize).value.sp,
                        textAlign = TextAlign.Center
                    )

                    // Nama Depan & Nama Belakang
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            modifier = Modifier.weight(1f),
                            label = {
                                Text(
                                    stringResource(R.string.firstName),
                                    fontSize = 11.sp,
                                    maxLines = 1
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.fieldRadius)
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = ungu,
                                unfocusedBorderColor = warnaBorder
                            )
                        )

                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            modifier = Modifier.weight(1f),
                            label = {
                                Text(
                                    stringResource(R.string.lastName),
                                    fontSize = 11.sp,
                                    maxLines = 1
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.fieldRadius)
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = ungu,
                                unfocusedBorderColor = warnaBorder
                            )
                        )
                    }

                    // Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(stringResource(R.string.email), fontSize = 12.sp)
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        shape = RoundedCornerShape(
                            dimensionResource(R.dimen.fieldRadius)
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = ungu,
                            unfocusedBorderColor = warnaBorder
                        )
                    )

                    // Tgl Lahir & Experience
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Tgl Lahir
                        OutlinedTextField(
                            value = tanggalLahir,
                            onValueChange = {},
                            readOnly = true,
                            enabled = false,
                            textStyle = TextStyle(fontSize = 12.sp),
                            modifier = Modifier
                                .weight(1f)
                                .clickable { kalenderBuka = true },
                            label = {
                                Text(
                                    stringResource(R.string.birthDate),
                                    fontSize = 10.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            placeholder = {
                                Text(stringResource(R.string.birthDateHint), fontSize = 10.sp)
                            },
                            trailingIcon = {
                                Text(
                                    "📅",
                                    fontSize = 12.sp,
                                    modifier = Modifier
                                        .padding(end = 2.dp)
                                        .clickable { kalenderBuka = true }
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(
                                dimensionResource(R.dimen.fieldRadius)
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                disabledTextColor = warnaTeks,
                                disabledBorderColor = warnaBorder,
                                disabledLabelColor = warnaSekunder
                            )
                        )

                        // Experience
                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = pengalaman,
                                onValueChange = {},
                                readOnly = true,
                                enabled = false,
                                textStyle = TextStyle(fontSize = 12.sp),
                                modifier = Modifier.fillMaxWidth(),
                                label = {
                                    Text(
                                        stringResource(R.string.experience),
                                        fontSize = 10.sp, // Font dipastiin cukup kecil agar muat 1 baris
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                },
                                trailingIcon = {
                                    Text(
                                        "▼",
                                        color = warnaTeks,
                                        fontSize = 10.sp,
                                        modifier = Modifier.padding(end = 2.dp)
                                    )
                                },
                                singleLine = true,
                                shape = RoundedCornerShape(
                                    dimensionResource(R.dimen.fieldRadius)
                                ),
                                colors = OutlinedTextFieldDefaults.colors(
                                    disabledTextColor = warnaTeks,
                                    disabledBorderColor = warnaBorder,
                                    disabledLabelColor = warnaSekunder
                                )
                            )

                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable {
                                        dropdownBuka = true
                                    }
                            )

                            DropdownMenu(
                                expanded = dropdownBuka,
                                onDismissRequest = {
                                    dropdownBuka = false
                                }
                            ) {
                                pilihanPengalaman.forEach { pilihan ->
                                    DropdownMenuItem(
                                        text = { Text(pilihan, fontSize = 12.sp) },
                                        onClick = {
                                            pengalaman = pilihan
                                            dropdownBuka = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Text(
                        text = stringResource(R.string.skillTitle),
                        color = warnaTeks,
                        fontSize = dimensionResource(R.dimen.labelSize).value.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            SkillItem(
                                label = teksAndroid,
                                checked = skillAndroid,
                                onCheckedChange = { skillAndroid = it },
                                tint = ungu
                            )
                        }

                        Box(modifier = Modifier.weight(1f)) {
                            SkillItem(
                                label = teksUiux,
                                checked = skillUiux,
                                onCheckedChange = { skillUiux = it },
                                tint = ungu
                            )
                        }

                        Box(modifier = Modifier.weight(1f)) {
                            SkillItem(
                                label = teksWeb,
                                checked = skillWeb,
                                onCheckedChange = { skillWeb = it },
                                tint = ungu
                            )
                        }
                    }

                    Button(
                        onClick = {
                            dataValid =
                                namaDepan.isNotBlank() &&
                                        namaBelakang.isNotBlank() &&
                                        Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                                        tanggalLahir.isNotBlank() &&
                                        pengalaman.isNotBlank() &&
                                        (skillAndroid || skillUiux || skillWeb)

                            if (dataValid) {
                                hasilSkill = listOfNotNull(
                                    if (skillAndroid) teksAndroid else null,
                                    if (skillUiux) teksUiux else null,
                                    if (skillWeb) teksWeb else null
                                ).joinToString(", ")
                            }

                            popupBuka = true
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(R.dimen.buttonHeight)),
                        enabled = namaDepan.isNotBlank() &&
                                namaBelakang.isNotBlank() &&
                                email.isNotBlank() &&
                                tanggalLahir.isNotBlank() &&
                                pengalaman.isNotBlank() &&
                                (skillAndroid || skillUiux || skillWeb),
                        shape = RoundedCornerShape(
                            dimensionResource(R.dimen.fieldRadius)
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ungu,
                            disabledContainerColor = warnaNonaktif,
                            disabledContentColor = putih
                        )
                    ) {
                        Text(stringResource(R.string.proceed))
                    }
                }
            }
        }

        if (kalenderBuka) {
            val stateKalender = rememberDatePickerState()

            DatePickerDialog(
                onDismissRequest = { kalenderBuka = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            stateKalender.selectedDateMillis?.let { millis ->
                                tanggalLahir = SimpleDateFormat(
                                    "dd-MM-yyyy",
                                    Locale.getDefault()
                                ).format(Date(millis))
                            }
                            kalenderBuka = false
                        }
                    ) {
                        Text(teksOk)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { kalenderBuka = false }
                    ) {
                        Text("Batal")
                    }
                }
            ) {
                DatePicker(state = stateKalender)
            }
        }

        if (popupBuka) {
            Dialog(onDismissRequest = { popupBuka = false }) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = putih
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(22.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = if (dataValid) {
                                stringResource(R.string.submitSuccess)
                            } else {
                                stringResource(R.string.submitError)
                            },
                            color = warnaTeks,
                            fontWeight = FontWeight.Bold
                        )

                        if (dataValid) {
                            HorizontalDivider(color = warnaBorder)

                            Text(
                                stringResource(R.string.resultTitle),
                                color = ungu
                            )
                            Text(
                                stringResource(
                                    R.string.resultName,
                                    namaDepan,
                                    namaBelakang
                                ),
                                color = warnaTeks
                            )
                            Text(
                                stringResource(R.string.resultEmail, email),
                                color = warnaTeks
                            )
                            Text(
                                stringResource(
                                    R.string.resultBirthDate,
                                    tanggalLahir
                                ),
                                color = warnaTeks
                            )
                            Text(
                                stringResource(
                                    R.string.resultExperience,
                                    pengalaman
                                ),
                                color = warnaTeks
                            )
                            Text(
                                stringResource(
                                    R.string.resultSkills,
                                    hasilSkill
                                ),
                                color = warnaTeks
                            )
                        }

                        TextButton(onClick = { popupBuka = false }) {
                            Text(teksOk, color = ungu)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SkillItem(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    tint: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChange(!checked)
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.size(32.dp),
            colors = CheckboxDefaults.colors(
                checkedColor = tint
            )
        )

        Text(
            text = label,
            fontSize = 11.sp,
            maxLines = 1
        )
    }
}