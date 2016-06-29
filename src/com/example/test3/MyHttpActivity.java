package com.example.test3;

import com.example.http.HttpUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyHttpActivity extends Activity{
	Button btn_zx;
	Button btn_zx2;
	Button btn_zx3;
	Button btn_zx4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myhttp_activity);
		btn_zx = (Button) findViewById(R.id.btn_http_zx);
		btn_zx.setOnClickListener(myclick);
		btn_zx2 = (Button) findViewById(R.id.btn_http_zx2);
		btn_zx2.setOnClickListener(myclick);
		btn_zx3 = (Button) findViewById(R.id.btn_http_zx3);
		btn_zx3.setOnClickListener(myclick);
		btn_zx4 = (Button) findViewById(R.id.btn_http_zx4);
		btn_zx4.setOnClickListener(myclick);
	}

	OnClickListener myclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_http_zx:
//				HttpUtils.getInstance().getNewsList(getApplicationContext(), "http://wap.cq.10086.cn/surfdesk/newshandler.jsp",handler);//"http://go.10086.cn/p/info/surfdesk",handler);
				HttpUtils.getInstance().getNewList(getApplicationContext(), "18223833994", handler);
				break;
			case R.id.btn_http_zx2:
				HttpUtils.getInstance().getNewsDetail(getApplicationContext(), "7341749", "18223833994", handler);
				break;
			case R.id.btn_http_zx3:
				HttpUtils.getInstance().getNewImgList(getApplicationContext(), "18223833994", handler);
				break;
			case R.id.btn_http_zx4:
				HttpUtils.getInstance().getNewImgDetail(getApplicationContext(), "","18223833994", handler);
				break;
			default:
				break;
			}
		}
	};
	
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case HttpUtils.HTTP_SUCCEED:
				Log.e("savion", msg.obj.toString());
				break;
			default:
				break;
			}
		};
	};

}
