package com.example.test3.webchromeclient;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import android.widget.Toast;

public class MyInterFace{
	public MyInterFace(){
		
	}
	@SuppressLint({"JavascriptInterface","SetJavaScriptEnabled"})
	public static void onButtonClick(WebView webview ,String msg){
		Toast.makeText(webview.getContext(), msg, 1000).show();
	}
}
