package com.mynimef.workflowx.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mynimef.workflowx.Action

/**
 * Базовая [Composable] функция отображения виджета по [BaseWidgetData]
 */
@Composable
fun BaseWidget(
    contentFactory: BaseWidgetsContentFactory,
    dataProvider: () -> BaseWidgetData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> BaseWidgetData?,
    modifier: Modifier = Modifier
) {
    val type by remember { derivedStateOf { dataProvider().type } }
    contentFactory.GetContent(
        type = type,
        dataProvider = dataProvider,
        onAction = onAction,
        widgetGetter = widgetGetter,
        modifier = modifier
    )
}