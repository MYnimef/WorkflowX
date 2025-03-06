package com.mynimef.workflowx.widgets.subscribe

import android.os.Parcelable
import com.mynimef.workflowx.widgets.BaseWidgetData
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

/**
 *
 */
@Serializable
@Parcelize
data class SubscribeWidgetData(
    override val type: String = TYPE,
    override val id: String,
    val targets: List<Target>,
    val widget: BaseWidgetData
): BaseWidgetData {

    /**
     *
     */
    @Serializable
    @Parcelize
    data class Target(
        val id: String,
        val type: String
    ): Parcelable

    companion object {
        const val TYPE = "SubscribeWidget"
    }

}