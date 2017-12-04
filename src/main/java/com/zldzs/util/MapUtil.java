package com.zldzs.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class MapUtil {

	/**
	 * Map�����е�value��ƴ�ӳ��ַ���
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
	 * Map�е�����valueֵ���M��utf-8���a
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
