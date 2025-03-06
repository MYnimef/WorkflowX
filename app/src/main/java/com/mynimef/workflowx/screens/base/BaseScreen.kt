package com.mynimef.workflowx.screens.base

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mynimef.workflowx.Action
import com.mynimef.workflowx.screens.WidgetsLazyColumn
import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.BaseWidgetsContentFactory

@Composable
fun BaseScreen(
    contentFactory: BaseWidgetsContentFactory,
    dataProvider: () -> BaseScreenData,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> BaseWidgetData?,
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
    val backgroundColor by remember { derivedStateOf { dataProvider().backgroundColor } }
    val widgets by remember { derivedStateOf { dataProvider().widgets } }
    WidgetsLazyColumn(
        contentFactory = contentFactory,
        modifier = modifier
            .padding(padding)
            .fillMaxSize()
            .background(color = androidx.compose.ui.graphics.Color(Color.parseColor(backgroundColor)))
        ,
        widgetsProvider = remember { { widgets } },
        onAction = onAction,
        widgetGetter = widgetGetter
    )
}