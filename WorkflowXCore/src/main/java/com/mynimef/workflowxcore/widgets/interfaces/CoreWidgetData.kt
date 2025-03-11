package com.mynimef.workflowxcore.widgets.interfaces

import android.os.Parcelable

/**
 * Базовый интерфейс данных виджета
 */
sealed interface CoreWidgetData : Parcelable {

    /** Уникальный в рамках одного экрана идентификатор виджета */
    val id: String

    /** Тип виджета */
    val type: String

    /** */
    interface Single : CoreWidgetData

    /**
     *
     */
    interface Container : CoreWidgetData {

        val widget: CoreWidgetData

    }

    /**
     *
     */
    interface Collection : CoreWidgetData {

        val widgets: List<CoreWidgetData>

    }

}