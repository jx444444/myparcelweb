package com.c.dao;
import java.util.Comparator;

public class StringDescCompare implements Comparator<String> {
	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg1.compareTo(arg0);
	}
}
