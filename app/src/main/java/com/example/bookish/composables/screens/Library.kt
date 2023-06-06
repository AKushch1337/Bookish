package com.example.bookish.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookish.R
import com.example.bookish.composables.components.LibraryItem

@Composable
fun LibraryScreen() {
    val testTagLib = stringResource(R.string.library_tag)
    val testTagScroll = stringResource(R.string.scroll_tag)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .semantics { testTag = testTagLib }
            .background(Color.White),
    ) {
        Column(modifier = Modifier
            .semantics { testTag = testTagScroll }
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
            repeat(30) {
                LibraryItem()
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview
@Composable
fun LibraryScreenPreview() {
    LibraryScreen()
}