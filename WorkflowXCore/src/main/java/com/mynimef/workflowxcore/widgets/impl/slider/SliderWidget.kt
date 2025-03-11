package com.mynimef.workflowxcore.widgets.impl.slider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

@Composable
fun SliderWidget(
    dataProvider: () -> SliderWidgetData,
    onDataChange: (CoreWidgetData) -> Unit,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    val data = dataProvider()
    Slider(
        modifier = modifier
            .padding(horizontal = 16.dp)
        ,
        value = data.value,
        onValueChange = {
            onDataChange(data.copy(value = it))
        }
    )
}