package com.mynimef.workflowxcore.widgets

sealed interface Action {

    data class ReplaceWidget(val id: String, val widget: CoreWidgetData): Action

}