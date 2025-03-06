package com.mynimef.workflowx.widgets.visibilitycolumn

import com.mynimef.workflowx.widgets.BaseWidgetData
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class VisibilityColumnWidgetData(
    override val type: String = TYPE,
    override val id: String,
    val exp: String,
    val widgets: List<BaseWidgetData>
): BaseWidgetData {

    companion object {
        const val TYPE = "VisibilityColumnWidget"
    }

}