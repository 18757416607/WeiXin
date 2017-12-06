package com.zldzs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zldzs.pojo.WxMsg;
import com.zldzs.util.ArrayUtil;
import com.zldzs.util.Constant;
import com.zldzs.util.Sha1SignUtil;
import com.zldzs.util.XmlUtil;
import com.zldzs.util.wx.WxMessageUtil;

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
	@RequestMapping(value = "/weChatDocking",method = RequestMethod.GET)
	public void weChatDockingGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("进入消息微信對接第一步");
		
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
			out.close();
		}else {
			System.out.println("failed");
		}
	}
	
	/**
	 * <微信消息回復>
	 * url和微信對接相同   但請求方式不同
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws DocumentException 
	 */
	@RequestMapping(value = "/weChatDocking",method = RequestMethod.POST)
	public void weChatDockingPost(HttpServletRequest request,HttpServletResponse response) throws IOException, DocumentException {
		System.out.println("进入消息回复");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		/**
		 * request中是Xml格式字符串     
		 * 某个微信账号发送消息给公众号
		 */
		Map<String,String> map = XmlUtil.xmlToMap(request);
		
		String toUserName = map.get("ToUserName");  //开发者微信号
		String fromUserName = map.get("FromUserName"); //发送方帐号（一个OpenID）
		String msgType = map.get("MsgType");  //text
		String content = map.get("Content");  //文本消息内容
		
		System.out.println("开发者微信号:"+toUserName);
		System.out.println("发送方帐号（一个OpenID）:"+fromUserName);
		System.out.println("类型:"+msgType);
		System.out.println("文本消息内容:"+content);
		
		
		String rtnMsg = null;
		if(Constant.WX_MESSAGE_TEXT.equals(msgType)) {  //确认是文本消息
			
			System.out.println("输入文本消息");
			
			//当用户输入文本消息    这里进行精确匹配
			if("1".equals(content)) {
				rtnMsg = WxMessageUtil.subscribeSendInfo(toUserName, fromUserName, WxMessageUtil.writeOne());
			}else if("2".equals(content)) {
				rtnMsg = WxMessageUtil.subscribeSendInfo(toUserName, fromUserName, WxMessageUtil.writeTwo());
			}else if("3".equals(content)) {
				rtnMsg = WxMessageUtil.subscribeSendInfo(toUserName, fromUserName, WxMessageUtil.writeThree());
			}else if("?".equals(content)||"？".equals(content)){
				//用户回复?或者？时再次调用菜单
				rtnMsg = WxMessageUtil.subscribeSendInfo(toUserName, fromUserName, WxMessageUtil.menuMsg());
			}else {
				//输入的内容不在菜单内就返回用户输入的信息
				//公众号返回消息给某给微信号,这里的fromUsername和toUsername是和上面的接收消息角色相反
				WxMsg msg = new WxMsg();
				msg.setFromUserName(toUserName);
				msg.setToUserName(fromUserName);
				msg.setCreateTime(new Date().getTime());
				msg.setMsgType("text");
				msg.setContent("您发送的消息是:"+content);
				
				rtnMsg = XmlUtil.objToXml(msg);
			}
		}else if(Constant.WX_MESSAGE_EVENT.equals(msgType)) {
			String eventType = map.get("Event");  //获取微信给的参数中的Event就能知道是哪一种推送事件
			
			if(Constant.WX_MESSAGE_SUBSCRIBE.equals(eventType)) {  //关注
				System.out.println(fromUserName+"用户关注!!!!");
				rtnMsg = WxMessageUtil.subscribeSendInfo(toUserName, fromUserName, WxMessageUtil.menuMsg());
				System.out.println("关注："+rtnMsg);
			}if(Constant.WX_MESSAGE_SUBSCRIBE.equals(eventType)) {  //取消关注
				System.out.println(fromUserName+"用户用户取消关注!!!!");
			}
		}
		
		System.out.println("rtnMsg:"+rtnMsg);
		PrintWriter out =  response.getWriter();
		out.println(rtnMsg);
		out.close();
	}
	
}
