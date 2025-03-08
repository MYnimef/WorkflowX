package com.mynimef.workflowxcore.widgets.subscribe

import android.os.Parcelable
import com.mynimef.workflowxcore.widgets.CoreWidgetData
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

/**
 *
 */
@SerialName(SubscribeWidgetData.TYPE)
@Serializable
@Parcelize
data class SubscribeWidgetData(
    override val id: String,
    val targets: List<Target>,
    val widget: CoreWidgetData
): CoreWidgetData {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

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