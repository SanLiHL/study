package com.study.springboot.antianaphylaxis;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * 脱敏工具类
 *
 **/
public class DesensitizedUtils {
 
	/**
	 * 对字符串进行脱敏操作
	 * @param origin 原始字符串
	 * @param prefixNoMaskLen 左侧需要保留几位明文字段 左侧隐藏为0
	 * @param suffixNoMaskLen 右侧需要保留几位明文字段 右侧隐藏为0
	 * @param maskStr 用于遮罩的字符串, 如'*'
	 * @return 脱敏后结果
	 */
	public static String desValue(String origin, int prefixNoMaskLen, int suffixNoMaskLen, String maskStr) {
		if (origin == null) {
			return null;
		}
		//去除前后空格
		origin = origin.trim();
		StringBuilder sb = new StringBuilder();
		for (int i = 0, n = origin.length(); i < n; i++) {
			if (i < prefixNoMaskLen) {
				sb.append(origin.charAt(i));
				continue;
			}
			if (i > (n - suffixNoMaskLen - 1)) {
				sb.append(origin.charAt(i));
				continue;
			}
			sb.append(maskStr);
		}
		return sb.toString();
	}

	/**
	 * 对字符串进行脱敏操作 左边脱敏
	 * @param origin 原始字符串
	 * @param prefixNoMaskLen 左侧需要隐藏的擦灰姑娘度
	 * @return 脱敏后结果
	 */
	public static String desValueLeft(String origin, int prefixNoMaskLen) {
		if (origin == null) {
			return null;
		}
		origin.trim();
		StringBuilder sb = new StringBuilder();
		for (int i = 0, n = origin.length(); i < n; i++) {
			if (i < prefixNoMaskLen) {
				sb.append("*");
			}else {
				sb.append(origin.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * 对字符串进行脱敏操作 右边脱敏
	 * @param origin 原始字符串
	 * @param prefixNoMaskLen 右侧需要隐藏的擦灰姑娘度
	 * @return 脱敏后结果
	 */
	public static String desValueRight(String origin, int prefixNoMaskLen) {
		if (origin == null) {
			return null;
		}
		origin = origin.trim();
		StringBuilder sb = new StringBuilder();
		int n = origin.length();
		for (int i = 0; i < n; i++) {
			if (i >= n-prefixNoMaskLen) {
				sb.append("*");
			}else {
				sb.append(origin.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * 姓名脱敏
	 * @param fullName 姓名
	 * @return 结果
	 */
	public static String chineseName(String fullName) {
		if (!StringUtils.hasText(fullName)) {
			return null;
		}
		if (!StringUtils.hasText(fullName.trim())) {
			return null;
		}
		fullName = fullName.trim();
		int length = fullName.length();
		//String regx = "^[\\u4e00-\\u9fa5]{1,}$";

		String regx2 = "^[a-zA-Z0-9]+\\s?[\\.·\\-()a-zA-Z]*[a-zA-Z]+$";
		boolean bool = Pattern.matches(regx2, fullName);

		if (bool){
			return desValue(fullName,0,length/2,"*");
		}else {
			if(length<=3){
				return desValueLeft(fullName,1);
			} else if (length<=6) {
				return desValue(fullName,0,length-2,"*");
			}else{
				return desValue(fullName,2,length-6,"*");
			}
		}

	}

	/**
	 * 地址脱敏
	 * @param address 地址
	 * @return 结果
	 */
	public static String address(String address) {
		if (!StringUtils.hasText(address)) {
			return null;
		}
		int length = address.length();
		if (length<=3){
			return address;
		}else if(length<=5){
			return desValue(address,1,2,"*");
		} else if (length<=9) {
			return desValueLeft(address,length-5);
		}else{
			return desValue(address,length-9,5,"*");
		}
	}

	/**
	 * 手机号脱敏
	 * @param num 手机号码
	 * @return 结果
	 */
	public static String mobilePhone(String num) {
		return desValue(num, 3, 3, "*");
	}
 
	/**
	 * 【身份证号】驾驶证社保卡 前四后4显示其余脱敏
	 * @param id 身份证号码
	 * @return 结果
	 */
	public static String idCardNum(String id) {
		return desValue(id, 4, 4, "*");
	}

	public static String idCardNum(String id,String type){

		return "";
	}
 

	/**
	 * 【电子邮箱 邮箱前缀仅显示第一个字母，前缀其他隐藏，用星号代替，@及后面的地址显示，比如：d**@126.com
	 * @param email 电子邮箱
	 * @return 结果
	 */
	public static String email(String email) {
		if (email == null) {
			return null;
		}
		email = email.trim();
		int index = email.indexOf('@');
		if (index <= 1) {
			return desValueLeft(email,index);
		}else if (index<=5){
			return desValueLeft(email,2);
		}else {
			return desValue(email,3,email.length()-index,"*");
		}
	}

	/**
	 * 微信号|军官证脱敏 保留后四位
	 * @param weChat
	 * @return
	 */
	public static String weChat(String weChat) {
		return desValue(weChat, 0, 4, "*");
	}


	/**
	 * 【银行卡号】前六位，后四位，其他用星号隐藏每位1个星号，比如：622260**********1234
	 * @param cardNum 银行卡号
	 * @return 结果
	 */
	public static String bankCard(String cardNum) {
		return desValue(cardNum, 6, 4, "*");
	}

	/**
	 * 【固定电话】 不准????
	 * @param num 固定电话
	 * @return 结果
	 */
	public static String fixedPhone(String num) {
		if (!StringUtils.hasText(num)){
			return null;
		}
		int i = num.lastIndexOf('-');
		return desValue(num, i, 3, "*");
	}
 
	/**
	 * 【密码】密码的全部字符都用*代替，比如：******
	 * @param password 密码
	 * @return 结果
	 */
	public static String password(String password) {
		if (password == null) {
			return null;
		}
		return "******";
	}
 
	/**
	 * 【密钥】密钥除了最后三位，全部都用*代替，比如：***xdS 脱敏后长度为6，如果明文长度不足三位，则按实际长度显示，剩余位置补*
	 * @param key 密钥
	 * @return 结果
	 */
	public static String key(String key) {
		if (key == null) {
			return null;
		}
		int viewLength = 6;
		StringBuilder tmpKey = new StringBuilder(desValue(key, 0, 3, "*"));
		if (tmpKey.length() > viewLength) {
			return tmpKey.substring(tmpKey.length() - viewLength);
		}
		else if (tmpKey.length() < viewLength) {
			int buffLength = viewLength - tmpKey.length();
			for (int i = 0; i < buffLength; i++) {
				tmpKey.insert(0, "*");
			}
			return tmpKey.toString();
		}
		else {
			return tmpKey.toString();
		}
	}
 
}