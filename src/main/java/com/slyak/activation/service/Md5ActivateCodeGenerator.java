package com.slyak.activation.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

public class Md5ActivateCodeGenerator {
	private static final String SALT = "asFsd650VHI^%dGJ:JIGFH&*a3vsJdfG12";
	
	public static String generate(String verifyCode) {
        return StringUtils.left(DigestUtils.md5Hex(verifyCode + SALT), 6);
    }
	
	
	/*public static Certificate parseCertificate(String verifyCode) {
		Certificate certificate = new Certificate();
		int len = verifyCode.length();
		if (len > 5) {
			certificate.setCourseId(Integer.valueOf(verifyCode.substring(0, len - 5)));
			certificate.setVersion(Short.valueOf(verifyCode.substring(len - 5, len - 4)));
			certificate.setHardCode(Short.valueOf(verifyCode.substring(len - 4)));
			return certificate;
		}
		throw new AnyException(ErrorCode.VERIFYCODE_FORMAT_ERROR);
	}*/
}
