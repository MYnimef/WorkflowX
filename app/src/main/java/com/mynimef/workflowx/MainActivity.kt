package com.mynimef.workflowx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mynimef.workflowx.ui.theme.WorkflowXTheme
import com.mynimef.workflowxcore.CoreJsonDeserializer
import com.mynimef.workflowxcore.screens.base.BaseScreen
import com.mynimef.workflowxcore.screens.base.BaseScreenData
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkflowXTheme {
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
        }
    }
}

private val jsonStr = """
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
            "type": "SliderWidget",
            "id": "8",
            "value": 0.25
        },
        {
            "type": "SliderWidget",
            "id": "9",
            "value": 0.25
        },
        {
            "type": "SliderWidget",
            "id": "10",
            "value": 0.25
        },
        {
            "type": "SliderWidget",
            "id": "11",
            "value": 0.25
        },
        {
            "type": "SliderWidget",
            "id": "12",
            "value": 0.25
        }
    ]
}
    """.trimIndent()