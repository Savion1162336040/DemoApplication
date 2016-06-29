package com.example.test3.webchromeclient;

import com.example.test3.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupWindow.OnDismissListener;

public class MyInterFace2 {
	Activity mActivity;
	View denpendview;
	PopupWindow popupWindow;

	public MyInterFace2(Activity activity) {
		this.mActivity = activity;
		denpendview = mActivity.getWindow().getDecorView();
		System.out.println(denpendview.toString());
	}


	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	public void onButtonClick(String msg) {
		Toast.makeText(mActivity, msg, 1000).show();
		Message msgs = new Message();
		msgs.what = 1;
		msgs.obj = msg;
		handler.sendMessage(msgs);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Message msgg = new Message();
				msgg.what = 1;
				msgg.obj = "你好";
				handler.sendMessage(msgg);
			}
		}, 1000);
	}
	Handler handler2 = new Handler(){
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			backgroundAlpha(0.6f);
		};
	};

	@SuppressLint("HandlerLeak")
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			Object obj = msg.obj;
			if (msg.what == 1) {
				showPop("" + obj);
			}
		};
	};

	public void showPop(String msg) {
		if (popupWindow!=null&&popupWindow.isShowing()) {
			return;
		}
		View contentView = LayoutInflater.from(mActivity.getBaseContext()).inflate(R.layout.layout_share_grid_popup,
				null);
		popupWindow = new PopupWindow();
		popupWindow.setContentView(contentView);
		popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
		popupWindow.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setTouchable(true);
		popupWindow.setFocusable(true);
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
		// 我觉得这里是API的一个bug
		// popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 设置好参数之后再show
		popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		popupWindow.setOnDismissListener(mydismiss);
		popupWindow.setAnimationStyle(R.style.popup_animation);
		// 点击空白处时，隐藏掉pop窗口
		// popupWindow.showAtLocation(view,
		// Gravity.BOTTOM|Gravity.CENTER_VERTICAL, 0, 0);
		popupWindow.showAtLocation(denpendview, Gravity.BOTTOM, 0, 0);
		backgroundAlpha(0.6f);
		if (msg != null) {
			TextView cancel = (TextView) contentView.findViewById(R.id.layout_pay_agency_cancel);
			TextView titleView = (TextView) contentView.findViewById(R.id.layout_pay_agency_title);
			TextView empty = (TextView) contentView.findViewById(R.id.layout_pay_agency_empty);
			// group是R.layou.main中的负责包裹小圆点的LinearLayout.
			LinearLayout group = (LinearLayout) contentView.findViewById(R.id.viewGroup);
			cancel.setOnClickListener(myclick);
			empty.setOnClickListener(myclick);
			titleView.setText(msg + "");
		}
	}

	OnClickListener myclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.layout_pay_agency_cancel:
				if (popupWindow != null) {
					popupWindow.dismiss();
				}
				break;
			case R.id.layout_pay_agency_empty:
				if (popupWindow != null && popupWindow.isShowing()) {
					popupWindow.dismiss();
				}
				break;
			default:
				break;
			}
		}
	};
	OnDismissListener mydismiss = new OnDismissListener() {
		@Override
		public void onDismiss() {
			backgroundAlpha(1.0f);
		}
	};

	/**
	 * 设置添加屏幕的背景透明度
	 *
	 * @param bgAlpha
	 */
	public void backgroundAlpha(float bgAlpha) {
		WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
		lp.alpha = bgAlpha; // 0.0-1.0
		mActivity.getWindow().setAttributes(lp);
	}
}
