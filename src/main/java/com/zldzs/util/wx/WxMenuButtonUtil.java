package com.zldzs.util.wx;

import com.zldzs.pojo.menu.Button;
import com.zldzs.pojo.menu.ClickButton;
import com.zldzs.pojo.menu.Menu;
import com.zldzs.pojo.menu.ViewButton;
import com.zldzs.util.Constant;

/**
 * 微信的菜单 按钮  回复类
 * @author Administrator
 *
 */
public class WxMenuButtonUtil {

	/**
	 * 初始化  微信菜单
	 * @return
	 */
	public static Menu initMenu() {
		
		ClickButton cButton = new ClickButton();
		cButton.setName("显示菜单");
		cButton.setType(Constant.WX_BUTTON_CLICK1);
		cButton.setKey("click1");
		
		ViewButton viewButton = new ViewButton();
		viewButton.setName("去nexus");
		viewButton.setType(Constant.WX_BUTTON_VIEW1);
		viewButton.setUrl("http://60.205.226.170:8081/nexus/");
		
		ClickButton cButton2 = new ClickButton();
		cButton2.setName("扫码");
		cButton2.setType(Constant.WX_BUTTON_SCANCODE_PUSH);
		cButton2.setKey("scancode_push1");
		
		ClickButton cButton3 = new ClickButton();
		cButton3.setName("获取地理位置");
		cButton3.setType(Constant.WX_BUTTON_LOCATION_SELECT);
		cButton3.setKey("location_select1");
		
		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[] {cButton2,cButton3});
		
		Menu menu = new Menu();
		menu.setButton(new Button[] {cButton,viewButton,button});
		
		return menu;
		
	}
	
}
