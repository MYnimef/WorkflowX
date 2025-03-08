package com.mynimef.workflowxcore.widgets.multilinetext

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun MultilineTextWidgetPreview() {
    val data = MultilineTextWidgetData(
        id = "2",
        text = "hi"
    )
    MultilineTextWidget(
        dataProvider = { data }
    )
}