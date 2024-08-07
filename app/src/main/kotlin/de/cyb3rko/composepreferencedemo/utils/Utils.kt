package de.cyb3rko.composepreferencedemo.utils

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import de.cyb3rko.composepreferencedemo.ui.theme.ComposeComponentsTheme

@Preview(name = "Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
internal annotation class ThemedPreview

@Composable
internal fun Preview(content: @Composable () -> Unit) {
    ComposeComponentsTheme {
        Surface {
            content()
        }
    }
}
