package com.mynimef.workflowxcore.widgets.impl.visibilitycolumn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.CoreColumnWidget
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

@Composable
fun VisibilityColumnWidget(
    contentFactory: CoreWidgetFactoryComposable,
    dataProvider: () -> VisibilityColumnWidgetData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> CoreWidgetData?,
    modifier: Modifier = Modifier
) {
    val exp by remember { derivedStateOf { dataProvider().exp } }
    if (exp.isNotBlank()) {
        val widgets by remember { derivedStateOf { dataProvider().widgets } }
        CoreColumnWidget(
            contentFactory = contentFactory,
            widgetsProvider = { widgets },
            onAction = onAction,
            widgetGetter = widgetGetter
        )
    }
}