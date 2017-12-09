package com.zldzs.pojo.menu;

/**
 * Click类型菜单按钮  实体
 * @author admin188
 *
 */
public class ClickButton extends Button{

	private String key;    //菜单KEY值，用于消息接口推送，不超过128字节

	public String getKey() {
		return key;
	}

	/**
	 * 如果有多个click类型的按钮,key必须不一样,这样才能区别触发的是哪个按钮
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
