package de.cyb3rko.composepreference.elements

import android.content.res.Configuration
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import de.cyb3rko.composepreference.Preview
import de.cyb3rko.composepreference.internal.Preference

@Composable
fun PreferenceSwitch(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (checked: Boolean) -> Unit,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    iconPadding: Int = 0,
) {
    Preference(
        title = title,
        description = description,
        enabled = enabled,
        onClicked = { onCheckedChange(!checked) },
        icon = icon,
        iconPadding = iconPadding,
    ) {
        Switch(
            enabled = enabled,
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview("Light Mode")
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreferenceSwitchPreview() {
    Preview {
        PreferenceSwitch(
            title = "Demo Title",
            description = "Demo Description",
            checked = true,
            onCheckedChange = {}
        )
    }
}

@Preview("Light Mode")
@Preview("Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreferenceSwitchDisabledPreview() {
    Preview {
        PreferenceSwitch(
            title = "Demo Title",
            description = "Demo Description",
            checked = true,
            onCheckedChange = {},
            enabled = false
        )
    }
}
