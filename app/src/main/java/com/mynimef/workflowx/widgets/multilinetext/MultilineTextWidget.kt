package com.mynimef.workflowx.widgets.multilinetext

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MultilineTextWidget(
    dataProvider: () -> MultilineTextWidgetData,
    modifier: Modifier = Modifier
) {
    val data = dataProvider()
    Text(
        modifier = modifier,
        text = data.text
    )
}