package de.cyb3rko.composepreference.elements

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.cyb3rko.composepreference.Preview

@Composable
fun PreferenceCategory(
    name: String,
    withHorizontalDivider: Boolean = true,
    content: (@Composable () -> Unit)
) {
    Column {
        Text(
            name,
            modifier = Modifier
                .padding(start = 72.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
                .fillMaxWidth(),
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary
        )
        content()
        if (withHorizontalDivider) {
            HorizontalDivider()
        }
    }
}

@Preview("Light Mode")
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreferenceCategoryPreview() {
    Preview {
        PreferenceCategory(name = "Category") {
            PreferenceSwitch(
                title = "Demo Title",
                description = "Demo Description",
                checked = true,
                onCheckedChange = {}
            )
        }
    }
}
