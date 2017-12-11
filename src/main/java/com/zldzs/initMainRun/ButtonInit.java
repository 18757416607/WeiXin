package com.zldzs.initMainRun;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONObject;
import com.zldzs.pojo.AccessToken;
import com.zldzs.pojo.menu.Menu;
import com.zldzs.util.Constant;
import com.zldzs.util.RequestWx;
import com.zldzs.util.wx.WxMenuButtonUtil;

/**
 * 初始化自定义菜单
 * @author admin188
 *
 */
public class ButtonInit {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		AccessToken token = RequestWx.getAccessToken();
		String create_menu_url = Constant.TEST_WX_INIT_MENU.replace("ACCESS_TOKEN", token.getAccess_token());
		
		Menu menu = WxMenuButtonUtil.initMenu();
		String str_menu = JSONObject.toJSONString(menu);
		
		System.out.println(str_menu+"..");
		
		JSONObject json = RequestWx.doPostWx(create_menu_url, str_menu);
		
		System.out.println("创建菜单返回消息:"+json);
		System.out.println(json.getString("errcode"));
		
	}
	
	
}
