package com.example.applicationforgravity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applicationforgravity.progress.FragmentWithLoading

class MainActivity : AppCompatActivity() {
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

}