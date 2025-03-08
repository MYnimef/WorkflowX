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
    fun findWidgetById(id: String): CoreWidgetData?

    /** */
    fun replaceWidgetById(id: String, widget: CoreWidgetData): CoreWidgetData

    /**
     *
     */
    interface Single : CoreWidgetData {

        override fun findWidgetById(id: String): CoreWidgetData? =
            if (this.id == id) this else null

        override fun replaceWidgetById(id: String, widget: CoreWidgetData): CoreWidgetData =
            if (this.id == id) widget else this

    }

    /**
     *
     */
    interface Container : CoreWidgetData {

        val widget: CoreWidgetData

        fun copyWith(widget: CoreWidgetData): CoreWidgetData

        override fun findWidgetById(id: String): CoreWidgetData? =
            if (this.id == id) this else this.widget.findWidgetById(id = id)

        override fun replaceWidgetById(id: String, widget: CoreWidgetData): CoreWidgetData =
            if (this.id == id) widget else this.copyWith(
                widget = this.widget.replaceWidgetById(id = id, widget = widget)
            )

    }

    /**
     *
     */
    interface Collection : CoreWidgetData {

        val widgets: List<CoreWidgetData>

        fun copyWith(widgets: List<CoreWidgetData>): CoreWidgetData

        override fun findWidgetById(id: String): CoreWidgetData? =
            if (this.id == id) this else this.widgets.find {
                it.findWidgetById(id) != null
            }

        override fun replaceWidgetById(id: String, widget: CoreWidgetData): CoreWidgetData =
            if (this.id == id) widget else this.copyWith(
                widgets = this.widgets.map {
                    it.replaceWidgetById(id = id, widget = widget)
                }
            )

    }

}