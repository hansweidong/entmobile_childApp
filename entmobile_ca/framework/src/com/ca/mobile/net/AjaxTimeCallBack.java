package com.ca.mobile.net;

/**
 * 异步请求回调类
 */
public interface AjaxTimeCallBack extends CallBack{

	/**
	 * 如果返回为true 则轮询 如果设为false则取消
	 */
	 abstract boolean getIsContinue();
}
