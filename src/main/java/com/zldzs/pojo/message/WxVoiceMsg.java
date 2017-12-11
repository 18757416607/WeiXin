package com.zldzs.pojo.message;

import com.zldzs.pojo.BaseMsg;

/**
 *  微信  语音   消息  实体
 * @author Administrator
 *
 */
public class WxVoiceMsg extends BaseMsg{

	private WxVoice Voice; //微信需要返回固定的格式

	public WxVoice getVoice() {
		return Voice;
	}

	public void setVoice(WxVoice voice) {
		Voice = voice;
	}
	
	
	
	
}
