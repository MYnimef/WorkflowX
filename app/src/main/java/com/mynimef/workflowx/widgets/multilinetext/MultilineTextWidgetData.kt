package com.mynimef.workflowx.widgets.multilinetext

import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.StringObserver
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class MultilineTextWidgetData(
    override val type: String = TYPE,
    override val id: String,
    val text: String
): BaseWidgetData, StringObserver {

    override fun update(str: String): BaseWidgetData = this.copy(text = str)

    companion object {
        const val TYPE = "MultilineTextWidget"
    }

}
