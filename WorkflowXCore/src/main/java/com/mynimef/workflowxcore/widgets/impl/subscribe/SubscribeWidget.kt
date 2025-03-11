package com.mynimef.workflowxcore.widgets.impl.subscribe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.CoreWidget
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
import com.mynimef.workflowxcore.widgets.interfaces.ObservableWidget
import com.mynimef.workflowxcore.widgets.interfaces.ObserverWidgetString

/**
 *
 */
@Composable
fun SubscribeStringWidget(
    contentFactory: CoreWidgetFactoryComposable,
    dataProvider: () -> SubscribeWidgetData,
    onAction: (Action) -> Unit,
    stateGetter: (String) -> MutableState<CoreWidgetData>,
    modifier: Modifier = Modifier
) {
    val data = dataProvider()
    var widgetData by rememberSaveable { mutableStateOf(data.widget) }
    val widgetDataUpdated by remember { derivedStateOf {
        var observer = stateGetter(widgetData.id).value
        data.targets.forEach { target ->
            when (target.type) {
                "string" -> {
                    val stringObserver = observer as? ObserverWidgetString
                    val observable = stateGetter(target.id).value as? ObservableWidget
                    observer = stringObserver?.updateString(observable?.getValue().toString()) ?: observer
                }
            }
        }
        observer
    } }

    CoreWidget(
        contentFactory = contentFactory,
        dataProvider = { widgetDataUpdated },
        onDataChange = { widgetData = it },
        onAction = onAction,
        stateGetter = stateGetter,
        modifier = modifier
    )
}