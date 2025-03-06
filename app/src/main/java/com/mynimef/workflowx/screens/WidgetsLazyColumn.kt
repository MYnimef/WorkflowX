package com.mynimef.workflowx.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mynimef.workflowx.Action
import com.mynimef.workflowx.widgets.BaseWidget
import com.mynimef.workflowx.widgets.BaseWidgetData
import com.mynimef.workflowx.widgets.BaseWidgetsContentFactory

@Composable
fun WidgetsLazyColumn(
    contentFactory: BaseWidgetsContentFactory,
    widgetsProvider: () -> List<BaseWidgetData>,
    onAction: (Action) -> Unit,
    widgetGetter: (String) -> BaseWidgetData?,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement. Vertical = if (!reverseLayout) Arrangement. Top else Arrangement. Bottom,
    horizontalAlignment: Alignment. Horizontal = Alignment.Start,
) {
    val widgetsIndices by remember { derivedStateOf { widgetsProvider().indices } }
    val states = widgetsIndices.map {
        remember { derivedStateOf {
            widgetsProvider()[it]
        } }
    }

    LazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        items(
            items = states,
            key = { it.value.id }
        ) { state ->
            BaseWidget(
                contentFactory = contentFactory,
                dataProvider = { state.value },
                onAction = onAction,
                widgetGetter = widgetGetter,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}