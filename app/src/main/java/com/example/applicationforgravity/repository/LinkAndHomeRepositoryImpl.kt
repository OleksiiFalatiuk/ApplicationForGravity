package com.example.applicationforgravity.repository

import com.example.applicationforgravity.data.LinkRepository
import com.example.applicationforgravity.data.remote.RemoteDataSource
import com.example.applicationforgravity.model.LinkAndHome

class LinkAndHomeRepositoryImpl(private val remote: RemoteDataSource):LinkRepository {

    override suspend fun loadLinkAndHome(): LinkAndHome {
        return remote.loadLinkAndHome()
    }
}