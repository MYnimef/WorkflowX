package com.mynimef.workflowxcore

import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

sealed interface Action {

    data class ReplaceWidget(val id: String, val widget: CoreWidgetData): Action

}