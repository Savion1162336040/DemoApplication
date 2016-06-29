package com.example.test3;

import java.util.concurrent.atomic.AtomicInteger;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LauchModeActivity extends Activity {
	ImageView[] imageViews;
	LinearLayout group;
	AtomicInteger atomic = new AtomicInteger(0);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lauchmode_activity);
		group = (LinearLayout) findViewById(R.id.group);
		initGroup();
		threadGroup();
	}

	private void initGroup() {
		// banner小圆点图片数组
		imageViews = new ImageView[5];
		group.removeAllViews();
		ImageView imageView;
		for (int i = 0; i < 5; i++) {
			imageView = new ImageView(this);
			imageView.setLayoutParams(new ViewGroup.LayoutParams(20, 20));
			imageView.setPadding(5, 5, 5, 5);
			imageViews[i] = imageView;
			if (i == 0) {
				imageViews[i].setImageResource(R.drawable.dot_red);
			} else {
				imageViews[i].setImageResource(R.drawable.dot);
			}
			group.addView(imageViews[i]);
		}
	}

	private void threadGroup() {
		new Thread() {
			public void run() {
				super.run();
				try {
					while (true) {
						sleep(2000);
						handler.sendEmptyMessage(atomic.get());
						atomic.incrementAndGet();
					}
				} catch (Exception e) {
				}
			};
		}.start();
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[i].setImageResource(R.drawable.dot);
				if (msg.what == i) {
					imageViews[i].setImageResource(R.drawable.dot_red);
				}
			}
		};
	};
}
