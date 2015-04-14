

public class Encryption {

	public static String getPwd0(String uin, String pwd, String verifyCode)
			throws Exception {
		String C = "";
		try {
			String H = MD5.hexchar2bin(MD5.md5(pwd));
			String F = MD5.md5(H
					+ MD5.hexchar2bin(uin.replace("\\x", "").toUpperCase()));
			C = MD5.md5(F + verifyCode.toUpperCase());
		} catch (Exception e) {
			throw new Exception("getPwd error:", e);
		}
		return C;
	}
	
	public static void main(String[] args) {
		String password ="0000";
		String salt = "aaaa";
		String vcode = "";
		boolean isMd5 = false;
		try {
			System.out.println(getEncryption(password, salt, vcode, isMd5 ));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getEncryption(String password,String salt,String vcode,boolean isMd5)
			throws Exception {
		String md5Pwd = isMd5 ? password : MD5.md5(password);
		String h1 = MD5.hexchar2bin(md5Pwd);
		String s2 = MD5.md5(h1 + salt);
		String rsaH1 = RSA.rsa_encrypt(h1);
		String rsaH1Len = Integer.toString(rsaH1.length()/2, 16);
		String hexVcode = TEA.strToBytes(vcode.toUpperCase(),true);
		String vcodeLen = Integer.toString(hexVcode.length()/2, 16);
		
		while (vcodeLen.length() < 4) {
			vcodeLen = "0" + vcodeLen;
		}
		while (rsaH1Len.length() < 4) {
			rsaH1Len = "0" + rsaH1Len;
		}
		
		TEA.initkey(s2,false);
		String saltPwd = TEA.enAsBase64(rsaH1Len + rsaH1 + TEA.strToBytes(salt,false)
				+ vcodeLen + hexVcode,false);
		TEA.initkey("",false);
		return saltPwd.replace("/", "-").replace("+", "*").replace("=", "_");
	}
}
