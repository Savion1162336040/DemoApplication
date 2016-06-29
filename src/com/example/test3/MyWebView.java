package com.example.test3;

import java.io.IOException;

import com.example.test3.webchromeclient.InjectedChromeClient;
import com.example.test3.webchromeclient.MyInterFace;
import com.example.test3.webchromeclient.MyInterFace2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class MyWebView extends Activity{
	
	@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_view);
		WebView web = (WebView) findViewById(R.id.web_view_web);
		web.getSettings().setJavaScriptEnabled(true);
		MyInterFace2 m2 = new MyInterFace2(MyWebView.this);
		web.addJavascriptInterface(m2, "jsInterface");
		//web.setWebChromeClient(new MyWebChromeClient("jsInterface",MyInterFace.class));
		AssetManager am = getAssets();
		web.loadUrl("file:///android_asset/app/index-01.html");
	}	
	
	
//	class MyWebChromeClient extends InjectedChromeClient{
//		
//		public MyWebChromeClient(String interfaces,Class clazz) {
//			super(interfaces, clazz);
//		}
//	
//	}

}
