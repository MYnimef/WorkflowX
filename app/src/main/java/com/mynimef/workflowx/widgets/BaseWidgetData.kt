package com.mynimef.workflowx.widgets

import android.os.Parcelable

/**
 * Базовый интерфейс данных виджета
 */
interface BaseWidgetData: Parcelable {

    /** Уникальный в рамках одного экрана идентификатор виджета */
    val id: String

    /** Тип виджета */
    val type: String

    // временное решение
    fun findWidgetById(id: String): BaseWidgetData? = if (this.id == id) this else null

    // временное решение
    fun replaceWidgetById(id: String, widget: BaseWidgetData) = if (this.id == id) widget else this

}