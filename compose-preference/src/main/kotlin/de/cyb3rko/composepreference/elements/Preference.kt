package de.cyb3rko.composepreference.elements

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import de.cyb3rko.composepreference.internal.Preference

@Composable
fun Preference(
    title: String,
    description: String,
    onClicked: () -> Unit,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    iconPadding: Int = 0,
) {
    Preference(
        title = title,
        description = description,
        onClicked = onClicked,
        enabled = enabled,
        icon = icon,
        iconPadding = iconPadding,
        content = null
    )
}
