package com.mynimef.workflowxcore.widgets.impl.spacer

import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@SerialName(SpacerWidgetData.TYPE)
@Serializable
@Parcelize
data class SpacerWidgetData(
    override val id: String,
    val height: Float
): CoreWidgetData.Single {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    companion object {
        const val TYPE = "SpacerWidget"
    }

}