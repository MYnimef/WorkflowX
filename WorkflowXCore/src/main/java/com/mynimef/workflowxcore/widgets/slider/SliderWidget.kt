package com.mynimef.workflowxcore.widgets.slider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mynimef.workflowxcore.widgets.Action

@Composable
fun SliderWidget(
    dataProvider: () -> SliderWidgetData,
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
            onAction(Action.ReplaceWidget(id = data.id, data.copy(value = it)))
        }
    )
}