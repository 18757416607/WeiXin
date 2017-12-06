package com.zldzs.util;

/**
 * 常量类
 * @author Administrator
 *
 */
public class Constant {

	//微信接入常量
	public final static String WX_TOKEN = "nhxqtzzldzsdyh";//微信對接tonken
	public final static String WX_APPSECRET = "1094b8e62bcc4ee65f9aaafda58a2669";  //微信開發者密碼
	public final static String WX_ENCODINGAESKEY  = "UOcAmTNBSk8P2XOrYU7GkDn8KgjyBZm1hh4OsE8Ed0b"; //消息加解密密钥
	
	//微信消息类型常量
	public final static String WX_MESSAGE_TEXT = "text";  //文本消息
	public final static String WX_MESSAGE_IMAGE = "image";  //图片消息
	public final static String WX_MESSAGE_VOICE = "voice";   //语音消息
	public final static String WX_MESSAGE_VIDEO = "video";   //视频消息
	public final static String WX_MESSAGE_LINK = "link";   //链接消息
	public final static String WX_MESSAGE_LOCATION = "location";  //地址位置消息
	public final static String WX_MESSAGE_EVENT  = "event";  //事件推送  
	public final static String WX_MESSAGE_SUBSCRIBE = "subscribe"; //事件推送  -> 关注
	public final static String WX_MESSAGE_UNSUBSCRIBE = "unsubscribe"; //事件推送   -> 取消关注
	public final static String WX_MESSAGE_CLICK = "CLICK";  //事件推送  ->菜单点击 
	public final static String WX_MESSAGE_VIEW = "VIEW";   //事件推送  ->菜单点击 
	
}