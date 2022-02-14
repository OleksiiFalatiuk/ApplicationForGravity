package com.example.applicationforgravity.data

import com.example.applicationforgravity.model.LinkAndHome
import com.example.applicationforgravity.result.Result

interface LinkRepository {
    suspend fun loadLinkAndHome(): Result<LinkAndHome>
}