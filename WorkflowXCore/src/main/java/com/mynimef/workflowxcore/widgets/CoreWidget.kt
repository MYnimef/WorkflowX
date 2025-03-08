package com.mynimef.workflowxcore.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/**
 * Базовая [Composable] функция отображения виджета по [CoreWidgetData]
 */
@Composable
fun CoreWidget(
    contentFactory: CoreWidgetFactoryComposable,
    dataProvider: () -> CoreWidgetData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> CoreWidgetData?,
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