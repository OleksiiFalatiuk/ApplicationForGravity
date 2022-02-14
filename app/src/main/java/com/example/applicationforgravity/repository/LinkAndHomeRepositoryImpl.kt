package com.example.applicationforgravity.repository

import com.example.applicationforgravity.data.LinkRepository
import com.example.applicationforgravity.data.remote.RemoteDataSource
import com.example.applicationforgravity.model.LinkAndHome
import com.example.applicationforgravity.result.Result
import com.example.applicationforgravity.result.checkResultDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LinkAndHomeRepositoryImpl(private val remote: RemoteDataSource):LinkRepository {

    override suspend fun loadLinkAndHome(): Result<LinkAndHome> {
        return checkResultDetails {
            withContext(Dispatchers.IO){
                remote.loadLinkAndHome()
            }
        }
    }
}