package com.mynimef.workflowxcore.widgets.modulecolumn

import com.mynimef.workflowxcore.widgets.CoreWidgetData
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@SerialName(ModuleColumnWidgetData.TYPE)
@Parcelize
data class ModuleColumnWidgetData(
    override val id: String,
    val widgets: List<CoreWidgetData>
): CoreWidgetData {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    override fun findWidgetById(id: String): CoreWidgetData? =
        super.findWidgetById(id) ?: widgets.find {
            it.findWidgetById(id) != null
        }

    override fun replaceWidgetById(id: String, widget: CoreWidgetData): CoreWidgetData =
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
