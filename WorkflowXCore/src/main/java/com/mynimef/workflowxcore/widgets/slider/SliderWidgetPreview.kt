package com.mynimef.workflowxcore.widgets.slider

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SliderWidgetPreview() {
    val data = SliderWidgetData(
        id = "0",
        value = 0f
    )
    SliderWidget(
        dataProvider = { data },
        onAction = {}
    )
}