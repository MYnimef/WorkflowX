package com.mynimef.workflowxcore.screens.base

import android.os.Parcelable
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class BaseScreenData(
    val backgroundColor: String,
    val widgets: List<CoreWidgetData>
): Parcelable