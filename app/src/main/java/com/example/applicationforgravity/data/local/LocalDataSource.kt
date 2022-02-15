package com.example.applicationforgravity.data.local

import com.example.applicationforgravity.model.LinkAndHome

interface LocalDataSource {

    suspend fun loadLinkAndHome(): List<LinkAndHome>

    fun insertLinkAndHome(obj: LinkAndHome)

}