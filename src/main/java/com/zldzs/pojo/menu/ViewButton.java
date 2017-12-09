package com.zldzs.pojo.menu;

/**
 * View类型菜单按钮  实体
 * @author admin188
 *
 */
public class ViewButton extends Button{

	private String url; //网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。

	private String media_id; //  调用新增永久素材接口返回的合法media_id

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
	
	
	
}
