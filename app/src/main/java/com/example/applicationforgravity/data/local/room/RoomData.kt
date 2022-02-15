package com.example.applicationforgravity.data.local.room

import com.example.applicationforgravity.data.local.LocalDataSource
import com.example.applicationforgravity.model.LinkAndHome


class RoomData(private val app: AppDataBase): LocalDataSource {


    override suspend fun loadLinkAndHome(): List<LinkAndHome> {
//        val some = app.getLinkAndHomeDao().getMovies()
//        return LinkAndHome(
//            link = some.link,
//            home = some.home
//        )
        return app.getLinkAndHomeDao().getMovies().map {
            LinkAndHome(
                link = it.link,
                home = it.home
            )
        }
    }

    override fun insertLinkAndHome(obj: LinkAndHome) {
        val dataBase = LinkAndHomeDbEntity(
            link = obj.link,
            home = obj.home
        )
        app.getLinkAndHomeDao().insertMovies(dataBase)
    }

}