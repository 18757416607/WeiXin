package com.zldzs.initMainRun;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.zldzs.pojo.AccessToken;
import com.zldzs.util.RequestWx;
import com.zldzs.util.wx.WxFileUpload;

/**
 * 消息回复时  需要上传素材
 * 只针对上传临时素材
 * @author admin188
 *
 */
public class MessageInit_TempFile {

	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		AccessToken token = RequestWx.getAccessToken();
		/**  图片
		 * {"created_at":1512715420,"media_id":"aaXPCSmQOmW2S-HX4TI5eKN3OSLd_e52S1orrtoyh2MZo6igSc_ndc34txfY_DxD","type":"image"}
		   WxFileUpload.upload("D:/1.png", token.getAccess_token(), "image");
		 */
		/**语音
		 * {"created_at":1512720487,"media_id":"-urqYn7wlURT-j_4017jCjEqivkXFre-FV7ZiogRNZfkw59qFnLo5psHse8R_n4P","type":"voice"}
		 * WxFileUpload.upload("D:/1.mp3", token.getAccess_token(), "voice");
		 */
		/**视频
		 * {"created_at":1512721540,"media_id":"aCBQ5B8bxvgLEqb86UVSKx5-SNbTcnHAFBjL2FImRNuVn2VthreRIYKVLwD_BF07","type":"video"}
		 * WxFileUpload.upload("D:/1.mp4", token.getAccess_token(), "Video");
		 */
		/**
		 * 缩略图
		 * {"created_at":1512724811,"thumb_media_id":"eTcsLiF5Z2RIr-jn36t1wf4H80s7gizRrwkabqYjWuKjimHeNzOwmHcmxRgJjJWN","type":"thumb"}
		 */
		WxFileUpload.upload("D:/1.jpg", token.getAccess_token(), "thumb");
		
		System.out.println(token.getAccess_token());
		System.out.println(token.getExpires_in());
	}
	
}
