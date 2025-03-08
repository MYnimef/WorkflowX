package com.mynimef.workflowxcore.widgets.spacer

import com.mynimef.workflowxcore.widgets.CoreWidgetData
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
): CoreWidgetData {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    companion object {
        const val TYPE = "SpacerWidget"
    }

}