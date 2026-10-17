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
