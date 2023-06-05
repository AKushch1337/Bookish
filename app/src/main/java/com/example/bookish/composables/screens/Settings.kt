package com.example.bookish.composables.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Display Settings",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            DropDownSetting("Font Size", listOf("Small", "Medium", "Large"))
            // SwitchSetting("Theme", true)
            DropDownSetting("Margin Size", listOf("Small", "Medium", "Large"))

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Reading Preferences",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            SwitchSetting("Auto Night Mode", true)
            DropDownSetting("Highlight Color", listOf("Yellow", "Green", "Blue"))
            DropDownSetting("Reading Progress", listOf("Page Number", "Percentage"))

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /* Save settings logic */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Composable
fun DropDownSetting(name: String, options: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = name, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            TextButton(
                onClick = { expanded = true }
            ) {
                Text(text = options[selectedIndex])
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Expand",
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEachIndexed { index, option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedIndex = index
                            expanded = false
                        }
                    ) {
                        Text(text = option)
                    }
                }
            }
        }
    }
}

@Composable
fun SwitchSetting(name: String, checked: Boolean) {
    var isChecked by remember { mutableStateOf(checked) }

    Row(
        modifier = Modifier.padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = name, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colors.primary)
        )
    }
}
@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
