package com.ca.mobile.net;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;



public class FastHttpHander {
	/**
	 * 异步 post请求 无参数 默认下载配置器
	 *
	 * @param url
	 *            请求url
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajax(String url, Object object) {
		ajax(url, null, NetConfig.defaultConfig(), object);
	}

	/**
	 * 异步 post请求 无参数 自定义下载配置
	 *
	 * @param url
	 *            请求连接
	 * @param config
	 *            自定义下载配置
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajax(String url, NetConfig config, Object object) {
		ajax(url, null, config, object);
	}

	/**
	 * 异步 post请求 有参数 默认下载配置
	 *
	 * @param url
	 *            请求url
	 * @param params
	 *            请求参数
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajax(String url, LinkedHashMap<String, String> params, Object object) {
		ajax(url, params, NetConfig.defaultConfig(), object);
	}

	/**
	 * 异步 post异步获取 有参数 自定义下载配置
	 *
	 * @param url
	 *            请求连接
	 * @param params
	 *            请求参数
	 * @param config
	 *            请求配置
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajax(String url, LinkedHashMap<String, String> params, final NetConfig config, final Object object) {
		config.setRequest_type(NetConfig.request_post);
		AjaxCallBack callBack = new AjaxCallBack() {
			@Override
			public void callBack(ResponseEntity status) {
				http_inject(status, object, config);
			}

			@Override
			public boolean stop() {
				return isDestory(object);
			}
		};
		new Thread(new FastHttp.AjaxTask(url, params, config, callBack)).start();
	}

	/**
	 * 异步post定时轮询
	 *
	 * @param url
	 * @param object
	 * @return void
	 */
	public static void ajax(String url, AjaxTimeCallBack object) {
		NetConfig config = NetConfig.defaultConfig();
		config.setRequest_type(NetConfig.request_post);
		ajax(url, null, config, object);
	}

	/**
	 * 异步post定时轮询
	 *
	 * @param url
	 * @param params
	 * @param object
	 * @return void
	 */
	public static void ajax(String url, LinkedHashMap<String, String> params, AjaxTimeCallBack object) {
		NetConfig config = NetConfig.defaultConfig();
		config.setRequest_type(NetConfig.request_post);
		ajax(url, params, config, object);
	}

	/**
	 * 异步 post异步获取 定时请求（轮询）有参数 自定义下载配置 回调函数
	 *
	 * @param url
	 *            请求连接
	 * @param params
	 *            请求参数
	 * @param config
	 *            请求配置
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajax(String url, LinkedHashMap<String, String> params, NetConfig config, AjaxTimeCallBack object) {
		config.setRequest_type(NetConfig.request_post);
		new Thread(new FastHttp.TimeTask(url, params, config, object)).start();
	}

	/**
	 * 异步表单提交
	 *
	 * @param url
	 * @param object
	 * @return void
	 */
	public static void ajaxForm(String url, Object object) {
		ajaxForm(url, null, null, NetConfig.defaultConfig(), object);
	}

	/**
	 * 异步表单提交 自定义配置
	 *
	 * @param url
	 * @param config
	 * @param object
	 * @return void
	 */
	public static void ajaxForm(String url, NetConfig config, Object object) {
		ajaxForm(url, null, null, config, object);
	}

	/**
	 * 异步表单提交 有参数
	 *
	 * @param url
	 * @param params
	 * @param object
	 * @return void
	 */
	public static void ajaxForm(String url, LinkedHashMap<String, String> params, Object object) {
		ajaxForm(url, params, null, NetConfig.defaultConfig(), object);
	}

	/**
	 * 自定义表单提交有参数 有文件
	 *
	 * @param url
	 * @param params
	 * @param files
	 * @param object
	 * @return void
	 */
	public static void ajaxForm(String url, LinkedHashMap<String, String> params, HashMap<String, File> files, Object object) {
		ajaxForm(url, params, files, NetConfig.defaultConfig(), object);
	}

	public static void ajaxForm(String url, LinkedHashMap<String, String> params, HashMap<String, File> files, Object object, FastHttp.Progress progress) {
		ajaxForm(url, params, files, NetConfig.defaultConfig(), object);
	}

	/**
	 * 自定义表单提交有参数 有文件 自定义下载配置
	 *
	 * @param url
	 * @param params
	 * @param files
	 * @param config
	 * @param object
	 * @return void
	 */
	public static void ajaxForm(String url, LinkedHashMap<String, String> params, HashMap<String, File> files, final NetConfig config, final Object object) {
		config.setRequest_type(NetConfig.request_form);
		config.setFiles(files);
		AjaxCallBack callBack = new AjaxCallBack() {
			@Override
			public void callBack(ResponseEntity status) {
				http_inject(status, object, config);
			}

			@Override
			public boolean stop() {
				return isDestory(object);
			}
		};
		new Thread(new FastHttp.AjaxTask(url, params, config, callBack)).start();
	}

