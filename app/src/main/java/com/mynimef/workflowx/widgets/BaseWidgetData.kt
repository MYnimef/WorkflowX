package com.mynimef.workflowx.widgets

interface BaseWidgetData {

    /** Уникальный в рамках одного экрана идентификатор виджета */
    val id: String

    /** Тип виджета */
    val type: String

    fun findWidgetById(id: String): BaseWidgetData? = if (this.id == id) this else null

    fun replaceWidgetById(id: String, widget: BaseWidgetData) = if (this.id == id) widget else this

}