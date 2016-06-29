package com.ca.mobile.net;

import android.app.Application;

import com.ca.mobile.utils.FileManager;
import com.ca.mobile.utils.MD5;

import java.io.File;
import java.util.LinkedHashMap;


public class HttpCache {

	public static String getUrlCache(Application application,String url,LinkedHashMap<String, String> params) {
		if (url == null) {
			return null;
		}
		for (String key : params.keySet()) {
			url = url+key+params.get(key);
        }
		int time = NetConfig.defaultConfig().getSaveDate();
		
		String result = null;
		File file = new File(application.getCacheDir(), getCacheDecodeString(url));
		if (file.exists() && file.isFile()) {
			long expiredTime = System.currentTimeMillis() - file.lastModified();
			System.out.println("缓存了:" + expiredTime / 60000 + "分钟");
			if (time!=-1&&expiredTime>time) {
				file.delete();
				return null;
            }
			result = FileManager.getAsString(file);
		}
		return result;
	}

	public static void setUrlCache(Application application,String data, String url) {
		File file = new File(application.getCacheDir(), getCacheDecodeString(url));
		// 创建缓存数据到磁盘，就是创建文件
		FileManager.write(file, data);
	}

	private static String getCacheDecodeString(String url) {
		// 1. 处理特殊字符
		return MD5.Md5(url.replaceAll("[.:/,%?&=]", "+").replaceAll("[+]+", "+"));
	}
}
