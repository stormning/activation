package com.slyak.activation.ex;

public class ErrorCode {

	/**
	 * 卡号或密码错误
	 */
	public static final int CARDNO_OR_PASSWORD_ERROR = 0;
	
	/**
	 * 机器码激活次数超过限制
	 */
	public static final int HARDCODE_OVER_TIMES_ERROR = 1;
	
	/**
	 * 超过学习卡激活有效期
	 */
	public static final int EXPIRED_CARD_ERROR = 2;
}
