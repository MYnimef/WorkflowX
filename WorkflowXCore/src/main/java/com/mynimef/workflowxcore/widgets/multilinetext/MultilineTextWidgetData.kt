package com.mynimef.workflowxcore.widgets.multilinetext

import com.mynimef.workflowxcore.widgets.CoreObserverWidgetString
import com.mynimef.workflowxcore.widgets.CoreWidgetData
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@SerialName(MultilineTextWidgetData.TYPE)
@Parcelize
data class MultilineTextWidgetData(
    override val id: String,
    val text: String
): CoreWidgetData, CoreObserverWidgetString {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    override fun update(str: String): CoreWidgetData = this.copy(text = str)

    companion object {
        const val TYPE = "MultilineTextWidget"
    }

}
