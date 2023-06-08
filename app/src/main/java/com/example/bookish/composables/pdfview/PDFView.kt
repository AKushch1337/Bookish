package com.example.bookish.composables.pdfview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.VerticalPdfReaderState

@Composable
fun PDFView(
    pdfState: VerticalPdfReaderState,
    scaffoldState: ScaffoldState
) {
    Box(
        contentAlignment = Alignment.TopStart
    ) {
        VerticalPDFReader(
            state = pdfState,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.surface.copy(alpha = 0.5f),
                            shape = MaterialTheme.shapes.medium
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Page: ${pdfState.currentPage}/${pdfState.pdfPageCount}",
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 4.dp,
                            top = 8.dp
                        )
                    )
                    Text(
                        text = if (pdfState.isScrolling) {
                            "Scrolling"
                        } else {
                            "Stationary"
                        },
                        color = if (pdfState.isScrolling) {
                            MaterialTheme.colors.onSurface
                        } else {
                            MaterialTheme.colors.error
                        },
                        modifier = Modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp,
                            top = 4.dp
                        )
                    )
                }
            }
        }
        LaunchedEffect(key1 = pdfState.error) {
            pdfState.error?.let {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = it.message ?: "Error"
                )
            }
        }
    }
}