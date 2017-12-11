package com.zldzs.util.wx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zldzs.pojo.message.WxImage;
import com.zldzs.pojo.message.WxImageMsg;
import com.zldzs.pojo.message.WxImageTextMsg;
import com.zldzs.pojo.message.WxImageTextMsgItem;
import com.zldzs.pojo.message.WxMsg;
import com.zldzs.pojo.message.WxMusic;
import com.zldzs.pojo.message.WxMusicMsg;
import com.zldzs.pojo.message.WxVideo;
import com.zldzs.pojo.message.WxVideoMsg;
import com.zldzs.pojo.message.WxVoice;
import com.zldzs.pojo.message.WxVoiceMsg;
import com.zldzs.util.Constant;
import com.zldzs.util.XmlUtil;

/**
 * 微信的消息回复类
 * @author Administrator
 *
 */
public class WxMessageUtil {
	
	/**
	 * 用户关注公众号时回复的菜单信息
	 */
	public static String menuMsg() {
		StringBuffer sb = new StringBuffer();
		sb.append("感谢您的关注,我们将为您提供您所需的服务,请按菜单提示操作:\n");
		sb.append("1.加入我们\n");
		sb.append("2.显示图片\n");
		sb.append("3.显示图文\n");
		sb.append("4.显示语音\n");
		sb.append("5.显示视频\n");
		sb.append("6.显示Music\n");
		sb.append("回复 ? 查看菜单");
		return sb.toString();
	}
	
	
	/**
	 * 关注公众号时发送的文本消息
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
	 * 文本消息
	 */
	public static String writeOne() {
		StringBuffer sb = new StringBuffer();
		sb.append("感谢您的关注,我们是最专业的团队!\n\n");
		sb.append("联系方式:18757416607\n");
		sb.append("Email:993323226@qq.com\n");
		sb.append("<a>www.baidu.com</a>\n");
		return sb.toString();
	}
	
	
	/**
	 * 图文消息
	 * @param toUserName 发送给谁
	 * @param fromUserName  谁发送的
	 * @param sendContent   发送的内容
	 * @return
	 */
	public static String ImageTextSendInfo(String toUserName,String fromUserName) {
		WxImageTextMsg imageTextMsg = new WxImageTextMsg();
		imageTextMsg.setFromUserName(toUserName);
		imageTextMsg.setToUserName(fromUserName);
		imageTextMsg.setCreateTime(new Date().getTime());
		imageTextMsg.setMsgType(Constant.WX_MESSAGE_NEWS);
		
		List<WxImageTextMsgItem> listImageTextMsgImtem = new ArrayList<WxImageTextMsgItem>();
		WxImageTextMsgItem imageTextMsgItem = new WxImageTextMsgItem();
		imageTextMsgItem.setTitle("我是标题");
		imageTextMsgItem.setDescription("我是描述");
		imageTextMsgItem.setPicUrl("http://60.205.226.170:80/WeiXin/resource/image/temp_user_img.png");
		imageTextMsgItem.setUrl("http://www.baidu.com");
		listImageTextMsgImtem.add(imageTextMsgItem);
		
		
		WxImageTextMsgItem imageTextMsgItem1 = new WxImageTextMsgItem();
		imageTextMsgItem1.setTitle("我是大樟树");
		imageTextMsgItem1.setDescription("大樟树");
		imageTextMsgItem1.setPicUrl("http://60.205.226.170:80/WeiXin/resource/image/dzs.jpg");
		imageTextMsgItem1.setUrl("http://www.baidu.com");
		listImageTextMsgImtem.add(imageTextMsgItem1);
		
		imageTextMsg.setArticles(listImageTextMsgImtem);
		imageTextMsg.setArticleCount(listImageTextMsgImtem.size());
		
		return XmlUtil.imageTextInfoToXml(imageTextMsg);
	}
	
	
	/**
	 * 图片消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String imageSendInfo(String toUserName,String fromUserName) {
		WxImageMsg imageMsg = new WxImageMsg();
		imageMsg.setFromUserName(toUserName);
		imageMsg.setToUserName(fromUserName);
		imageMsg.setCreateTime(new Date().getTime());
		imageMsg.setMsgType(Constant.WX_MESSAGE_IMAGE);
		WxImage wxImage = new WxImage();
		wxImage.setMediaId("aaXPCSmQOmW2S-HX4TI5eKN3OSLd_e52S1orrtoyh2MZo6igSc_ndc34txfY_DxD");
		imageMsg.setImage(wxImage);
		return XmlUtil.objToXml(imageMsg);
	}
	
	/**
	 * 语音消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String voiceSendInfo(String toUserName,String fromUserName) {
		WxVoiceMsg  wxVoiceMsg = new WxVoiceMsg();
		wxVoiceMsg.setFromUserName(toUserName);
		wxVoiceMsg.setToUserName(fromUserName);
		wxVoiceMsg.setCreateTime(new Date().getTime());
		wxVoiceMsg.setMsgType(Constant.WX_MESSAGE_VOICE);
		WxVoice wxVoice = new WxVoice();
		wxVoice.setMediaId("-urqYn7wlURT-j_4017jCjEqivkXFre-FV7ZiogRNZfkw59qFnLo5psHse8R_n4P");
		wxVoiceMsg.setVoice(wxVoice);
		return XmlUtil.objToXml(wxVoiceMsg);
	}
	
	/**
	 * 视频消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String videoSendInfo(String toUserName,String fromUserName) {
		WxVideoMsg  wxVideoMsg = new WxVideoMsg();
		wxVideoMsg.setFromUserName(toUserName);
		wxVideoMsg.setToUserName(fromUserName);
		wxVideoMsg.setCreateTime(new Date().getTime());
		wxVideoMsg.setMsgType(Constant.WX_MESSAGE_VIDEO);
		WxVideo wxVideo = new WxVideo();
		wxVideo.setMediaId("aCBQ5B8bxvgLEqb86UVSKx5-SNbTcnHAFBjL2FImRNuVn2VthreRIYKVLwD_BF07");
		wxVideo.setTitle("我是视频的标题");
		wxVideo.setDescription("我是视频的描述");
		wxVideoMsg.setVideo(wxVideo);
		return XmlUtil.objToXml(wxVideoMsg);
	}
	
	
	/**
	 * 音乐消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String musicSendInfo(String toUserName,String fromUserName) {
		WxMusicMsg  wxMusicMsg = new WxMusicMsg();
		wxMusicMsg.setFromUserName(toUserName);
		wxMusicMsg.setToUserName(fromUserName);
		wxMusicMsg.setCreateTime(new Date().getTime());
		wxMusicMsg.setMsgType(Constant.WX_MESSAGE_MUSIC);
		WxMusic wxMusic = new WxMusic();
		wxMusic.setThumbMediaId("eTcsLiF5Z2RIr-jn36t1wf4H80s7gizRrwkabqYjWuKjimHeNzOwmHcmxRgJjJWN");
		wxMusic.setTitle("我是音乐的标题");
		wxMusic.setDescription("我是音乐的描述");
		wxMusic.setMusicUrl("http://60.205.226.170:80/WeiXin/resource/music/1.mp3");
		wxMusic.setHQMusicUrl("http://60.205.226.170:80/WeiXin/resource/music/1.mp3");
		wxMusicMsg.setMusic(wxMusic);
		return XmlUtil.objToXml(wxMusicMsg);
	}
	
	
}
