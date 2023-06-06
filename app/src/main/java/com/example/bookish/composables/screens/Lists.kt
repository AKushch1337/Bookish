package com.example.bookish.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookish.R
import com.example.bookish.composables.components.ListsItem

@Composable
fun ListsScreen() {
    val testListTag = stringResource(R.string.lists_tag)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .semantics { testTag = testListTag },
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
            ListsItem(stringResource(R.string.lists_favorite), Icons.Default.Star)
            ListsItem(stringResource(R.string.lists_to_read), Icons.Default.DateRange)
            ListsItem(stringResource(R.string.lists_finished), Icons.Default.Done)
        }
    }
}

@Preview
@Composable
fun ListsScreenPreview() {
    ListsScreen()
}