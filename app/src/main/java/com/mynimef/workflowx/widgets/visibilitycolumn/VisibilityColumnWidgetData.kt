package com.mynimef.workflowx.widgets.visibilitycolumn

import com.mynimef.workflowx.widgets.BaseWidgetData

data class VisibilityColumnWidgetData(
    override val id: String = "",
    val exp: String,
    val widgets: List<BaseWidgetData>
): BaseWidgetData {

    override val type: String = TYPE

    companion object {
        const val TYPE = "VisibilityColumnWidget"
    }

}