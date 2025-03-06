package com.mynimef.workflowx.screens.base

import com.mynimef.workflowx.widgets.BaseWidgetData

data class BaseScreenData(
    val backgroundColor: String,
    val widgets: List<BaseWidgetData>
) {

    fun findWidgetById(id: String): BaseWidgetData? = widgets.find {
        it.findWidgetById(id) != null
    }

    fun replaceWidgetById(id: String, widget: BaseWidgetData) = this.copy(
        widgets = widgets.map {
            it.replaceWidgetById(id = id, widget = widget)
        }
    )

}