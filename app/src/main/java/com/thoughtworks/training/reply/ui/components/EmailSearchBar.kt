package com.thoughtworks.training.reply.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thoughtworks.training.reply.R
import com.thoughtworks.training.reply.data.Email
import com.thoughtworks.training.reply.ui.ReplyHomeViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EmailSearchBar() {

    val replyHomeViewModel = ReplyHomeViewModel()
    val emails by replyHomeViewModel.allEmails.collectAsState(initial = emptyList())
    var active by rememberSaveable { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }
    val searchResults = remember { mutableStateListOf<Email>() }

    LaunchedEffect(query) {
        searchResults.clear()
        if (query.isNotEmpty()) {
            searchResults.addAll(
                emails.filter {
                    it.subject.startsWith(
                        prefix = query,
                        ignoreCase = true
                    ) || it.sender.fullName.startsWith(
                        prefix =
                        query,
                        ignoreCase = true
                    )
                }
            )
        }
    }

    SearchBar(
        query = query,
        onQueryChange = { query = it },
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
        if (searchResults.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(items = searchResults, key = { it.id }) { email ->
                    SearchResultItem(email)
                }
            }
        } else if (query.isNotEmpty()) {
            Text(
                text = stringResource(id = R.string.no_item_found),
                modifier = Modifier.padding(16.dp)
            )
        } else
            Text(
                text = stringResource(id = R.string.no_search_history),
                modifier = Modifier.padding(16.dp)
            )
    }
}

@Composable
fun SearchResultItem(email: Email, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(top = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape),
            painter = painterResource(email.sender.avatar),
            contentDescription = email.sender.fullName,
        )
        Column(
            modifier = modifier.padding(start = 10.dp)
        ) {
            Text(
                text = email.subject,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = email.sender.fullName,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}
