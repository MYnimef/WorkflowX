package com.mynimef.workflowx.widgets

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

open class BaseWidgetsContentFactory {

    @Composable
    open fun GetContent(
        type: String,
        dataProvider: () -> BaseWidgetData,
        onAction: (Action) -> Unit,
        widgetGetter: (String) -> BaseWidgetData?,
        modifier: Modifier
    ) = when(type) {

        MultilineTextWidgetData.TYPE -> MultilineTextWidget(
            dataProvider = { dataProvider() as MultilineTextWidgetData },
            modifier = modifier
        )

        ModuleColumnWidgetData.TYPE -> ModuleLazyColumnWidget(
            contentFactory = this,
            dataProvider = { dataProvider() as ModuleColumnWidgetData },
            onAction = onAction,
            widgetGetter = widgetGetter,
            modifier = modifier
        )

        SliderWidgetData.TYPE -> SliderWidget(
            dataProvider = { dataProvider() as SliderWidgetData },
            onAction = onAction,
            modifier = modifier
        )

        SubscribeStringWidgetData.TYPE -> SubscribeStringWidget(
            contentFactory = this,
            dataProvider = { dataProvider() as SubscribeStringWidgetData },
            onAction = onAction,
            widgetGetter = widgetGetter,
            modifier = modifier
        )

        else -> {}

    }

}