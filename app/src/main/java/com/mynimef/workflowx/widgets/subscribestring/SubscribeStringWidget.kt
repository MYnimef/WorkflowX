package com.mynimef.workflowx.widgets.subscribestring

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mynimef.workflowx.Action
import com.mynimef.workflowx.widgets.BaseWidget
import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.BaseWidgetsContentFactory
import com.mynimef.workflowx.widgets.Observable
import com.mynimef.workflowx.widgets.StringObserver

@Composable
fun SubscribeStringWidget(
    contentFactory: BaseWidgetsContentFactory,
    dataProvider: () -> SubscribeStringWidgetData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> BaseWidgetData?,
    modifier: Modifier = Modifier
) {
    val widgetData by remember { derivedStateOf {
        val data = dataProvider()
        val observer = data.widget as? StringObserver
        val observable = widgetGetter(data.targetId) as? Observable
        observer?.update(observable?.getValue().toString()) ?: data.widget
    } }

    BaseWidget(
        contentFactory = contentFactory,
        dataProvider = remember { { widgetData } },
        onAction = onAction,
        widgetGetter = widgetGetter,
        modifier = modifier
    )
}