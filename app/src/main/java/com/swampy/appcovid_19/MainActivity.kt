package com.swampy.appcovid_19

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.webkit.WebSettings.PluginState
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val actionBar = supportActionBar?.apply{hide()}
       val statusBarManager = setStatusBarColor(color = 16777215 ).apply {} //color = 16777215

        var link_sito_alternativo = "https://statistichecoronavirus.it/stati-coronavirus/"

        val webView = findViewById<WebView>(R.id.web) as WebView
        webView.webViewClient = WebViewClient()
        webView.settings.pluginState = PluginState.ON
        webView.settings.javaScriptEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = false
        //webView.settings.
        webView.settings.setSupportMultipleWindows(false)
        webView.settings.setSupportZoom(false)
        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
        webView.loadUrl(link_sito_alternativo)

    }

    fun setStatusBarColor(color: Int) { //Colore barra di stato automatico
        val window = window
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = color
    }
}
