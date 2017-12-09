package com.zldzs.util;

/**
 * 常量类
 * @author Administrator
 *
 */
public class Constant {

	/**
	 * 测试号常量
	 */
	public final static String TEST_WX_APPID = "wxf783a21473d1041b";
	public final static String TEST_WX_APPSECRET = "caf6368128e249ce28bd3066cd3cd824";
	//获取微信的Token接口
	public final static String TEST_WX_GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//新增临时素材接口
	public final static String TEST_WX_UPLOAD_RESOURCE = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	//自定义创建菜单接口
	public final static String TEST_WX_INIT_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	
	//微信接入常量
	public final static String WX_TOKEN = "nhxqtzzldzsdyh";//微信對接tonken
	public final static String WX_APPSECRET = "1094b8e62bcc4ee65f9aaafda58a2669";  //微信開發者密碼
	public final static String WX_ENCODINGAESKEY  = "UOcAmTNBSk8P2XOrYU7GkDn8KgjyBZm1hh4OsE8Ed0b"; //消息加解密密钥
	
	//微信消息类型常量
	public final static String WX_MESSAGE_TEXT = "text";  //文本消息
	public final static String WX_MESSAGE_IMAGE = "image";  //图片消息
	public final static String WX_MESSAGE_VOICE = "voice";   //语音消息
	public final static String WX_MESSAGE_VIDEO = "video";   //视频消息
	public final static String WX_MESSAGE_MUSIC = "music";   //音乐消息
	public final static String WX_MESSAGE_LINK = "link";   //链接消息
	public final static String WX_MESSAGE_EVENT  = "event";  //事件推送  
	public final static String WX_MESSAGE_SUBSCRIBE = "subscribe"; //事件推送  -> 关注
	public final static String WX_MESSAGE_UNSUBSCRIBE = "unsubscribe"; //事件推送   -> 取消关注
	public final static String WX_MESSAGE_NEWS = "news";  //图文消息
	
	//微信按钮类型常量
	public final static String WX_BUTTON_CLICK = "CLICK";  //事件推送  ->菜单点击
	//扫码推事件用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息。
	public final static String WX_BUTTON_SCANCODE_PUSH = "scancode_push"; 
	//弹出地理位置选择器用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息
	public final static String WX_BUTTON_LOCATION_SELECT = "location_select";
	public final static String WX_BUTTON_SCANCODE = "scancode";   //事件推送  ->扫码
	public final static String WX_MESSAGE_LOCATION = "location";  //地址位置消息
	public final static String WX_MESSAGE_LOCATION1 = "location_select"; //地址位置消息
	
	public final static String WX_BUTTON_VIEW = "VIEW";   //事件推送  ->菜单点击 
	
	
}