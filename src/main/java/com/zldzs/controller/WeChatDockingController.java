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
 * 于微信訂閲號對接,詳情看微信公眾平臺API
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/wx")
public class WeChatDockingController {

	
	/**
	 * <微信對接第一步>
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/weChatDocking")
	public String weChatDocking(HttpServletRequest request) {
		String signature = request.getParameter("signature");//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = request.getParameter("timestamp");//时间戳 
		String nonce = request.getParameter("nonce");//随机数
		String echostr = request.getParameter("echostr");//随机字符串
		
		//1.将token、timestamp、nonce三个参数进行字典序排序
		Map<String, Object> sortMap = new TreeMap<String, Object>();
		sortMap.put("token", Constant.WX_TOKEN);
		sortMap.put("timestamp", timestamp);
		sortMap.put("nonce", nonce);
		
		//2.将三个参数字符串拼接成一个字符串进行sha1加密
		String joinStr = MapUtil.MapValueAllJoinStr(sortMap);
		String signStr = Sha1SignUtil.getSha1(joinStr);
		
		//3.开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if(signStr.equals(signature)) {
			return echostr;
		}
		return null;
	}
	
}
