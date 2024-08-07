@file:OptIn(ExperimentalMaterial3Api::class)

package de.cyb3rko.composepreferencedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import de.cyb3rko.composepreferencedemo.ui.theme.ComposeComponentsTheme
import de.cyb3rko.composepreference.elements.Preference
import de.cyb3rko.composepreference.elements.PreferenceCategory
import de.cyb3rko.composepreference.elements.PreferenceScreen
import de.cyb3rko.composepreference.elements.PreferenceSwitch
import de.cyb3rko.composepreferencedemo.utils.Preview
import de.cyb3rko.composepreferencedemo.utils.ThemedPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeComponentsTheme {
                Surface {
                    Scaffold(
                        topBar = { AppBar() }
                    ) { padding ->
                        Preferences(padding = padding)
                    }
                }
            }
        }
    }
}

@Composable
private fun AppBar() {
    TopAppBar(title = { Text("Settings Demo") })
}

@Composable
private fun Preferences(padding: PaddingValues = PaddingValues()) {
    val context = LocalContext.current
    var switch1 by remember { mutableStateOf(true) }
    var switch2 by remember { mutableStateOf(true) }
    PreferenceScreen(modifier = Modifier.padding(padding)) {
        PreferenceCategory(name = "Category") {
            Preference(
                title = "Simple Preference",
                description = "Description",
                onClicked = {
                    Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT)
                        .show()
                },
                icon = Icons.Default.Settings,
                iconPadding = 4
            )
            PreferenceSwitch(
                title = "Switch Preference",
                description = "Switch Description",
                switch1,
                onCheckedChange = { checked ->
                    switch1 = checked
                }
            )
            PreferenceSwitch(
                title = "Disabled switch preference",
                description = "Disabled Description",
                switch2,
                onCheckedChange = { checked ->
                    switch2 = checked
                },
                enabled = false
            )
        }
    }
}

@ThemedPreview
@Composable
private fun PreferencesPreview() {
    Preview {
        Preferences()
    }
}
