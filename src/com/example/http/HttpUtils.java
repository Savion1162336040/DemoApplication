package com.example.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.spec.EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.entity.RequestEntity;
import com.example.utils.DeviceUuidFactory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils {
	static HttpUtils instance;
	OkHttpClient client;
	public static final int HTTP_FAILED = -1;
	public static final int HTTP_SUCCEED = 200;

	private HttpUtils() {
		client = new OkHttpClient();
	}

	public static HttpUtils getInstance() {
		if (instance == null) {
			instance = new HttpUtils();
		}
		return instance;
	}
	/**
	 * 获取新闻内容
	 * @param context
	 * @param handler
	 */
	public void getNewsDetail(Context context,String id,String phoneNum,Handler handler) {
		String json = "{\"id\":\""+id+"\",\"cid\":\"0S1fSSnB\",\"did\":\""
				+ new DeviceUuidFactory(context).getDeviceUuid()
				+ "\" ,\"phonenumber\":\""+phoneNum+"\"}";
		getNewsPublic("getContentService", json, handler);
	}
	/**
	 * 获取新闻列表
	 * @param context
	 * @param handler
	 */
	public void getNewList(Context context,String phoneNum,Handler handler){
		String json = "{\"count\":20,\"page\":1,\"cid\":\"0S1fSSnB\",\"coid\":4061,\"did\":\""
				+ new DeviceUuidFactory(context).getDeviceUuid()
				+ "\" ,\"phonenumber\":\""+phoneNum+"\",\"cityId\":\"101040100\"}";
		getNewsPublic("findInfoNByCoid", json, handler);
	}
	/**
	 * 获取新闻图集列表
	 * @param context
	 * @param handler
	 */
	public void getNewImgList(Context context,String phoneNum,Handler handler){
		String json = "{\"count\":3,\"page\":1,\"cid\":\"0S1fSSnB\",\"coid\":4061, \"did\":\""
				+ new DeviceUuidFactory(context).getDeviceUuid()
				+ "\" ,\"phonenumber\":\""+phoneNum+"\"}";
		getNewsPublic("getImgListCoverByCoid", json, handler);
	}
	/**
	 * 获取新闻图集内容
	 * @param context
	 * @param handler
	 */
	public void getNewImgDetail(Context context,String id,String phoneNum,Handler handler){
		String json = "{\"id\":"+id+",\"page\":1,\"cid\":\"0S1fSSnB\",\"did\":\""
				+ new DeviceUuidFactory(context).getDeviceUuid()
				+ "\" ,\"phonenumber\":\""+phoneNum+"\"}";
		getNewsPublic("getImgNewsListByCoverId", json, handler);
	}
	

	private void getNewsPublic(String method, String jsonRequest, final Handler handler) {
		try {
			String url = "http://wap.cq.10086.cn/surfdesk/newshandler.jsp";
			jsonRequest = URLEncoder.encode(jsonRequest, "UTF-8");
			url += "?method="+method+"&jsonRequest="+jsonRequest;
//			RequestBody body = new FormBody.Builder().add("method", method).add("jsonRequest", jsonRequest).build();
			Request request = new Request.Builder().url(url).build();
			client.newCall(request).enqueue(new Callback() {
				@Override
				public void onResponse(Call arg0, Response arg1) throws IOException {
					Message msg = handler.obtainMessage();
					msg.what = HTTP_SUCCEED;
					msg.obj = arg1.body().string();
					InputStream stream = arg1.body().byteStream();
					// String string = arg1.body().string();
					handler.sendMessage(msg);
				}

				@Override
				public void onFailure(Call arg0, IOException arg1) {
					handler.sendEmptyMessage(HTTP_FAILED);
				}
			});
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			handler.sendEmptyMessage(HTTP_FAILED);
		}
	}

}
