package com.example.applicationforgravity.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.applicationforgravity.R

class FragmentWithLoading: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loading_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }




    companion object{
        fun create() = FragmentWithLoading()
    }
}