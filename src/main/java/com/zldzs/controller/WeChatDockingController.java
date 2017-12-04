package com.zldzs.controller;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zldzs.util.Constant;
import com.zldzs.util.MapUtil;
import com.zldzs.util.Sha1SignUtil;

/**
 * ��΢��ӆ�̖����,Ԕ�鿴΢�Ź���ƽ�_API
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/wx")
public class WeChatDockingController {

	
	/**
	 * <΢�Ō��ӵ�һ��>
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/weChatDocking")
	public String weChatDocking(HttpServletRequest request) {
		String signature = request.getParameter("signature");//΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce������
		String timestamp = request.getParameter("timestamp");//ʱ��� 
		String nonce = request.getParameter("nonce");//�����
		String echostr = request.getParameter("echostr");//����ַ���
		
		//1.��token��timestamp��nonce�������������ֵ�������
		Map<String, Object> sortMap = new TreeMap<String, Object>();
		sortMap.put("token", Constant.WX_TOKEN);
		sortMap.put("timestamp", timestamp);
		sortMap.put("nonce", nonce);
		
		//2.�����������ַ���ƴ�ӳ�һ���ַ�������sha1����
		String joinStr = MapUtil.MapValueAllJoinStr(sortMap);
		String signStr = Sha1SignUtil.getSha1(joinStr);
		
		//3.�����߻�ü��ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��
		if(signStr.equals(signature)) {
			return echostr;
		}
		return null;
	}
	
}
