package com.example.bookish.composables.screens

import DocumentPicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import com.example.bookish.R

@Composable
fun LibraryScreen() {
    val testTagLib = stringResource(R.string.library_tag)
    // val testTagScroll = stringResource(R.string.scroll_tag)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .semantics { testTag = testTagLib }
            .background(Color.White)
    ) {
        DocumentPicker()
    }
}
