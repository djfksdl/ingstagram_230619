package com.ingstagram.common;

import java.security.MessageDigest;

public class EncryptUtils {
	//input : 원본 비밀번호
	//output : 해싱 비밀번호
	public static String md5(String message) {
		String encData = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] bytes = message.getBytes();
			md.update(bytes);
			
		}
		return encData;
	}
}
