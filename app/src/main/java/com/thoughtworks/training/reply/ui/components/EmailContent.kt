package com.thoughtworks.training.reply.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.thoughtworks.training.reply.ui.ReplyHomeViewModel

@Composable
fun EmailContent() {
    val replyHomeViewModel = ReplyHomeViewModel()
    val allEmails by replyHomeViewModel.allEmails.collectAsState(initial = emptyList())
    LazyColumn {
        items(items = allEmails) { email ->
            Text(text = email.body)
        }
    }
}