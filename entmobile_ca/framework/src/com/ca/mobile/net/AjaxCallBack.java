package com.ca.mobile.net;

/**
 * 异步请求回调类
 *
 */
public interface AjaxCallBack extends CallBack {
	/**
	 * 可以用来取消回调
	 */
	abstract boolean stop();
}
