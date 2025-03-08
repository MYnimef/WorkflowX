package com.mynimef.workflowxcore.widgets

import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mynimef.workflowxcore.widgets.modulecolumn.ModuleColumnWidgetData
import com.mynimef.workflowxcore.widgets.modulecolumn.ModuleLazyColumnWidget
import com.mynimef.workflowxcore.widgets.multilinetext.MultilineTextWidget
import com.mynimef.workflowxcore.widgets.multilinetext.MultilineTextWidgetData
import com.mynimef.workflowxcore.widgets.slider.SliderWidget
import com.mynimef.workflowxcore.widgets.slider.SliderWidgetData
import com.mynimef.workflowxcore.widgets.spacer.SpacerWidget
import com.mynimef.workflowxcore.widgets.spacer.SpacerWidgetData
import com.mynimef.workflowxcore.widgets.subscribe.SubscribeStringWidget
import com.mynimef.workflowxcore.widgets.subscribe.SubscribeWidgetData

/**
 *
 */
open class CoreWidgetFactoryComposable {

    @Composable
    internal fun GetContent(
        type: String,
        dataProvider: () -> CoreWidgetData,
        onAction: (Action) -> Unit,
        widgetGetter: (String) -> CoreWidgetData?,
        modifier: Modifier
    ) = dataProvider.GetContent(
        type = type,
        onAction = onAction,
        widgetGetter = widgetGetter,
        modifier = modifier
    )

    @CallSuper
    @Composable
    protected open fun (() -> CoreWidgetData).GetContent(
        type: String,
        onAction: (Action) -> Unit,
        widgetGetter: (String) -> CoreWidgetData?,
        modifier: Modifier
    ) = when (type) {

        MultilineTextWidgetData.TYPE -> MultilineTextWidget(
            dataProvider = provider(),
            modifier = modifier
        )

        ModuleColumnWidgetData.TYPE -> ModuleLazyColumnWidget(
            contentFactory = this@CoreWidgetFactoryComposable,
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

        SpacerWidgetData.TYPE -> SpacerWidget(
            dataProvider = provider(),
            modifier = modifier
        )

        SubscribeWidgetData.TYPE -> SubscribeStringWidget(
            contentFactory = this@CoreWidgetFactoryComposable,
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
    protected fun <T: Any> (() -> CoreWidgetData).provider() = this as () -> T

}