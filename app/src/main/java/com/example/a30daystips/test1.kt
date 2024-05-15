package com.example.a30daystips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Preview
@Composable
private fun ScrollDirectionSample() {

    val lazyListState = rememberLazyListState()
    val directionalLazyListState = rememberDirectionalLazyListState(
        lazyListState
    )

    val text by remember {
        derivedStateOf {
            "isScrollInProgress: ${lazyListState.isScrollInProgress}\n" +
                    "firstVisibleItemIndex: ${lazyListState.firstVisibleItemIndex}\n" +
                    "firstVisibleItemScrollOffset: ${lazyListState.firstVisibleItemScrollOffset}"
        }
    }


    val color = when (directionalLazyListState.scrollDirection) {
        ScrollDirection.Up -> Color.Green
        ScrollDirection.Down -> Color.Blue
        else -> Color.Black
    }

    Column {

        Text(text, fontSize = 16.sp)
        Text(
            "Direction: ${directionalLazyListState.scrollDirection}",
            fontSize = 24.sp,
            color = color,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.fillMaxSize()
        ) {
            items(50) {
                Text(
                    text = "Row $it",
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun rememberDirectionalLazyListState(
    lazyListState: LazyListState,
): DirectionalLazyListState {
    return remember {
        DirectionalLazyListState(lazyListState)
    }
}

class DirectionalLazyListState(
    private val lazyListState: LazyListState
) {
    private var positionY = lazyListState.firstVisibleItemScrollOffset
    private var visibleItem = lazyListState.firstVisibleItemIndex


    val scrollDirection by derivedStateOf {
        if (lazyListState.isScrollInProgress.not()) {
            ScrollDirection.None
        } else {
            val firstVisibleItemIndex = lazyListState.firstVisibleItemIndex
            val firstVisibleItemScrollOffset =
                lazyListState.firstVisibleItemScrollOffset

            // We are scrolling while first visible item hasn't changed yet
            if (firstVisibleItemIndex == visibleItem) {
                val direction = if (firstVisibleItemScrollOffset > positionY) {
                    ScrollDirection.Down
                } else {
                    ScrollDirection.Up
                }
                positionY = firstVisibleItemScrollOffset

                direction
            } else {

                val direction = if (firstVisibleItemIndex > visibleItem) {
                    ScrollDirection.Down
                } else {
                    ScrollDirection.Up
                }
                positionY = firstVisibleItemScrollOffset
                visibleItem = firstVisibleItemIndex
                direction
            }
        }
    }
}

enum class ScrollDirection {
    Up, Down, None
}