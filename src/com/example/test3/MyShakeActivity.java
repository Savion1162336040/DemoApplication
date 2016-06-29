package com.example.test3;

import com.cqmc.andong.shake.ShakeListener;
import com.cqmc.andong.shake.ShakeListener.OnShakeListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MyShakeActivity extends Activity {

	ShakeListener listener;
	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myshake_activity);
		iv = (ImageView) findViewById(R.id.shake_iv);
		listener = new ShakeListener(getApplicationContext());
		listener.setOnShakeListener(new OnShakeListener() {
			@Override
			public void onShake() {
				Toast.makeText(getApplicationContext(), "正在摇一摇", Toast.LENGTH_LONG).show();
				Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_anim);
				iv.startAnimation(anim);
			}
		});
	}

}
