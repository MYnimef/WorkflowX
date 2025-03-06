package com.mynimef.workflowx.widgets.multilinetext

import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.StringObserver

data class MultilineTextWidgetData(
    override val id: String = "",
    val text: String
): BaseWidgetData, StringObserver {

    override val type: String = TYPE

    override fun update(str: String): BaseWidgetData = this.copy(text = str)

    companion object {
        const val TYPE = "MultilineTextWidget"
    }

}
