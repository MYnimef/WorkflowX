package com.mynimef.workflowxcore.widgets.impl.slider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

@Preview
@Composable
private fun SliderWidgetPreview() {
    var data by remember { mutableStateOf<CoreWidgetData>(SliderWidgetData(
        id = "0",
        value = 0f
    )) }
    SliderWidget(
        dataProvider = { data as SliderWidgetData },
        onAction = {},
        onDataChange = { data = it }
    )
}