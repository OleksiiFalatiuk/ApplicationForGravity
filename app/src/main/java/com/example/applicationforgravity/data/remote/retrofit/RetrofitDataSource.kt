package com.example.applicationforgravity.data.remote.retrofit

import com.example.applicationforgravity.data.remote.RemoteDataSource
import com.example.applicationforgravity.model.LinkAndHome

class RetrofitDataSource(private val api: LinkApiService): RemoteDataSource {


    override suspend fun loadLinkAndHome(): LinkAndHome {
        val word = api.getLinkAndHome()
        return LinkAndHome(
            link = word.link,
            home = word.home
        )
    }

}