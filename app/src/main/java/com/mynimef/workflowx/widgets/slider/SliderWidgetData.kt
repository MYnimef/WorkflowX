package com.mynimef.workflowx.widgets.slider

import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.Observable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SliderWidgetData(
    override val type: String = TYPE,
    override val id: String = "",
    val value: Float
): BaseWidgetData, Observable {

    override fun getValue(): Any = value

    companion object {
        const val TYPE = "SliderWidget"
    }

}
