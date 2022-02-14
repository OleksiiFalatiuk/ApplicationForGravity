package com.example.applicationforgravity.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationforgravity.data.LinkRepository
import com.example.applicationforgravity.model.LinkAndHome
import com.example.applicationforgravity.result.Error
import com.example.applicationforgravity.result.Result
import com.example.applicationforgravity.result.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoadingViewModel(private val repository: LinkRepository): ViewModel() {

    private val _loadingLinkLiveData = MutableLiveData<Result<LinkAndHome>>()
    private val _isLoadingLiveData = MutableLiveData<Boolean>()

    val loadingLinkLiveData : LiveData<Result<LinkAndHome>> = _loadingLinkLiveData
    val isLoadingLiveData: LiveData<Boolean> = _isLoadingLiveData


    init {
        viewModelScope.launch {
            _isLoadingLiveData.value = true
            loadLinkAndHome()
            _isLoadingLiveData.value = false
        }
    }

    private suspend fun loadLinkAndHome() = withContext(Dispatchers.Main){
            _loadingLinkLiveData.value = repository.loadLinkAndHome()
    }


}