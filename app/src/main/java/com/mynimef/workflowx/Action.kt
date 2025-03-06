package com.mynimef.workflowx

import com.mynimef.workflowx.widgets.BaseWidgetData

sealed interface Action {

    data class ReplaceWidgetAction(val id: String, val widget: BaseWidgetData): Action

}