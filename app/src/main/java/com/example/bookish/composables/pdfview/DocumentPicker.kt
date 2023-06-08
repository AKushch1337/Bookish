package com.example.bookish.composables.pdfview

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.rememberVerticalPdfReaderState

@Composable
fun DocumentPicker() {
    val result = remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) {
        result.value = it
    }

    val isPdfSelected = result.value != null

    Column(modifier = Modifier.fillMaxSize()) {
        result.value?.let { uri ->
            val pdfState = rememberVerticalPdfReaderState(
                resource = ResourceType.Local(uri),
                isZoomEnable = true
            )
            PDFView(
                pdfState = pdfState,
                scaffoldState = rememberScaffoldState()
            )
        }

        if (!isPdfSelected) {
            Scaffold(floatingActionButton = {
                FloatingActionButton(
                    onClick = { launcher.launch(arrayOf("application/pdf")) },
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Open Doc")
                }
            }
            ) { contentPadding ->
                Box(modifier = Modifier.padding(contentPadding)) {
                }
            }
        }
    }
}
