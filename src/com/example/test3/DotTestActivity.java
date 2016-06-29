package com.example.test3;

import com.example.dot.DoTView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class DotTestActivity extends Activity implements OnClickListener{
	DoTView doTView;
	int index = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dot_activity);
		doTView = (DoTView) findViewById(R.id.dotView);
	}

	@Override
	public void onClick(View v) {
	    switch (v.getId()) {
	        case R.id.btn:
	        	index ++ ; 
	            doTView.setSelectPosition(index%5);
	            break;
	        default:
	            break;
	    }
	}
}
