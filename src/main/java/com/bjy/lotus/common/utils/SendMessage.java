package com.bjy.lotus.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 
 * 文件作用：http接口使用实例
 * 
 * 创建时间：2013-06-03
 * 
 */

public class SendMessage {

	@SuppressWarnings("deprecation")
	public static void sendMessage(String mobile, String content) throws IOException {
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://inter.ueswt.com/smsGBK.aspx?");
		// 向StringBuffer追加发送类型
		sb.append("action=send");
		// 向StringBuffer追加企业ID
		sb.append("&userid=11608");
		// 向StringBuffer追加用户名
		sb.append("&account=kgyunhuisi");
		// 向StringBuffer追加密码
		sb.append("&password=123456qwe");
		// 向StringBuffer追加手机号码
		sb.append("&mobile="+mobile);
		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content=" + URLEncoder.encode(content));
		// System.out.println(sb.toString());
		// 创建url对象
		URL url = new URL(sb.toString());
		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");
		// 发送
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String thisLine = "";
		// 返回结果为XML格式文档
		while ((thisLine = in.readLine()) != null) {
			System.out.println(thisLine);
		}
	}

	public static void main(String[] args) {
		try {
			sendMessage("18818561493", "发送短信测试--hzz");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
