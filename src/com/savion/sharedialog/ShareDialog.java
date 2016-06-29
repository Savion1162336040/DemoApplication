package com.savion.sharedialog;

import com.example.test3.R;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class ShareDialog implements IShareDialog {

	private static ShareDialog instance;
	private Dialog mDialog;
	private String mTitle;
	private OnDialogEvent mListener;
	private int mColumnCount = 3;
	private boolean mCanTouchable = true;
	private Context mContext;

	private ShareDialog(Context context) {
		this.mContext = context;
		mDialog = new Dialog(context);
	}

	public static ShareDialog getInstance(Context context) {
		if (instance == null) {
			instance = new ShareDialog(context);
		}
		return instance;
	}

	@Override
	public void setTitle(String title) {
		this.mTitle = title;
	}

	@Override
	public void canTouchable(boolean b) {
		this.mCanTouchable = b;
	}

	@Override
	public void setColumn(int count) {
		this.mColumnCount = count;
	}

	@Override
	public void setListener(OnDialogEvent listener) {
		this.mListener = listener;
	}

	@Override
	public void dismissDialog() {
		if (mDialog == null && mDialog.isShowing()) {
			mDialog.dismiss();
		}
	}

	@Override
	public void showDialog(Context context) {
		mDialog = new Dialog(mContext, R.style.common_dialog);
		mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		mDialog.setContentView(R.layout.layout_share_grid_popup);
		mDialog.setCancelable(mCanTouchable);
		mDialog.setCanceledOnTouchOutside(mCanTouchable);
		mDialog.show();
		Window window = mDialog.getWindow();
		LayoutParams layout = window.getAttributes();
		window.getDecorView().setPadding(0, 0, 0, 0);
		layout.gravity = Gravity.BOTTOM;
		layout.width = LayoutParams.MATCH_PARENT;
		mDialog.getWindow().setAttributes(layout);
	}

}
