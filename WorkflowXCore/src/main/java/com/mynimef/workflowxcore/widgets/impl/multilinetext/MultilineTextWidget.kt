package com.mynimef.workflowxcore.widgets.impl.multilinetext

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MultilineTextWidget(
    dataProvider: () -> MultilineTextWidgetData,
    modifier: Modifier = Modifier
) {
    val data = dataProvider()
    Text(
        modifier = modifier
            .padding(horizontal = 16.dp)
        ,
        text = data.text
    )
}