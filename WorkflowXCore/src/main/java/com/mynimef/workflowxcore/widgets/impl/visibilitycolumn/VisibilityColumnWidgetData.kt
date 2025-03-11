package com.mynimef.workflowxcore.widgets.impl.visibilitycolumn

import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@SerialName(VisibilityColumnWidgetData.TYPE)
@Serializable
@Parcelize
data class VisibilityColumnWidgetData(
    override val id: String,
    val exp: String,
    override val widgets: List<CoreWidgetData>
): CoreWidgetData.Collection {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    companion object {
        const val TYPE = "VisibilityColumnWidget"
    }

}