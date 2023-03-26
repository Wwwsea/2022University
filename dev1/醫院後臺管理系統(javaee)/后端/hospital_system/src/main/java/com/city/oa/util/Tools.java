package com.city.oa.util;
//辅助工具类
public class Tools {
	//将字符串数组转换为int数组
	public static int[] getFromStringArray(String[] sarray) {
		int[] iarray=new int[sarray.length];
		int i=0;
		for(String s:sarray) {
			iarray[i]=Integer.parseInt(s);
			i++;
		}
		return iarray;
	}
	
	public static int[] getFormString(String s) {
		String[] ss=s.split(",");
		return getFromStringArray(ss);
	}

}
