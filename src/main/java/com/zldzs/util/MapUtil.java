package com.zldzs.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class MapUtil {

	/**
	 * Map中所有的value都拼接成字符串
	 * @param map
	 * @return
	 */
	public static String MapValueAllJoinStr(Map<String,Object> map) {
		StringBuffer returnStr = new StringBuffer();
		Iterator<Map.Entry<String, Object>> it= map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Object> entry=it.next();
            returnStr.append(entry.getValue());
        }
		return returnStr.toString();
	}
	
	/**
	 * Map中的所有value值都進行utf-8編碼
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String,Object> encodeUtf8ToAllValue(Map<String,Object> map) throws UnsupportedEncodingException {
		Iterator<Map.Entry<String, Object>> it= map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Object> entry=it.next();
            map.put(entry.getKey(), URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
        }
        return map;
	}
	
	
}