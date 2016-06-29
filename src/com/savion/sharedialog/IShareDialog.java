package com.savion.sharedialog;

import android.content.Context;

public interface IShareDialog {
	//设置分享标题
	void setTitle(String title);
	//设置是否可点击阴影区域来取消dialog
	void canTouchable(boolean b);
	//设置显示的列数
	void setColumn(int count);
	//取消弹框
	void dismissDialog();
	//显示弹框
	void showDialog(Context context);
	//设置回调监听
	void setListener(OnDialogEvent listener);
}
