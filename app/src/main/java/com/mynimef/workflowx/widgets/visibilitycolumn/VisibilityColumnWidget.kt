package com.mynimef.workflowx.widgets.visibilitycolumn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mynimef.workflowx.Action
import com.mynimef.workflowx.widgets.BaseColumnWidget
import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.BaseWidgetsContentFactory

@Composable
fun VisibilityColumnWidget(
    contentFactory: BaseWidgetsContentFactory,
    dataProvider: () -> VisibilityColumnWidgetData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> BaseWidgetData?,
    modifier: Modifier = Modifier
) {
    val exp by remember { derivedStateOf { dataProvider().exp } }
    if (exp.isNotBlank()) {
        val widgets by remember { derivedStateOf { dataProvider().widgets } }
        BaseColumnWidget(
            contentFactory = contentFactory,
            widgetsProvider = { widgets },
            onAction = onAction,
            widgetGetter = widgetGetter
        )
    }
}