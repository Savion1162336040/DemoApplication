package com.example.test3;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.example.entity.MShareMsg;
import com.savion.sharedialog.ShareDialog;
import com.savion.sharedialog.ShareDialogFragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	private Button btn_jump;
	private Button btn_jump_aactivity;
	private Button btn_jump_bactivity;
	private Button btn_jump_web;
	private Button btn_jump_shake;
	private Button btn_jump_okhttp;
	private Button btn_jump_dot;
	private Button btn_jump_lauchmode;
	private Button btn_jump_sharedialog;
	private Button btn_jump_notification;
	PackageManager pm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_jump = (Button) findViewById(R.id.btn_jump);
		btn_jump_aactivity = (Button) findViewById(R.id.btn_jump_aactivity);
		btn_jump_bactivity = (Button) findViewById(R.id.btn_jump_bactivity);
		btn_jump_web = (Button) findViewById(R.id.btn_jump_web);
		btn_jump_shake = (Button) findViewById(R.id.btn_jump_shake);
		btn_jump_okhttp = (Button) findViewById(R.id.btn_jump_okhttp);
		btn_jump_dot = (Button) findViewById(R.id.btn_jump_dot);
		btn_jump_lauchmode = (Button) findViewById(R.id.btn_jump_lauchmode);
		btn_jump_sharedialog = (Button) findViewById(R.id.btn_jump_sharedialog);
		btn_jump_notification = (Button) findViewById(R.id.btn_jump_notification);
		btn_jump.setOnClickListener(myclick);
		btn_jump_aactivity.setOnClickListener(myclick);
		btn_jump_bactivity.setOnClickListener(myclick);
		btn_jump_web.setOnClickListener(myclick);
		btn_jump_shake.setOnClickListener(myclick);
		btn_jump_okhttp.setOnClickListener(myclick);
		btn_jump_dot.setOnClickListener(myclick);
		btn_jump_lauchmode.setOnClickListener(myclick);
		btn_jump_sharedialog.setOnClickListener(myclick);
		btn_jump_notification.setOnClickListener(myclick);
	}
	
	class MyInterPolator implements Interpolator{

		@Override
		public float getInterpolation(float input) {
			return 0;
		}
	}
	

	OnClickListener myclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_jump:
				Intent it = new Intent();
				it.setClassName("com.cqmc.client", "com.cqmc.client.MainPageActivity");
				startActivity(it);
				break;
			case R.id.btn_jump_aactivity:
				Intent it2 = new Intent();
				it2.setClassName("com.savion.test", "com.savion.test.AActivity");
				startActivity(it2);
				break;
			case R.id.btn_jump_bactivity:
				Intent it3 = new Intent();
				it3.setClassName("com.savion.test", "com.savion.test.BActivity");
				startActivity(it3);
				break;
			case R.id.btn_jump_web:
				Intent it4 = new Intent(getApplicationContext(), WebView2.class);
				startActivity(it4);
				break;
			case R.id.btn_jump_shake:
				Intent it5 = new Intent(getApplicationContext(),MyShakeActivity.class);
				startActivity(it5);
				break;
			case R.id.btn_jump_okhttp:
				Intent it6 = new Intent(getApplicationContext(),MyHttpActivity.class);
				startActivity(it6);
				break;
			case R.id.btn_jump_dot:
				Intent it7 = new Intent(getApplicationContext(),DotTestActivity.class);
				startActivity(it7);
				break;
			case R.id.btn_jump_lauchmode:
				Intent it8 = new Intent(getApplicationContext(),LauchModeActivity.class);
				startActivity(it8);
				break;
			case R.id.btn_jump_sharedialog:
				FragmentManager fm = getSupportFragmentManager();
				ShareDialogFragment fragment = new ShareDialogFragment();
				fragment.show(fm, "tag");
				break;
			case R.id.btn_jump_notification:
				Intent it9 = new Intent(getApplicationContext(),NotificationActivity.class);
				startActivity(it9);
				break;
			default:
				break;
			}
		}
	};
	
	Handler lauchHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			Intent it = new Intent(getApplicationContext(),LauchModeActivity.class);
			startActivity(it);
			
		};
	};

	/*
	 * 原生分享模块，获得分享的应用数据
	 */
	public static ArrayList<MShareMsg> getShareGridItemsWithQQ(Context c) {
		String pkgName = null;
		MShareMsg msg = null;
		ArrayList<MShareMsg> listItems = new ArrayList<MShareMsg>();
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		PackageManager pm = c.getPackageManager();
		List<ResolveInfo> matches = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		boolean isGetWx = false;
		boolean isGetQQ = false;
		for (ResolveInfo each : matches) {
			pkgName = each.activityInfo.applicationInfo.packageName;
			if (pkgName.contains("tencent.mm")) {
				if (isGetWx == true)
					continue;
				msg = new MShareMsg();
				msg.setTitle("微信");
				msg.setPackageName(pkgName);
				msg.setActivityName(each.activityInfo.name);
				msg.setIcon(each.activityInfo.loadIcon(pm));
				listItems.add(msg);
				msg = new MShareMsg();
				msg.setTitle("微信朋友圈");
				msg.setPackageName(pkgName);
				msg.setActivityName("com.tencent.mm.ui.tools.ShareToTimeLineUI");
				msg.setIcon(c.getResources().getDrawable(R.drawable.ic_launcher));
				listItems.add(msg);
				isGetWx = true;
			} else if (pkgName.contains("android.mms")) {
				msg = new MShareMsg();
				msg.setTitle("短信");
				msg.setPackageName(pkgName);
				msg.setActivityName(each.activityInfo.name);
				msg.setIcon(each.activityInfo.loadIcon(pm));
				listItems.add(msg);
			} else if (pkgName.contains("tencent.mobileqq")) {
				if (isGetQQ) {
					continue;
				}
				msg = new MShareMsg();
				msg = new MShareMsg();
				msg.setTitle("QQ");
				msg.setPackageName(pkgName);
				msg.setActivityName(each.activityInfo.name);
				msg.setIcon(each.activityInfo.loadIcon(pm));
				listItems.add(msg);
				isGetQQ = true;
			}

		}
		return listItems;
	}

}
