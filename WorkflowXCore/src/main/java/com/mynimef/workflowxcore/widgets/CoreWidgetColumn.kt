package com.mynimef.workflowxcore.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

/**
 *
 */
@Composable
fun CoreColumnWidget(
    contentFactory: CoreWidgetFactoryComposable,
    widgets: List<CoreWidgetData>,
    onAction: (Action) -> Unit,
    stateGetter: (String) -> State<CoreWidgetData>,
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
) {
    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        widgets.forEach { widget ->
            CoreWidget(
                initialData = widget,
                contentFactory = contentFactory,
                onAction = onAction,
                stateGetter = stateGetter
            )
        }
    }
}