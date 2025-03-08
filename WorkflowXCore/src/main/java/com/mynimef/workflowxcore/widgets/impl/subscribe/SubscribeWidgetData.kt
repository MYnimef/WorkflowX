package com.mynimef.workflowxcore.widgets.impl.subscribe

import android.os.Parcelable
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
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
    override val widget: CoreWidgetData
): CoreWidgetData.Container {

    @Transient
    @IgnoredOnParcel
    override val type: String = TYPE

    override fun copyWith(widget: CoreWidgetData) = copy(widget = widget)

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