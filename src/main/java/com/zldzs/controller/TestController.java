package com.zldzs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zldzs.pojo.AccessToken;
import com.zldzs.service.ITestConnService;
import com.zldzs.util.RequestWx;
import com.zldzs.util.wx.WxFileUpload;

@Controller
public class TestController {

	
	@Resource
	private ITestConnService iTestConnService;
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public Map<String,Object> test1(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "aaa");
		map.put("name1","ttt");
		map.put("date", new Date());
		map.put("flag", 1);
		return map;
	}
	
	
	@RequestMapping(value = "/t")
	@ResponseBody
	public int test(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "aaa");
		map.put("name1","ttt");
		map.put("date", new Date());
		map.put("flag", 1);
		return iTestConnService.add(map);
	}
	
	
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
