package com.example.a30daystips

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daystips.model.Tip
import com.example.a30daystips.model.tipsList
import com.example.a30daystips.ui.theme._30DaysTipsTheme


@Composable
fun TipsApp() {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        Column {
            Box(modifier = Modifier.weight(0.9f)) {
                TipsList(
                    contentPadding = it
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.02f)
                    .fillMaxWidth()
            ) {
                BottomAppTitle()
            }
            Box(modifier = Modifier.weight(0.015f)){
                Spacer(modifier = Modifier)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipItem(
    tip: Tip,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer, label = ""
    )

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = { expanded = !expanded },
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(id = R.dimen.padding_large))
    ) {
        Column(
            modifier = Modifier
                .background(color)
                .padding(dimensionResource(id = R.dimen.padding_small))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
        ) {
            Text(
                text = stringResource(id = R.string.day, tip.day),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(id = tip.summary),
                style = MaterialTheme.typography.displayLarge
            )
            Image(
                painter = painterResource(id = tip.image),
                contentDescription = null,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop,
            )
            if (expanded) {
                Text(
                    text = stringResource(id = tip.desc),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun TipsList(
    contentPadding: PaddingValues
) {
    LazyColumn(
        contentPadding = contentPadding
    ) {
        items(tipsList) {
            TipItem(
                tip = it
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    )
}

@Composable
fun BottomAppTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val uriHandler = LocalUriHandler.current
        val site = stringResource(id = R.string.icons_site)
        Text(
            text = stringResource(id = R.string.version, 1.0),
            style = MaterialTheme.typography.bodySmall,
        )
        Text(text = " | ")
        Text(
            text = stringResource(id = R.string.title),
            style = MaterialTheme.typography.bodySmall,
        )
        Text(text = " | ")
        Row {
            Text(
                text = "${stringResource(id = R.string.icons)} ",
                style = MaterialTheme.typography.bodySmall,
            )
            ClickableText(
                text = AnnotatedString(stringResource(id = R.string.icons_title)),
                style = MaterialTheme.typography.bodyMedium,
                onClick = {uriHandler.openUri(site)}
            )
        }
    }
}

@Preview
@Composable
fun LightThemePreview() {
    _30DaysTipsTheme(darkTheme = false) {
        TipsApp()
    }
}

@Preview
@Composable
fun DarkThemePreview() {
    _30DaysTipsTheme(darkTheme = true) {
        TipsApp()
    }
}