package com.mynimef.workflowx.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mynimef.workflowx.Action

/**
 *
 */
@Composable
fun BaseColumnWidget(
    contentFactory: BaseWidgetsContentFactory,
    widgetsProvider: () -> List<BaseWidgetData>,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> BaseWidgetData?,
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
            BaseWidget(
                contentFactory = contentFactory,
                dataProvider = { widgetData },
                onAction = onAction,
                widgetGetter = widgetGetter
            )
        }
    }
}