package com.savion.sharedialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class ShareDialogFragment extends DialogFragment{
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog simpleDialog = createSimpleDialog();
		simpleDialog = createListDialog();
		return simpleDialog;
	}
	/**
	 * 简单dialog
	 * @return
	 */
	private AlertDialog createSimpleDialog(){
		AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
		build.setMessage("简单Dialog").setPositiveButton("可以", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getContext(), "可以", Toast.LENGTH_SHORT).show();
			}
		}).setNegativeButton("不可以", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getContext(), "不可以", Toast.LENGTH_SHORT).show();
			}
		});
		return build.create();
	}
	/**
	 * 列表Dialog
	 * @return
	 */
	private AlertDialog createListDialog(){
		AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
		final String[] strs = new String[]{"rad","green","blue","gray","orange","white","black","dark black","light black","dark red","light red","dark green","light green","dark gray","light gray"};
		build.setTitle("列表dialog").setItems(strs, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getContext(), strs[which], Toast.LENGTH_SHORT).show();
			}
		}).setPositiveButton("Ok", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
			}
		}).setNegativeButton("Cancel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getContext(), "cancel", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
			}
		});
		return build.create();
	}

}
