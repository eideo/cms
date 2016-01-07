package com.sbiao360.cms.zutil;

/**
 * ���ܵ�¼����
 * ����:
 *		PwdStuff mBean = new PwdStuff();
 *		String id = "zwz3yxz268";
 *		String eid = mBean.convertPassword(id);
 */

public class PwdStuff {

	final public static short MIN_PASSWORD_LENGTH = 8;

	public PwdStuff() {

	}

	public boolean correctPassword(String pwd, String password) {
		return convertPassword(pwd).equals(password);
	}

	public String convertPassword(String s) {
		if (s.length() < MIN_PASSWORD_LENGTH) {
			s = padString(s);
		}
        ////System.out.println( "s=" + s );
		DES des = new DES();
		byte buf1[] = s.getBytes(),
			buf2[] = new byte[MIN_PASSWORD_LENGTH],
			buf3[] = new byte[MIN_PASSWORD_LENGTH];
		int i =
			buf1.length / MIN_PASSWORD_LENGTH
				+ (buf1.length % MIN_PASSWORD_LENGTH != 0 ? 1 : 0);
		byte buf4[] = new byte[i * MIN_PASSWORD_LENGTH];
		System.arraycopy(buf1, 0, buf2, 0, MIN_PASSWORD_LENGTH);
		// user first 8 bytes as initial key
		for (i = 0; i < buf1.length; i += MIN_PASSWORD_LENGTH) {
			if (i + MIN_PASSWORD_LENGTH <= buf1.length)
				System.arraycopy(buf1, i, buf3, 0, MIN_PASSWORD_LENGTH);
			else {
				System.arraycopy(buf1, i, buf3, 0, buf1.length - i);
				int j;
				for (j = buf1.length - i; j < MIN_PASSWORD_LENGTH; ++j)
					buf3[j] = (byte) 0;
			}
			try {
				//des.setKey(new SymmetricKey(buf2));
				des.setKey(buf2); //change by zjh
				des.encryptOp(buf3, 0, buf2, 0);
				System.arraycopy(buf2, 0, buf4, i, MIN_PASSWORD_LENGTH);
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		buf1 = Base64.encodeBinary(buf4);
		return new String(buf1);
	}

	private String padString(String src) {
        int n = MIN_PASSWORD_LENGTH - src.length();
		for (int i = 0; i < n; i++) {
			//			src.concat("@");
			src += "@";
		}
		return src;
	}

	public static void main(String[] args) {
		PwdStuff mBean = new PwdStuff();
		String id = "123456";
		String eid = mBean.convertPassword(id);
		System.out.println(eid);
		System.out.println("result is "+mBean.correctPassword(id,eid));
	}

}
