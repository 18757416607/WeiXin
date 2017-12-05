package com.zldzs.util;

/**
 * 數組工具
 * @author Administrator
 *
 */
public class ArrayUtil {

	/**
	 * 數組 拆分 組裝 成字符串
	 * @param arr
	 * @return
	 */
	public static String arrayToStr(String[] arr) {
		StringBuffer str = new StringBuffer();
		for(int i = 0;i<arr.length;i++) {
			str.append(arr[i]);
		}
		return str.toString();
	}
	
}
