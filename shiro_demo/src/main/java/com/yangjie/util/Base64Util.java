package com.yangjie.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
//import java.util.Base64;

import org.apache.shiro.codec.Base64;

import sun.misc.BASE64Decoder;

public class Base64Util {

	public static void main(String[] args) throws IOException {
		// 方法一
		// System.out.println(getBASE64("Mark"));
		// System.out.println(getFromBASE64("Mark"));

		// 方法二
		// String str = "Mark";
		// String encode = new BASE64Encoder().encode(str.getBytes());
		// System.out.println("编码过后：" + encode);
		// byte[] bytes = new BASE64Decoder().decodeBuffer(encode);
		// String decode = new String(bytes, "UTF-8");
		// System.out.println("解码过后：" + decode);

		// 方法三
		// final Base64.Decoder decoder = Base64.getDecoder();
		// final Base64.Encoder encoder = Base64.getEncoder();
		// byte[] textByte = "Mark".getBytes(StandardCharsets.UTF_8);
		// String encodedText = encoder.encodeToString(textByte);// 编码
		// System.out.println(encodedText);// YWRtaW46MTIz
		// System.out.println(new String(decoder.decode(encodedText),
		// "UTF-8"));// 解码

		// 方法四
		byte[] textByte = "Mark".getBytes("UTF-8");
		String encodedText = Base64.encodeToString(textByte);
		System.out.println(encodedText);// YWRtaW46MTIz
		System.out.println(new String(Base64.decode(encodedText), "UTF-8"));// 解码
	}

	// 将 s 进行 BASE64 编码
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	// 将 BASE64 编码的字符串 s 进行解码
	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b, "UTF-8");
		} catch (Exception e) {
			return null;
		}
	}
}
