package com.zldzs.pojo.message;

import com.zldzs.pojo.BaseMsg;

/**
 * 微信  音乐  消息  实体
 * @author Administrator
 *
 */
public class WxMusicMsg extends BaseMsg{

	private WxMusic Music; //微信需要返回固定的格式

	public WxMusic getMusic() {
		return Music;
	}

	public void setMusic(WxMusic music) {
		Music = music;
	}
	
	
	
}
