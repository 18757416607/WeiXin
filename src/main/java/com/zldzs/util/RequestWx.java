package com.zldzs.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.zldzs.pojo.AccessToken;

/**
 * ��΢������  ��    �ύ����
 * @author Administrator
 *
 */
public class RequestWx {

	/**
	 * get ��ʽ
	 * @param getUrl  �����url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject doGetWx(String getUrl) throws ClientProtocolException, IOException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(getUrl);
		JSONObject jsonObject = null;
		HttpResponse httpResponse = httpClient.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if(entity != null) {
			String result = EntityUtils.toString(entity,"UTF-8");
			jsonObject = JSONObject.parseObject(result); 
		}
		return jsonObject;
	}
	
	/**
	 * post ��ʽ
	 * @param getUrl  �����url
	 * @param outStr  ��Ҫ�ύ������   �ַ�����ʽ
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject doPostWx(String getUrl,String outStr) throws ClientProtocolException, IOException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(getUrl);
		JSONObject jsonObject = null;
		httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
		HttpResponse httpResponse =  httpClient.execute(httpPost);
		HttpEntity entity = httpResponse.getEntity();
		if(entity != null) {
			String result = EntityUtils.toString(entity,"UTF-8");
			jsonObject = JSONObject.parseObject(result); 
		}
		return jsonObject;
	}
	
	
	/**
	 * ��ȡ΢��token
	 * ��Сʱ�����,�����������ڴ���
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static AccessToken getAccessToken() throws ClientProtocolException, IOException {
		AccessToken token = new AccessToken();
		String url = Constant.TEST_WX_GET_ACCESSTOKEN_URL.replace("APPID", Constant.TEST_WX_APPID).replace("APPSECRET", Constant.TEST_WX_APPSECRET);
		JSONObject jsonObject = RequestWx.doGetWx(url);
		System.out.println("map:"+jsonObject);
		if(jsonObject != null){
			token.setAccess_token(jsonObject.getString("access_token"));
			token.setExpires_in(jsonObject.getInteger("expires_in"));
		}
		return token;
	}
	
}
