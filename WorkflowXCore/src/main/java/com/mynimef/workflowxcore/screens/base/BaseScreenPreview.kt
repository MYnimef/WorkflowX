package com.mynimef.workflowxcore.screens.base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mynimef.workflowxcore.widgets.Action
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable
import com.mynimef.workflowxcore.CoreJsonDeserializer
import com.mynimef.workflowxcore.widgets.modulecolumn.ModuleColumnWidgetData
import com.mynimef.workflowxcore.widgets.multilinetext.MultilineTextWidgetData
import com.mynimef.workflowxcore.widgets.slider.SliderWidgetData
import com.mynimef.workflowxcore.widgets.subscribe.SubscribeWidgetData

@Preview
@Composable
private fun BaseScreenPreview() {
    var data by rememberSaveable { mutableStateOf(
        BaseScreenData(
        backgroundColor = "#FF00FFFF",
        widgets = listOf(
            MultilineTextWidgetData(
                id = "1",
                text = "что вы хотите знать"
            ),
            MultilineTextWidgetData(
                id = "2",
                text = "о прогнозной доходности"
            ),
            ModuleColumnWidgetData(
                id = "custom",
                widgets = listOf(
                    MultilineTextWidgetData(
                        id = "3",
                        text = "о прогнозной доходности"
                    ),
                    SubscribeWidgetData(
                        id = "subscribe",
                        targets = listOf(
                            SubscribeWidgetData.Target(
                                id = "5",
                                type = "string"
                            )
                        ),
                        widget = MultilineTextWidgetData(
                            id = "4",
                            text = ""
                        )
                    )
                )
            ),
            SliderWidgetData(
                id = "5",
                value = 0f
            ),
            MultilineTextWidgetData(
                id = "6",
                text = "о ком угодно"
            )
        )
    )
    ) }

    BaseScreen(
        contentFactory = CoreWidgetFactoryComposable(),
        dataProvider = { data },
        modifier = Modifier.fillMaxSize(),
        onAction = { when (it) {

            is Action.ReplaceWidget -> {
                data = data.replaceWidgetById(id = it.id, widget = it.widget)
            }

        } },
        widgetGetter = { id ->
            data.findWidgetById(id)
        }
    )
}

@Preview
@Composable
private fun BaseScreenJsonPreview() {
    val jsonStr = """
{
    "backgroundColor": "#FF00FFFF",
    "widgets": [
        {
            "type": "SpacerWidget"
            "id": "spacer:1",
            "height": "8"
        },
        {
            "type": "MultilineTextWidget",
            "id": "1",
            "text": "что вы хотите знать"
        },
        {
            "type": "SpacerWidget"
            "id": "spacer:2",
            "height": "8"
        },
        {
            "type": "MultilineTextWidget",
            "id": "2",
            "text": "о прогнозной доходности"
        },
        {
            "type": "SpacerWidget"
            "id": "spacer:3",
            "height": "8"
        },
        {
            "type": "ModuleColumnWidget",
            "id": "3",
            "widgets": [
                {
                    "type": "SpacerWidget"
                    "id": "spacer:4",
                    "height": "16"
                },
                {
                    "type": "MultilineTextWidget",
                    "id": "4",
                    "text": "о прогнозной доходности"
                },
                {
                    "type": "SpacerWidget"
                    "id": "spacer:5",
                    "height": "8"
                },
                {
                    "type": "SubscribeWidget",
                    "id": "5",
                    "targets": [
                        {
                            "id": "7",
                            "type": "string"
                        }
                    ],
                    "widget": {
                        "type": "MultilineTextWidget",
                        "id": "6",
                        "text": ""
                    }
                },
                {
                    "type": "SpacerWidget"
                    "id": "spacer:6",
                    "height": "16"
                }
            ]
        },
        {
            "type": "SpacerWidget"
            "id": "spacer:7",
            "height": "8"
        },
        {
            "type": "SliderWidget",
            "id": "7",
            "value": 0.25
        },
        {
            "type": "SpacerWidget"
            "id": "spacer:8",
            "height": "8"
        },
        {
            "type": "MultilineTextWidget",
            "id": "8",
            "text": "о ком угодно"
        }
    ]
}
    """.trimIndent()

    var data by rememberSaveable { mutableStateOf(
        CoreJsonDeserializer().run {
            deserialize<BaseScreenData>(jsonStr)
        }
    ) }

    BaseScreen(
        contentFactory = CoreWidgetFactoryComposable(),
        dataProvider = { data },
        modifier = Modifier.fillMaxSize(),
        onAction = { when (it) {

            is Action.ReplaceWidget -> {
                data = data.replaceWidgetById(id = it.id, widget = it.widget)
            }

        } },
        widgetGetter = { id ->
            data.findWidgetById(id)
        }
    )
}