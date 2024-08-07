@file:SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

package de.cyb3rko.composepreference.elements

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PreferenceScreen(
    modifier: Modifier = Modifier,
    preferences: @Composable () -> Unit
) {
    Scaffold(modifier = modifier) {
        Column {
            preferences()
        }
    }
}
