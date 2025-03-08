package com.mynimef.workflowxcore.screens.base

import android.os.Parcelable
import com.mynimef.workflowxcore.widgets.CoreWidgetData
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class BaseScreenData(
    val backgroundColor: String,
    val widgets: List<CoreWidgetData>
): Parcelable {

    fun findWidgetById(id: String): CoreWidgetData? = widgets.find {
        it.findWidgetById(id) != null
    }

    fun replaceWidgetById(id: String, widget: CoreWidgetData) = this.copy(
        widgets = widgets.map {
            it.replaceWidgetById(id = id, widget = widget)
        }
    )

}