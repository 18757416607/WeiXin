package com.zldzs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zldzs.util.ArrayUtil;
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
	 * @throws IOException 
	 */
	@RequestMapping(value = "/weChatDocking",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void weChatDocking(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String signature = request.getParameter("signature");//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = request.getParameter("timestamp");//时间戳 
		String nonce = request.getParameter("nonce");//随机数
		String echostr = request.getParameter("echostr");//随机字符串
		
		System.out.println("微信加密签名:"+signature);
		System.out.println("时间戳:"+timestamp);
		System.out.println("随机数:"+nonce);
		System.out.println("随机字符串:"+echostr);
		
		//1.将token、timestamp、nonce三个参数进行字典序排序
		String[] arr = new String[] {Constant.WX_TOKEN,timestamp,nonce};
		Arrays.sort(arr);
		System.out.println("排序的:"+arr);
		String str = ArrayUtil.arrayToStr(arr);
		
		System.out.println("拼接的:"+str);
		
		//2.将三个参数字符串拼接成一个字符串进行sha1加密
		String signStr = Sha1SignUtil.getSha1(str);
		
		System.out.println("加密的:"+signStr);
		System.out.println("微信加密的:"+signature);
		
		//3.开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if(signStr.equals(signature)) {
			System.out.println("success");
			PrintWriter out = response.getWriter();
			out.print(echostr);
		}else {
			System.out.println("failed");
		}
	}
	
}