	/**
	 * 异步get获取
	 *
	 * @param url
	 *            请求路径
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxGet(String url, Object object) {
		ajaxGet(url, null, NetConfig.defaultConfig(), object);
	}

	/**
	 * 异步get获取
	 *
	 * @param url
	 *            请求路径
	 * @param config
	 *            配置文件
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxGet(String url, NetConfig config, Object object) {
		ajaxGet(url, null, config, object);
	}

	/**
	 * 异步get获取
	 *
	 * @param url
	 *            请求路径
	 * @param params
	 *            参数
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxGet(String url, LinkedHashMap<String, String> params, Object object) {
		ajaxGet(url, params, NetConfig.defaultConfig(), object);
	}

	/**
	 * get异步获取
	 *
	 * @param url
	 *            请求路径
	 * @param params
	 *            参数
	 * @param config
	 *            下载配置
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxGet(String url, LinkedHashMap<String, String> params, final NetConfig config, final Object object) {
		if (config == null) {
			System.out.println(object.getClass().getSimpleName() + "  的网络请求配置不能为空\n");
			return;
		}
		config.setRequest_type(NetConfig.request_get);

		AjaxCallBack callBack = new AjaxCallBack() {
			@Override
			public void callBack(ResponseEntity status) {
				http_inject(status, object, config);
			}

			@Override
			public boolean stop() {
				return isDestory(object);
			}
		};
		new Thread(new FastHttp.AjaxTask(url, params, config, callBack)).start();
	}

	/**
	 * get异步获取 定时请求（轮询）
	 *
	 * @param url
	 *            请求路径
	 * @param params
	 *            参数
	 * @param config
	 *            下载配置
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxGet(String url, LinkedHashMap<String, String> params, NetConfig config, AjaxTimeCallBack object) {
		if (config == null) {
			config = NetConfig.defaultConfig();
		}
		config.setRequest_type(NetConfig.request_get);
		new Thread(new FastHttp.TimeTask(url, params, config, object)).start();
	}

	/**
	 * 异步 post请求 无参数 默认下载配置器
	 *
	 * @param url
	 *            请求url
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxWebServer(String url, String method, Object object) {
		NetConfig config = new NetConfig();
		config.setMethod(method);
		config.setRequest_type(NetConfig.request_webserver);
		ajaxWebServer(url, method, null, config, object);
	}

	/**
	 * 异步 post请求 无参数 自定义下载配置
	 *
	 * @param url
	 *            请求连接
	 * @param config
	 *            自定义下载配置
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxWebServer(String url, String method, NetConfig config, Object object) {
		ajaxWebServer(url, method, null, config, object);
	}

	/**
	 * 异步 post请求 有参数 默认下载配置
	 *
	 * @param url
	 *            请求url
	 * @param params
	 *            请求参数
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxWebServer(String url, String method, LinkedHashMap<String, String> params, Object object) {
		NetConfig config = NetConfig.defaultConfig();
		config.setMethod(method);
		config.setRequest_type(NetConfig.request_webserver);
		ajaxWebServer(url, method, params, config, object);
	}

	/**
	 * 异步 post异步获取 有参数 自定义下载配置
	 *
	 * @param url
	 *            请求连接
	 * @param params
	 *            请求参数
	 * @param config
	 *            请求配置
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxWebServer(String url, String method, LinkedHashMap<String, String> params, final NetConfig config, final Object object) {
		if (config == null) {
			System.out.println(object.getClass().getSimpleName() + " 的网络请求配置不能为空\n");
			return;
		}
		config.setMethod(method);
		config.setRequest_type(NetConfig.request_webserver);
		AjaxCallBack callBack = new AjaxCallBack() {
			@Override
			public void callBack(ResponseEntity status) {
				http_inject(status, object, config);
			}

			@Override
			public boolean stop() {
				return isDestory(object);
			}
		};
		new Thread(new FastHttp.AjaxTask(url, params, config, callBack)).start();
	}

	/**
	 * 异步 post异步获取 定时请求（轮询）有参数 默认下载配置 回调函数
	 *
	 * @param url
	 *            请求连接
	 * @param params
	 *            请求参数
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxWebServer(String url, String method, LinkedHashMap<String, String> params, AjaxTimeCallBack object) {
		NetConfig config = NetConfig.defaultConfig();
		config.setMethod(method);
		config.setRequest_type(NetConfig.request_webserver);
		new Thread(new FastHttp.TimeTask(url, params, config, object)).start();
	}

	/**
	 * 异步 post异步获取 定时请求（轮询）有参数 自定义下载配置 回调函数
	 *
	 * @param url
	 *            请求连接
	 * @param params
	 *            请求参数
	 * @param config
	 *            请求配置
	 * @param object
	 *            回调函数
	 * @return void
	 */
	public static void ajaxWebServer(String url, String method, LinkedHashMap<String, String> params, NetConfig config, AjaxTimeCallBack object) {
		if (config == null) {
			config = NetConfig.defaultConfig();
		}
		config.setMethod(method);
		config.setRequest_type(NetConfig.request_webserver);
		new Thread(new FastHttp.TimeTask(url, params, config, object)).start();
	}

	private static void http_inject(ResponseEntity entity, Object object, NetConfig config) {
		if (object instanceof IHttpResponse){
			((IHttpResponse)object).onResponse(entity);
		}
	}

	private static boolean isDestory(Object object) {
		object = null;
		return false;
	}
}
