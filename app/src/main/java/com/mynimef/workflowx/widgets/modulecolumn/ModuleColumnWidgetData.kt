package com.mynimef.workflowx.widgets.modulecolumn

import com.mynimef.workflowx.widgets.BaseWidgetData

data class ModuleColumnWidgetData(
    override val id: String = "",
    val widgets: List<BaseWidgetData>
): BaseWidgetData {

    override val type: String = TYPE

    override fun findWidgetById(id: String): BaseWidgetData? =
        super.findWidgetById(id) ?: widgets.find {
            it.findWidgetById(id) != null
        }

    override fun replaceWidgetById(id: String, widget: BaseWidgetData): BaseWidgetData =
        super.replaceWidgetById(id, widget).let { current ->
            if (current == this) {
                this.copy(
                    widgets = widgets.map {
                        it.replaceWidgetById(id = id, widget = widget)
                    }
                )
            } else current
        }

    companion object {
        const val TYPE = "ModuleColumnWidget"
    }

}
