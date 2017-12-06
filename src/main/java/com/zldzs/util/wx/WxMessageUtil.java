package com.zldzs.util.wx;

import java.util.Date;

import com.zldzs.pojo.WxMsg;
import com.zldzs.util.Constant;
import com.zldzs.util.XmlUtil;

/**
 * ΢�ŵ���Ϣ�ظ���
 * @author Administrator
 *
 */
public class WxMessageUtil {

	/**
	 * ��ע���ں�ʱ���͵���Ϣ
	 * @param toUserName ���͸�˭
	 * @param fromUserName  ˭���͵�
	 * @param sendContent   ���͵�����
	 * @return
	 */
	public static String subscribeSendInfo(String toUserName,String fromUserName,String sendContent) {
		WxMsg msg = new WxMsg();
		msg.setFromUserName(toUserName);
		msg.setToUserName(fromUserName);
		msg.setCreateTime(new Date().getTime());
		msg.setMsgType(Constant.WX_MESSAGE_TEXT);
		msg.setContent(sendContent);
		return XmlUtil.objToXml(msg);
	}
	
	
	/**
	 * �û���ע���ں�ʱ�ظ��Ĳ˵���Ϣ
	 */
	public static String menuMsg() {
		StringBuffer sb = new StringBuffer();
		sb.append("��л���Ĺ�ע,���ǽ�Ϊ���ṩ������ķ���,�밴�˵���ʾ����:\n\n");
		sb.append("1.��������\n");
		sb.append("2.��������\n");
		sb.append("3.�Ҹ�\n");
		sb.append("�ظ� ? �鿴�˵�");
		return sb.toString();
	}
	
	
	/**
	 * �û����ݲ˵�   ����	1  ��ʱ��ظ�����Ϣ
	 */
	public static String writeOne() {
		StringBuffer sb = new StringBuffer();
		sb.append("��л���Ĺ�ע,��������רҵ���Ŷ�!\n\n");
		sb.append("1��ϵ��ʽ:18757416607\n");
		sb.append("2.Email:993323226@qq.com\n");
		return sb.toString();
	}
	
	/**
	 * �û����ݲ˵�   ����	2  ��ʱ��ظ�����Ϣ
	 */
	public static String writeTwo() {
		StringBuffer sb = new StringBuffer();
		sb.append("��л���Ĺ�ע,��������רҵ���Ŷ�!\n\n");
		sb.append("1.��\n");
		sb.append("1.��");
		return sb.toString();
	}
	
	/**
	 * �û����ݲ˵�   ����	3  ��ʱ��ظ�����Ϣ
	 */
	public static String writeThree() {
		StringBuffer sb = new StringBuffer();
		sb.append("��л���Ĺ�ע,��������רҵ���Ŷ�!\n\n");
		sb.append("��\n");
		sb.append("��\n");
		sb.append("��\n");
		sb.append("D\n");
		sb.append("J");
		return sb.toString();
	}
	
}
