package com.zldzs.pojo.message;

import com.zldzs.pojo.BaseMsg;

/**
 * 微信  图片 消息    实体
 * @author Administrator
 *
 */
public class WxImageMsg extends BaseMsg{

	private WxImage Image;  //微信需要返回固定的格式

	public WxImage getImage() {
		return Image;
	}

	public void setImage(WxImage image) {
		Image = image;
	}

	

	
	
	
}
