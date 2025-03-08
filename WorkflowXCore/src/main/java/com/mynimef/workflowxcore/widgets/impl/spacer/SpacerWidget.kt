package com.mynimef.workflowxcore.widgets.impl.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerWidget(
    modifier: Modifier = Modifier,
    dataProvider: () -> SpacerWidgetData
) {
    val data = dataProvider()
    Spacer(modifier = modifier.height(data.height.dp))
}