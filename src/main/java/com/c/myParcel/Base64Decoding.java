package com.c.myParcel;

import java.io.UnsupportedEncodingException;

public class Base64Decoding implements Base64Coding{
	public String Base64StringEncode(String str64) throws UnsupportedEncodingException {
		byte[] decodedBytes = decoder.decode(str64);
		String decodedString = new String(decodedBytes, "UTF-8");
        return decodedString;
	}
}
