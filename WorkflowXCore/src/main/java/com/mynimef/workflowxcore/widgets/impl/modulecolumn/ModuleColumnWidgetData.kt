package com.mynimef.workflowxcore.widgets.impl.modulecolumn

import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
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
    override val widgets: List<CoreWidgetData>
): CoreWidgetData.Collection {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    companion object {
        const val TYPE = "ModuleColumnWidget"
    }

}
