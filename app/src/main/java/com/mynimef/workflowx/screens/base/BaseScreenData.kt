package com.mynimef.workflowx.screens.base

import android.os.Parcelable
import com.mynimef.workflowx.widgets.BaseWidgetData
import kotlinx.parcelize.Parcelize

@Parcelize
data class BaseScreenData(
    val backgroundColor: String,
    val widgets: List<BaseWidgetData>
): Parcelable {

    fun findWidgetById(id: String): BaseWidgetData? = widgets.find {
        it.findWidgetById(id) != null
    }

    fun replaceWidgetById(id: String, widget: BaseWidgetData) = this.copy(
        widgets = widgets.map {
            it.replaceWidgetById(id = id, widget = widget)
        }
    )

}