package com.mynimef.workflowx.widgets.modulecolumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mynimef.workflowx.Action
import com.mynimef.workflowx.widgets.BaseColumnWidget
import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.BaseWidgetsContentFactory

@Composable
fun ModuleLazyColumnWidget(
    contentFactory: BaseWidgetsContentFactory,
    dataProvider: () -> ModuleColumnWidgetData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> BaseWidgetData?,
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
        .padding(20.dp)
) {
    val widgets by remember { derivedStateOf { dataProvider().widgets } }
    BaseColumnWidget(
        contentFactory = contentFactory,
        widgetsProvider = { widgets },
        onAction = onAction,
        widgetGetter = widgetGetter
    )
}