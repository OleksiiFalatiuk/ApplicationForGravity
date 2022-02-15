package com.example.applicationforgravity.repository

import android.util.Log
import com.example.applicationforgravity.data.LinkRepository
import com.example.applicationforgravity.data.local.LocalDataSource
import com.example.applicationforgravity.data.remote.RemoteDataSource
import com.example.applicationforgravity.model.LinkAndHome
import com.example.applicationforgravity.result.Result
import com.example.applicationforgravity.result.checkResultDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LinkAndHomeRepositoryImpl(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) : LinkRepository {

    override suspend fun loadLinkAndHome(): Result<LinkAndHome> {
        return checkResultDetails {
            withContext(Dispatchers.IO) {
                val db = local.loadLinkAndHome()
                val some = db.find { it.link.isEmpty() }
                (if (some == null) {
                    val dataFrom = remote.loadLinkAndHome()
                    local.insertLinkAndHome(dataFrom)
                    dataFrom
                } else {
                    db
                })
            } as LinkAndHome
        }
    }
}