package com.zldzs.pojo.message;

/**
 * 微信  语音   实体 
 * @author Administrator
 *
 */
public class WxVoice{

	private String MediaId;  //通过素材管理中的接口上传多媒体文件，得到的id

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
	
	
}
