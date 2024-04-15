package com.thoughtworks.training.reply.ui

import androidx.lifecycle.ViewModel
import com.thoughtworks.training.reply.data.AccountsRepository
import com.thoughtworks.training.reply.data.AccountsRepositoryImpl
import com.thoughtworks.training.reply.data.EmailsRepository
import com.thoughtworks.training.reply.data.EmailsRepositoryImpl


class ReplyHomeViewModel(
    private val emailsRepository: EmailsRepository = EmailsRepositoryImpl(),
    private val accountsRepository: AccountsRepository = AccountsRepositoryImpl()
) : ViewModel() {

    private val allEmails = emailsRepository.getAllEmails()

    private val allAccounts = accountsRepository.getAllUserAccounts()

}

