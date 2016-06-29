package com.example.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

public class BaseUtils {
	
	public static String getImsi(Context context) {
		try {
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			String subscriberId = tm.getSubscriberId();
			return subscriberId;
		} catch (Exception e) {
			return "";
		}
	}

}
