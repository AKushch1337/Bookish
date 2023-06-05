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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookish.R

@Composable
fun SettingsScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.settings),
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = stringResource(R.string.display_settings),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            DropDownSetting(stringResource(R.string.font_size), stringArrayResource(R.array.dropdown_options1))
            // SwitchSetting(stringResources(R.id.theme), true)
            DropDownSetting(stringResource(R.string.margin_size), stringArrayResource(R.array.dropdown_options1))

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.read_preferences),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            // SwitchSetting(stringResource(R.string.auto_night_mode), true)
            DropDownSetting(stringResource(R.string.highlight), stringArrayResource(R.array.dropdown_options2))
            DropDownSetting(stringResource(R.string.read_progress), stringArrayResource(R.array.dropdown_options3))

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /* Save settings logic */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = stringResource(R.string.save))
            }
        }
    }
}

@Composable
fun DropDownSetting(name: String, options: Array<String>) {
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
                    contentDescription = stringResource(R.string.expand),
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
