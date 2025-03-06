package com.mynimef.workflowx.widgets.subscribestring

import android.os.Parcelable
import com.mynimef.workflowx.widgets.BaseWidgetData
import kotlinx.parcelize.Parcelize

/**
 *
 */
@Parcelize
data class SubscribeStringWidgetData(
    override val type: String = TYPE,
    override val id: String,
    val targets: List<Target>,
    val widget: BaseWidgetData
): BaseWidgetData {

    /**
     *
     */
    @Parcelize
    data class Target(
        val id: String,
        val type: String
    ): Parcelable

    companion object {
        const val TYPE = "SubscribeStringWidget"
    }

}