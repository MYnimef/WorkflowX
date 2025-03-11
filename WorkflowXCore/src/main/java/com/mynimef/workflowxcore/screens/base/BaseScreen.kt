package com.mynimef.workflowxcore.screens.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable
import com.mynimef.workflowxcore.widgets.WidgetsLazyColumn
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

@Composable
fun BaseScreen(
    contentFactory: CoreWidgetFactoryComposable,
    dataProvider: () -> BaseScreenData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> CoreWidgetData?,
    modifier: Modifier = Modifier
) = Scaffold(
    modifier = modifier
        .fillMaxSize()
    ,
    topBar = {

    },
    bottomBar = {

    }
) { padding ->
    val backgroundColor by remember { derivedStateOf { dataProvider().backgroundColor.toColorInt() } }
    val widgetsMap = dataProvider().widgets.extractMap()
    val widgets by remember { derivedStateOf { dataProvider().widgets } }

    WidgetsLazyColumn(
        contentFactory = contentFactory,
        modifier = modifier
            .padding(padding)
            .fillMaxSize()
            .background(color = Color(backgroundColor))
        ,
        widgets = widgets,
        onAction = {
            when (it) {
                is Action.ReplaceWidget -> widgetsMap[it.id]?.value = it.widget
            }
        },
        stateGetter = { id ->
            widgetsMap.getValue(id)
        }
    )
}

@Composable
private fun List<CoreWidgetData>.extractMap(): MutableMap<String, MutableState<CoreWidgetData>> {
    val map = mutableMapOf<String, MutableState<CoreWidgetData>>()
    this.forEach { widget ->
        map[widget.id] = rememberSaveable { mutableStateOf(widget) }
        when (widget) {
            is CoreWidgetData.Collection -> map.putAll(widget.widgets.extractMap())
            is CoreWidgetData.Container -> map[widget.widget.id] = widget.widget.run {
                rememberSaveable { mutableStateOf(this) }
            }
            is CoreWidgetData.Single -> {}
        }
    }
    return map
}