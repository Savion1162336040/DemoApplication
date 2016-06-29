package com.savion.sharedialog;

import com.example.entity.MShareMsg;

/**
 * @author Administrator popupwindow事件处理
 */
public interface OnDialogEvent {
	// 内容项被点击时
	void onItemClick(MShareMsg position);

	// popupwindow消失时
	void onPopDismiss();
}
