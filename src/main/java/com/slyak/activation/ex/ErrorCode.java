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

	/**
	 * 学习卡对应的学科不存在
	 */
	public static final int COURSE_NOT_EXIST_ERROR = 3;

	/**
	 * 没有权限激活该学段的课程
	 */
	public static final int NO_SECTION_PERMISSION_ERROR = 4;
}
