package com.c.myParcel;

import java.io.UnsupportedEncodingException;

public class Base64Encoding implements Base64Coding{
	public String Base64StringEncode(String str) throws UnsupportedEncodingException {
		byte[] targetBytes = str.getBytes("UTF-8");
		String encodedString = encoder.encodeToString(targetBytes);
        return encodedString;
	}
}
