package com.mynimef.workflowxcore.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
import kotlin.collections.forEach

@Composable
fun List<CoreWidgetData>.extractMap(): Map<String, MutableState<CoreWidgetData>> {
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