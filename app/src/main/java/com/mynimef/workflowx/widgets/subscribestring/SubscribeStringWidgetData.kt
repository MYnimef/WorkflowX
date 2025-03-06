package com.mynimef.workflowx.widgets.subscribestring

import com.mynimef.workflowx.widgets.BaseWidgetData

data class SubscribeStringWidgetData(
    override val id: String,
    val targetId: String,
    val widget: BaseWidgetData
): BaseWidgetData {

    override val type: String = TYPE

    companion object {
        const val TYPE = "SubscribeStringWidget"
    }

}