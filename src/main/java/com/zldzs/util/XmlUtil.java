package com.zldzs.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

/**
 *  xml处理
 * @author Administrator
 * 
 */
public class XmlUtil {

	
	/**
	 * Xml 转 Map
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String, String>();
		
		SAXReader reader = new SAXReader();
		
		InputStream stream = request.getInputStream();
		Document doc =reader.read(stream);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		
		for (Element element : list) {
			map.put(element.getName(), element.getText());
		}
		
		stream.close();
		
		return map;
	}
	
	/**
	 * Object 转  Xml
	 * @param obj
	 * @return
	 */
	public static String objToXml(Object obj) {
		XStream xstream = new XStream(); 
		xstream.alias("xml", obj.getClass());
		String xml = xstream.toXML(obj);
		return xml;
	}
	
	
}
