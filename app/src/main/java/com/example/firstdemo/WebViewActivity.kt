package com.example.firstdemo

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.firstdemo.databinding.ActivityWebViewBinding

/**
 * Description: This is the activity class of WebViewActivity,
 *              And this is use for showing the demo of webView in android kotlin.
 *@author: Abhishek Oza.
 * @since:11th March 2022.
 */

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.go.setOnClickListener(View.OnClickListener {


            if (binding.webView != null){
                val webSettings  = binding.webView.settings
                webSettings.javaScriptEnabled= true

                binding.webView.webChromeClient = WebChromeClient()
                binding.webView.loadUrl(binding.editView.text.toString())

                binding.webView.webViewClient = object : WebViewClient(){

                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        binding.progress.visibility = View.VISIBLE

                        super.onPageStarted(view, url, favicon)
                    }

                    override fun onPageFinished(view: WebView?, url: String?) {

                        binding.progress.visibility = View.INVISIBLE
                        super.onPageFinished(view, url)
                    }



                }
            }
        })




    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()){
            binding.webView.goBack()
        }
        else{
            super.onBackPressed()
        }
    }
}