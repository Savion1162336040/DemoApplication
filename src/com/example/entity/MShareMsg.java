/*******************************************************************************
 *    系统名称   ： 掌上营业厅
 *    文件名    ： com.cqmc.client
 *              (C) Copyright 中国移动通信集团重庆有限公司 2014 
 *               All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于中国移动通信集团重庆有限公司内部使用，禁止转发
 ******************************************************************************/
package com.example.entity;

import android.graphics.drawable.Drawable;

public class MShareMsg {
	public String title;
	public String contents;
	public String packageName;
	public String activityName;
	public Drawable icon;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Drawable getIcon() {
		return icon;
	}

	public void setIcon(Drawable icon) {
		this.icon = icon;
	}

}