package com.example.applicationforgravity.progress

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.applicationforgravity.data.LinkRepository

class LoadingViewModelFactory(private val repository: LinkRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = LoadingViewModel(repository) as T
}