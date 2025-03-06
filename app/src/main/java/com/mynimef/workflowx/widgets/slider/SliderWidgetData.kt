package com.mynimef.workflowx.widgets.slider

import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.Observable

data class SliderWidgetData(
    override val id: String = "",
    val value: Float
): BaseWidgetData, Observable {

    override val type: String = TYPE

    override fun getValue(): Any = value

    companion object {
        const val TYPE = "SliderWidget"
    }

}
