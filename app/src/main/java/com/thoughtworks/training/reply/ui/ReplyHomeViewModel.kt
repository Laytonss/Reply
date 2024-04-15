package com.thoughtworks.training.reply.ui

import androidx.lifecycle.ViewModel
import com.thoughtworks.training.reply.data.AccountsRepository
import com.thoughtworks.training.reply.data.AccountsRepositoryImpl
import com.thoughtworks.training.reply.data.Email
import com.thoughtworks.training.reply.data.EmailsRepository
import com.thoughtworks.training.reply.data.EmailsRepositoryImpl
import kotlinx.coroutines.flow.Flow


class ReplyHomeViewModel(
    private val emailsRepository: EmailsRepository = EmailsRepositoryImpl(),
    private val accountsRepository: AccountsRepository = AccountsRepositoryImpl()
) : ViewModel() {

    val allEmails: Flow<List<Email>> = emailsRepository.getAllEmails()

    val allAccounts = accountsRepository.getAllUserAccounts()

}

