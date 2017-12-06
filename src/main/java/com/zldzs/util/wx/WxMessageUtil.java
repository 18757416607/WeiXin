package com.zldzs.util.wx;

import java.util.Date;

import com.zldzs.pojo.WxMsg;
import com.zldzs.util.Constant;
import com.zldzs.util.XmlUtil;

/**
 * 微信的消息回复类
 * @author Administrator
 *
 */
public class WxMessageUtil {

	/**
	 * 关注公众号时发送的消息
	 * @param toUserName 发送给谁
	 * @param fromUserName  谁发送的
	 * @param sendContent   发送的内容
	 * @return
	 */
	public static String subscribeSendInfo(String toUserName,String fromUserName,String sendContent) {
		WxMsg msg = new WxMsg();
		msg.setFromUserName(toUserName);
		msg.setToUserName(fromUserName);
		msg.setCreateTime(new Date().getTime());
		msg.setMsgType(Constant.WX_MESSAGE_TEXT);
		msg.setContent(sendContent);
		return XmlUtil.objToXml(msg);
	}
	
	
	/**
	 * 用户关注公众号时回复的菜单信息
	 */
	public static String menuMsg() {
		StringBuffer sb = new StringBuffer();
		sb.append("感谢您的关注,我们将为您提供您所需的服务,请按菜单提示操作:\n\n");
		sb.append("1.加入我们\n");
		sb.append("2.服务类型\n");
		sb.append("3.乱搞\n");
		sb.append("回复 ? 查看菜单");
		return sb.toString();
	}
	
	
	/**
	 * 用户根据菜单   输入	1  的时候回复的消息
	 */
	public static String writeOne() {
		StringBuffer sb = new StringBuffer();
		sb.append("感谢您的关注,我们是最专业的团队!\n\n");
		sb.append("1联系方式:18757416607\n");
		sb.append("2.Email:993323226@qq.com\n");
		return sb.toString();
	}
	
	/**
	 * 用户根据菜单   输入	2  的时候回复的消息
	 */
	public static String writeTwo() {
		StringBuffer sb = new StringBuffer();
		sb.append("感谢您的关注,我们是最专业的团队!\n\n");
		sb.append("1.买\n");
		sb.append("1.卖");
		return sb.toString();
	}
	
	/**
	 * 用户根据菜单   输入	3  的时候回复的消息
	 */
	public static String writeThree() {
		StringBuffer sb = new StringBuffer();
		sb.append("感谢您的关注,我们是最专业的团队!\n\n");
		sb.append("草\n");
		sb.append("了\n");
		sb.append("个\n");
		sb.append("D\n");
		sb.append("J");
		return sb.toString();
	}
	
}
