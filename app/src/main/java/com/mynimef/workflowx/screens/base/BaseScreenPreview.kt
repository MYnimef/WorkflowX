package com.mynimef.workflowx.screens.base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mynimef.workflowx.Action
import com.mynimef.workflowx.widgets.BaseWidgetsContentFactory
import com.mynimef.workflowx.widgets.modulecolumn.ModuleColumnWidgetData
import com.mynimef.workflowx.widgets.multilinetext.MultilineTextWidgetData
import com.mynimef.workflowx.widgets.slider.SliderWidgetData
import com.mynimef.workflowx.widgets.subscribe.SubscribeWidgetData
import kotlinx.serialization.json.Json

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
                            SubscribeWidgetData.Target(id = "5", type = "string")
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
        contentFactory = BaseWidgetsContentFactory(),
        dataProvider = { data },
        modifier = Modifier.fillMaxSize(),
        onAction = { when (it) {

            is Action.ReplaceWidgetAction -> {
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
            "type": "MultilineTextWidget",
            "id": "1",
            "text": "что вы хотите знать"
        },
        {
            "type": "MultilineTextWidget",
            "id": "2",
            "text": "о прогнозной доходности"
        },
        {
            "type": "ModuleColumnWidget",
            "id": "3",
            "widgets": [
                {
                    "type": "MultilineTextWidget",
                    "id": "4",
                    "text": "о прогнозной доходности"
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
                }
            ]
        },
        {
            "type": "SliderWidget",
            "id": "7",
            "value": 0.25
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
        Json.decodeFromString<BaseScreenData>(jsonStr)
    ) }

    BaseScreen(
        contentFactory = BaseWidgetsContentFactory(),
        dataProvider = { data },
        modifier = Modifier.fillMaxSize(),
        onAction = { when (it) {

            is Action.ReplaceWidgetAction -> {
                data = data.replaceWidgetById(id = it.id, widget = it.widget)
            }

        } },
        widgetGetter = { id ->
            data.findWidgetById(id)
        }
    )
}