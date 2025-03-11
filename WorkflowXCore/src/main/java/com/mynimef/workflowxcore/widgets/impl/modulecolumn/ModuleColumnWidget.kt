package com.mynimef.workflowxcore.widgets.impl.modulecolumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.CoreColumnWidget
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

@Composable
fun ModuleLazyColumnWidget(
    contentFactory: CoreWidgetFactoryComposable,
    dataProvider: () -> ModuleColumnWidgetData,
    onAction: (Action) -> Unit,
    stateGetter: (String) -> MutableState<CoreWidgetData>,
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
) {
    val widgets by remember { derivedStateOf { dataProvider().widgets } }
    CoreColumnWidget(
        contentFactory = contentFactory,
        widgets = widgets,
        onAction = onAction,
        stateGetter = stateGetter
    )
}