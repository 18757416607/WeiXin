package com.zldzs.pojo.message;

import java.util.List;

import com.zldzs.pojo.BaseMsg;

/**
 * 微信  图文消息  实体
 * @author Administrator
 *
 */
public class WxImageTextMsg extends BaseMsg{

	
	private int  ArticleCount;  //图文消息个数，限制为8条以内
	private List<WxImageTextMsgItem> Articles;  //多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
	
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<WxImageTextMsgItem> getArticles() {
		return Articles;
	}
	public void setArticles(List<WxImageTextMsgItem> articles) {
		Articles = articles;
	}
	
	
	
}
