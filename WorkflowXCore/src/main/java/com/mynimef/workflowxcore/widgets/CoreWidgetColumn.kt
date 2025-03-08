package com.mynimef.workflowxcore.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
    widgetsProvider: () -> List<CoreWidgetData>,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> CoreWidgetData?,
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
) {
    val widgetsIndices by remember { derivedStateOf { widgetsProvider().indices } }
    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        for (index in widgetsIndices) {
            val widgetData by remember { derivedStateOf { widgetsProvider()[index] } }
            CoreWidget(
                contentFactory = contentFactory,
                dataProvider = { widgetData },
                onAction = onAction,
                widgetGetter = widgetGetter
            )
        }
    }
}