package com.mynimef.workflowxcore.widgets.impl.slider

import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
import com.mynimef.workflowxcore.widgets.interfaces.ObservableWidget
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
): CoreWidgetData.Single, ObservableWidget {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    override fun getValue(): Any = value

    companion object {
        const val TYPE = "SliderWidget"
    }

}
