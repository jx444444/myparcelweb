package com.c.myParcel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String DateStringFormat(Date day) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return transFormat.format(day);
	}
}
