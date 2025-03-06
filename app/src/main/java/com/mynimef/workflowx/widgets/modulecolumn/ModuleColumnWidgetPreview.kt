package com.mynimef.workflowx.widgets.modulecolumn

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mynimef.workflowx.widgets.BaseWidgetsContentFactory
import com.mynimef.workflowx.widgets.multilinetext.MultilineTextWidgetData

@Preview
@Composable
private fun ModuleLazyColumnWidgetPreview() {
    val data = ModuleColumnWidgetData(
        widgets = listOf(
            MultilineTextWidgetData(
                text = "что вы хотите знать"
            ),
            MultilineTextWidgetData(
                text = "о прогнозной доходности"
            )
        )
    )
    ModuleLazyColumnWidget(
        contentFactory = BaseWidgetsContentFactory(),
        dataProvider = { data },
        onAction = {},
        widgetGetter = { null }
    )
}