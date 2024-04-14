package com.thoughtworks.training.reply.ui

import androidx.lifecycle.ViewModel
import com.thoughtworks.training.reply.data.Email
import com.thoughtworks.training.reply.data.EmailsRepository
import com.thoughtworks.training.reply.data.EmailsRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReplyHomeViewModel(
    private val emailsRepository: EmailsRepository = EmailsRepositoryImpl()
) : ViewModel() {

}

