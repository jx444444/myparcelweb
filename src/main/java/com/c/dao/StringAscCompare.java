package com.c.dao;
import java.util.Comparator;

public class StringAscCompare implements Comparator<String> {
	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg0.compareTo(arg1);
	}
}
