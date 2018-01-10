package com.zldzs.util.wx;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;
import com.zldzs.util.Constant;

/**
 * 上传到微信服务器的上传工具类
 * @author Administrator
 *
 */
public class WxFileUpload {

	/**
	 * 微信文件上传,上传操作可在后台管理中维护
	 * @param filePath   上传文件路劲
	 * @param access_token  微信获取的token
	 * @param type   上传文件的类型    分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * 图片 :2M，支持PNG\JPEG\JPG\GIF格式
	 * 语音 :2M，播放长度不超过60s，支持AMR\MP3格式
	 * 视频片 :10MB，支持MP4格式
	 * 缩略图 :64KB，支持JPG格式
	 * @return
	 * @throws IOException
	 */
	public static String upload(String filePath,String access_token,String type) throws IOException {
		File file = new File(filePath);
		//判断此路劲中需要上传的文件是否存在
		if(!file.exists()||!file.isFile()) {
			throw new IOException("文件不存在");
		}
		
		String url = Constant.WX_UPLOAD_RESOURCE.replace("ACCESS_TOKEN", access_token).replace("TYPE", type);
		
		URL urlObj = new URL(url);
	
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);
		//设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		
		//设置边界
		String BOUNDARY = "-----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
		
		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition:form-data;name=\"file\";filename=\""+file.getName()+"\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		
		byte[] head = sb.toString().getBytes("UTF-8");
		
		//获取输入流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		//输出表头
		out.write(head);
		
		//文件正文部分
		//把文件已   流文件的方式  推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while((bytes=in.read(bufferOut)) != -1) {
			out.write(bufferOut,0,bytes);
		}
		in.close();
		
		//结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8"); //定义最后数据分割线
		
		out.write(foot);
		out.flush();
		out.close();
		
		StringBuilder buffer = new StringBuilder();
		String result = null;
		//定义BufferedReader输入流来读取URL的响应
		BufferedReader reader =  new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = null;
		while((line=reader.readLine()) != null) {
			buffer.append(line);
		}
		if(result == null) {
			result = buffer.toString();
		}
		if(reader != null) {
			reader.close();
		}
		
		JSONObject josnObj = JSONObject.parseObject(result);
		System.out.println(josnObj);
		return josnObj.getString("media_id");
	}
	
	
}
