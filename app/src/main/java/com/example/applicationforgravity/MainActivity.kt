package com.example.applicationforgravity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applicationforgravity.data.LinkRepository
import com.example.applicationforgravity.data.local.room.RoomData
import com.example.applicationforgravity.data.remote.retrofit.RetrofitDataSource
import com.example.applicationforgravity.progress.FragmentWithLoading
import com.example.applicationforgravity.provider.LinkAndHomeProvider
import com.example.applicationforgravity.provider.NetworkModule
import com.example.applicationforgravity.repository.LinkAndHomeRepositoryImpl
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity(), LinkAndHomeProvider {

    private val network = NetworkModule()

    private val remote = RetrofitDataSource(network.api)

    @InternalCoroutinesApi
    private val local = RoomData(GeneratorApp.appData)

    @InternalCoroutinesApi
    private val repository = LinkAndHomeRepositoryImpl(remote,local)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            toFragmentWithLoading()
        }
    }


    private fun toFragmentWithLoading(){
        supportFragmentManager.beginTransaction()
            .add(
                R.id.flMain,
                FragmentWithLoading.create(),
                FragmentWithLoading::class.java.simpleName
            )
            .addToBackStack("trans:${FragmentWithLoading::class.java.simpleName}")
            .commit()
    }

    @InternalCoroutinesApi
    override fun provideLinkAndHome(): LinkRepository = repository


}