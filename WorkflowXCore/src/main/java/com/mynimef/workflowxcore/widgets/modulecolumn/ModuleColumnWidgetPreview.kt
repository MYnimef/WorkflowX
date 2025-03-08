package com.mynimef.workflowxcore.widgets.modulecolumn

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable
import com.mynimef.workflowxcore.widgets.multilinetext.MultilineTextWidgetData

@Preview
@Composable
private fun ModuleLazyColumnWidgetPreview() {
    val data = ModuleColumnWidgetData(
        id = "0",
        widgets = listOf(
            MultilineTextWidgetData(
                id = "1",
                text = "что вы хотите знать"
            ),
            MultilineTextWidgetData(
                id = "2",
                text = "о прогнозной доходности"
            )
        )
    )
    ModuleLazyColumnWidget(
        contentFactory = CoreWidgetFactoryComposable(),
        dataProvider = { data },
        onAction = {},
        widgetGetter = { null }
    )
}