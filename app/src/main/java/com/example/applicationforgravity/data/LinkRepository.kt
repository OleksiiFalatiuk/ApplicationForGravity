package com.example.applicationforgravity.data

import com.example.applicationforgravity.model.LinkAndHome

interface LinkRepository {
    suspend fun loadLinkAndHome(): LinkAndHome
}