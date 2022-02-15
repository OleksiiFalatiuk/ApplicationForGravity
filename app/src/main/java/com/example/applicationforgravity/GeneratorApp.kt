package com.example.applicationforgravity

import android.app.Application
import com.example.applicationforgravity.data.local.room.AppDataBase
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
class GeneratorApp: Application() {
    companion object{
        lateinit var appData: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()

        appData = AppDataBase.getInstance(this)
    }

}