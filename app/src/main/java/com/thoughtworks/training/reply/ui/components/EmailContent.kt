package com.thoughtworks.training.reply.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.thoughtworks.training.reply.R


@RequiresApi(Build.VERSION_CODES.M)
@Composable
@Preview(showBackground = true, backgroundColor = 0xFFfdf0e3)
@OptIn(ExperimentalMaterial3Api::class)
fun EmailContent(@PreviewParameter(BackgroundColorProvider::class) modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        SearchBar()
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SearchBar() {
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    SearchBar(
        query = text,
        onQueryChange = { text = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = {
            active = it
        },
        placeholder = { Text("Search emails") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        trailingIcon = {
            Image(
                painter = painterResource(R.drawable.avatar_6),
                contentDescription = "Avatar",
                modifier = Modifier
                    .padding(12.dp)
                    .size(32.dp)
                    .clip(CircleShape),
            )
        },
    ) {

    }
}


class BackgroundColorProvider : PreviewParameterProvider<Modifier> {
    override val values: Sequence<Modifier>
        get() = sequenceOf(Modifier, Modifier.fillMaxSize())
}