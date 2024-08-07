package de.cyb3rko.composepreference.internal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.cyb3rko.composepreference.internal.IconFrame

@Composable
internal fun Preference(
    title: String,
    description: String,
    enabled: Boolean,
    onClicked: () -> Unit,
    icon: ImageVector?,
    iconPadding: Int,
    padding: PaddingValues = PaddingValues(),
    content: (@Composable () -> Unit)?
) {
    val textColor = if (enabled) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    }
    var rowModifier = Modifier.padding(padding)
    if (enabled) {
        rowModifier = rowModifier.clickable { onClicked() }
    }
    Row(
        modifier = rowModifier.padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconFrame(icon = icon, padding = iconPadding)
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .weight(1f)
        ) {
            Text(
                title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
            Text(
                description,
                fontSize = 14.sp,
                color = textColor
            )
        }
        if (content != null) {
            Box(modifier = Modifier.padding(start = 16.dp)) {
                content()
            }
        }
    }
}
