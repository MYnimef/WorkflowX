package com.mynimef.workflowx.widgets.slider

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SliderWidgetPreview() {
    val data = SliderWidgetData(
        value = 0f
    )
    SliderWidget(
        dataProvider = { data },
        onAction = {}
    )
}