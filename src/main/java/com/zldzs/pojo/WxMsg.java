package com.zldzs.pojo;

/**
 * 微信放回消息实体
 * @author Administrator
 *
 */
public class WxMsg extends BaseMsg{

	private String Content;  //文本消息内容
	private String MsgId;  //消息id，64位整型
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
	
	
	
}
