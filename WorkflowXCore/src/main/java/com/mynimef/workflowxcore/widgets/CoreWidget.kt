package com.mynimef.workflowxcore.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.NonSkippableComposable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

/**
 * Базовая [Composable] функция отображения виджета по [CoreWidgetData]
 */
@NonSkippableComposable
@Composable
fun CoreWidget(
    contentFactory: CoreWidgetFactoryComposable,
    onAction: (Action) -> Unit,
    data: CoreWidgetData,
    stateGetter: (String) -> MutableState<CoreWidgetData>,
    modifier: Modifier = Modifier
) {
    val state = stateGetter(data.id)
    contentFactory.GetContent(
        type = data.type,
        dataProvider = { state.value },
        onAction = onAction,
        onWidgetChange = {
            state.value = it
        },
        stateGetter = stateGetter,
        modifier = modifier
    )
}

/**
 * Базовая [Composable] функция отображения виджета по [CoreWidgetData]
 */
@NonSkippableComposable
@Composable
fun CoreWidget(
    contentFactory: CoreWidgetFactoryComposable,
    onAction: (Action) -> Unit,
    dataProvider: () -> CoreWidgetData,
    onDataChange: (CoreWidgetData) -> Unit,
    stateGetter: (String) -> MutableState<CoreWidgetData>,
    modifier: Modifier = Modifier,
) {
    val type by remember { derivedStateOf { dataProvider().type } }
    contentFactory.GetContent(
        type = type,
        dataProvider = dataProvider,
        onAction = onAction,
        onWidgetChange = onDataChange,
        stateGetter = stateGetter,
        modifier = modifier
    )
}