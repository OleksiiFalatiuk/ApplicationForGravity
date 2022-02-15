package com.example.applicationforgravity.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.applicationforgravity.R
import com.example.applicationforgravity.data.local.sharedpreferences.Shared
import com.example.applicationforgravity.progress.LoadingViewModel
import com.example.applicationforgravity.progress.LoadingViewModelFactory
import com.example.applicationforgravity.provider.LinkAndHomeProvider
import com.example.applicationforgravity.result.Success

class FragmentWithData: Fragment(){

    private val viewDetailModel: LoadingViewModel by viewModels{
        LoadingViewModelFactory((requireActivity() as LinkAndHomeProvider).provideLinkAndHome())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_with_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shared = Shared(requireActivity().application)

        viewDetailModel.loadingLinkLiveData.observe(viewLifecycleOwner, Observer {
            if (it is Success){
                it.data?.let { it1 ->
                    val url: String = if (shared.isFirst){
                        shared.isFirst = false
                        it1.link
                    }
                    else{
                        it1.home
                    }
                    view.findViewById<WebView>(R.id.webView).loadUrl(url)
                }
            }

        })
    }

    companion object{
        fun create() = FragmentWithData()
    }
}