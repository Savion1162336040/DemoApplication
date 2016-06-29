package com.example.test3;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity{
	Button btn_notifi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_activity);
		
		btn_notifi = (Button) findViewById(R.id.btn_opennotification);
		btn_notifi.setOnClickListener(myclick);
	}
	
	OnClickListener myclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_opennotification:
				showNotify("收到新消息", "人间", "红酒杯里的三个故事","method", "target", getApplicationContext());
				break;
			default:
				break;
			}
		}
	};
	
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public static void showNotify(String notice_title, String title, String detail, String method, String target, Context context) {
		try {
			Intent intent = new Intent(context, MyShakeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.putExtra("method", method);
			intent.putExtra("param", "");
			intent.putExtra("packageName", "com.cqmc.client");
			intent.putExtra("login", "0");
			intent.putExtra("activityName", target);
			PendingIntent newsPendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
			//notice.setLatestEventInfo(context, title, detail, newsPendingIntent);
			Notification.Builder notice = new Notification.Builder(context);
//			notice.icon = R.drawable.ic_launcher;
//			notice.tickerText = notice_title;
//			notice.defaults = Notification.DEFAULT_SOUND;
//			notice.when = System.currentTimeMillis();
//			notice.flags = Notification.FLAG_AUTO_CANCEL;
			NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
			notice.setSmallIcon(R.drawable.ic_launcher);
			notice.setContentTitle(title);
			notice.setContentText(detail);
			notice.setContentIntent(newsPendingIntent);
			notice.setWhen(System.currentTimeMillis());
			notice.setDefaults(Notification.DEFAULT_SOUND);
			notice.setTicker(notice_title);
			
			notificationManager.notify(0, notice.build());
		} catch (Exception e) {
		}
	}

}
