package com.mynimef.workflowx.widgets.slider

import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mynimef.workflowx.Action

@Composable
fun SliderWidget(
    dataProvider: () -> SliderWidgetData,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    val data = dataProvider()
    Slider(
        modifier = modifier,
        value = data.value,
        onValueChange = {
            onAction(Action.ReplaceWidgetAction(id = data.id, data.copy(value = it)))
        }
    )
}