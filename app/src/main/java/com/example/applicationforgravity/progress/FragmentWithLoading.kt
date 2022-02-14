package com.example.applicationforgravity.progress

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.applicationforgravity.R
import com.example.applicationforgravity.provider.LinkAndHomeProvider
import com.example.applicationforgravity.result.Error
import com.example.applicationforgravity.result.Success
import com.example.applicationforgravity.webview.FragmentWithData

class FragmentWithLoading: Fragment() {


    private val viewDetailModel: LoadingViewModel by viewModels{
        LoadingViewModelFactory((requireActivity() as LinkAndHomeProvider).provideLinkAndHome())
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loading_layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDetailModel.isLoadingLiveData.observe(viewLifecycleOwner, Observer {
            view.findViewById<ProgressBar>(R.id.progressBar).isVisible = it
        })

        viewDetailModel.loadingLinkLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is Error -> Toast.makeText(requireActivity(), it.ex.toString(), Toast.LENGTH_SHORT).show()
                is Success -> someFun()
            }.let {}
        })


    }

    private fun someFun(){
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.flMain,
                FragmentWithData.create(),
                FragmentWithData::class.java.simpleName
            )
            .addToBackStack("trans:${FragmentWithData::class.java.simpleName}")
            .commit()
    }




    companion object{
        fun create() = FragmentWithLoading()
    }
}