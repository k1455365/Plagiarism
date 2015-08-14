package kcl.qutong.plagiarism.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * This class include some method use to encrypt password in thsi project
 * @author qutong
 *
 */
public class MD5 {
	public static String getPasswordMD5(String password) {
		StringBuffer buffer = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte b[] = md.digest();
			int i;
			
			for (int j = 0; j < b.length; j++) {
				i = b[j];
				if (i<0) {
					i+=256;
				}
				if (i<16) {
					buffer.append("0");
				}
				buffer.append(Integer.toHexString(i));
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer.toString();
	}
}
