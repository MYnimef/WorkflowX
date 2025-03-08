package com.mynimef.workflowxcore.widgets

import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mynimef.workflowxcore.widgets.impl.modulecolumn.ModuleColumnWidgetData
import com.mynimef.workflowxcore.widgets.impl.modulecolumn.ModuleLazyColumnWidget
import com.mynimef.workflowxcore.widgets.impl.multilinetext.MultilineTextWidget
import com.mynimef.workflowxcore.widgets.impl.multilinetext.MultilineTextWidgetData
import com.mynimef.workflowxcore.widgets.impl.slider.SliderWidget
import com.mynimef.workflowxcore.widgets.impl.slider.SliderWidgetData
import com.mynimef.workflowxcore.widgets.impl.spacer.SpacerWidget
import com.mynimef.workflowxcore.widgets.impl.spacer.SpacerWidgetData
import com.mynimef.workflowxcore.widgets.impl.subscribe.SubscribeStringWidget
import com.mynimef.workflowxcore.widgets.impl.subscribe.SubscribeWidgetData
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData

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

        MultilineTextWidgetData.Companion.TYPE -> MultilineTextWidget(
            dataProvider = provider(),
            modifier = modifier
        )

        ModuleColumnWidgetData.Companion.TYPE -> ModuleLazyColumnWidget(
            contentFactory = this@CoreWidgetFactoryComposable,
            dataProvider = provider(),
            onAction = onAction,
            widgetGetter = widgetGetter,
            modifier = modifier
        )

        SliderWidgetData.Companion.TYPE -> SliderWidget(
            dataProvider = provider(),
            onAction = onAction,
            modifier = modifier
        )

        SpacerWidgetData.Companion.TYPE -> SpacerWidget(
            dataProvider = provider(),
            modifier = modifier
        )

        SubscribeWidgetData.Companion.TYPE -> SubscribeStringWidget(
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