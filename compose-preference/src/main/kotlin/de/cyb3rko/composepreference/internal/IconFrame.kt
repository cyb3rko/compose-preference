package de.cyb3rko.composepreference.internal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
internal fun IconFrame(
    icon: ImageVector?,
    padding: Int
) {
    var adjustedPadding = 0
    if (padding in 1..23) {
        adjustedPadding = padding
    }
    if (icon != null) {
        Icon(
            icon,
            null,
            modifier = Modifier
                .padding(
                    start = 16.dp + adjustedPadding.dp,
                    end = 8.dp + adjustedPadding.dp,
                    top = 4.dp,
                    bottom = 4.dp
                )
                .size(48.dp - (2 * adjustedPadding).dp)
        )
    } else {
        Box(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 8.dp,
                    top = 4.dp,
                    bottom = 4.dp
                )
                .size(48.dp)
        )
    }
}
