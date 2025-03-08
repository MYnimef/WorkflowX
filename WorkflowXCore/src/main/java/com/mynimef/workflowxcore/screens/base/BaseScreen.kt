package com.mynimef.workflowxcore.screens.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mynimef.workflowxcore.Action
import com.mynimef.workflowxcore.widgets.WidgetsLazyColumn
import com.mynimef.workflowxcore.widgets.CoreWidgetFactoryComposable
import com.mynimef.workflowxcore.widgets.interfaces.CoreWidgetData
import androidx.core.graphics.toColorInt

@Composable
fun BaseScreen(
    contentFactory: CoreWidgetFactoryComposable,
    dataProvider: () -> BaseScreenData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> CoreWidgetData?,
    modifier: Modifier = Modifier
) = Scaffold(
    modifier = modifier
        .fillMaxSize()
    ,
    topBar = {

    },
    bottomBar = {

    }
) { padding ->
    val backgroundColor by remember { derivedStateOf { dataProvider().backgroundColor.toColorInt() } }
    val widgets by remember { derivedStateOf { dataProvider().widgets } }
    WidgetsLazyColumn(
        contentFactory = contentFactory,
        modifier = modifier
            .padding(padding)
            .fillMaxSize()
            .background(color = Color(backgroundColor))
        ,
        widgetsProvider = remember { { widgets } },
        onAction = onAction,
        widgetGetter = widgetGetter
    )
}