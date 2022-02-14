package com.example.applicationforgravity.data.remote

import com.example.applicationforgravity.model.LinkAndHome

interface RemoteDataSource {

    suspend fun loadLinkAndHome(): LinkAndHome
}