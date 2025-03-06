package com.mynimef.workflowx.widgets

import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mynimef.workflowx.Action
import com.mynimef.workflowx.widgets.modulecolumn.ModuleColumnWidgetData
import com.mynimef.workflowx.widgets.modulecolumn.ModuleLazyColumnWidget
import com.mynimef.workflowx.widgets.multilinetext.MultilineTextWidget
import com.mynimef.workflowx.widgets.multilinetext.MultilineTextWidgetData
import com.mynimef.workflowx.widgets.slider.SliderWidget
import com.mynimef.workflowx.widgets.slider.SliderWidgetData
import com.mynimef.workflowx.widgets.subscribestring.SubscribeStringWidget
import com.mynimef.workflowx.widgets.subscribestring.SubscribeStringWidgetData

/**
 *
 */
open class BaseWidgetsContentFactory {

    @Composable
    fun GetContent(
        type: String,
        dataProvider: () -> BaseWidgetData,
        onAction: (Action) -> Unit,
        widgetGetter: (String) -> BaseWidgetData?,
        modifier: Modifier
    ) = dataProvider.GetContent(
        type = type,
        onAction = onAction,
        widgetGetter = widgetGetter,
        modifier = modifier
    )

    @CallSuper
    @Composable
    protected open fun (() -> BaseWidgetData).GetContent(
        type: String,
        onAction: (Action) -> Unit,
        widgetGetter: (String) -> BaseWidgetData?,
        modifier: Modifier
    ) = when (type) {

        MultilineTextWidgetData.TYPE -> MultilineTextWidget(
            dataProvider = provider(),
            modifier = modifier
        )

        ModuleColumnWidgetData.TYPE -> ModuleLazyColumnWidget(
            contentFactory = this@BaseWidgetsContentFactory,
            dataProvider = provider(),
            onAction = onAction,
            widgetGetter = widgetGetter,
            modifier = modifier
        )

        SliderWidgetData.TYPE -> SliderWidget(
            dataProvider = provider(),
            onAction = onAction,
            modifier = modifier
        )

        SubscribeStringWidgetData.TYPE -> SubscribeStringWidget(
            contentFactory = this@BaseWidgetsContentFactory,
            dataProvider = provider(),
            onAction = onAction,
            widgetGetter = widgetGetter,
            modifier = modifier
        )

        else -> {}

    }

    /**
     * Преобразование провайдера данных виджета
     */
    @Suppress("Unchecked_Cast")
    protected fun <T: Any> (() -> BaseWidgetData).provider() = this as () -> T

}