package com.mynimef.workflowxcore.widgets.slider

import com.mynimef.workflowxcore.widgets.CoreWidgetData
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@SerialName(SliderWidgetData.TYPE)
@Serializable
@Parcelize
data class SliderWidgetData(
    override val id: String,
    val value: Float
): CoreWidgetData, com.mynimef.workflowxcore.widgets.CoreObservableWidget {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    override fun getValue(): Any = value

    companion object {
        const val TYPE = "SliderWidget"
    }

}
