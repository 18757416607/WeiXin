package com.zldzs.thread;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.zldzs.pojo.AccessToken;
import com.zldzs.util.RequestWx;

/**
 * 微信获取   Access_Token  线程
 * 能够保持Access_Token的不失效	
 * @author Administrator
 *
 */
public class TokenThread implements Runnable {  

    public static AccessToken accessToken = null;  
  
    public void run() {  
        while (true) {  
            try {  
                accessToken = RequestWx.getAccessToken();  
                System.out.println("\n\n【获取微信token】:"+accessToken.getAccess_token()+"\n\n");
                if (null != accessToken) {  
                    // 休眠7000秒  
                    Thread.sleep((accessToken.getExpires_in() - 200) * 1000);  
                } else {  
                    // 如果access_token为null，60秒后再获取  
                    Thread.sleep(60 * 1000);  
                }  
            } catch (InterruptedException e) {  
                try {  
                    Thread.sleep(60 * 1000);  
                } catch (InterruptedException e1) {  
                	
                }  
            } catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
        }  
    }  
}  
