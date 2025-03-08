package com.mynimef.workflowxcore.widgets.subscribe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mynimef.workflowxcore.widgets.Action
import com.mynimef.workflowxcore.widgets.CoreWidget
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable
import com.mynimef.workflowxcore.widgets.CoreWidgetData

/**
 *
 */
@Composable
fun SubscribeStringWidget(
    contentFactory: CoreWidgetFactoryComposable,
    dataProvider: () -> SubscribeWidgetData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> CoreWidgetData?,
    modifier: Modifier = Modifier
) {
    val widgetData by remember { derivedStateOf {
        val data = dataProvider()
        var observer = data.widget
        data.targets.forEach { target ->
            when (target.type) {
                "string" -> {
                    val stringObserver = observer as? com.mynimef.workflowxcore.widgets.CoreObserverWidgetString
                    val observable = widgetGetter(target.id) as? com.mynimef.workflowxcore.widgets.CoreObservableWidget
                    observer = stringObserver?.update(observable?.getValue().toString()) ?: observer
                }
            }
        }
        observer
    } }

    CoreWidget(
        contentFactory = contentFactory,
        dataProvider = remember { { widgetData } },
        onAction = onAction,
        widgetGetter = widgetGetter,
        modifier = modifier
    )
}