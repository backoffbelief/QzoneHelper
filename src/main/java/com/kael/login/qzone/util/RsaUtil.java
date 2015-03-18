package com.kael.login.qzone.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class RsaUtil {

	private static String pub_rsa_key = "F20CE00BAE5361F8FA3AE9CEFA495362FF7DA1BA628F64A347F0A8C012BF0B254A30CD92ABFFE7A6EE0DC424CB6166F8819EFA5BCCB20EDFB4AD02E412CCF579B1CA711D55B8B0B3AEB60153D5E0693A2A86F3167D7847A0CB8B00004716A9095D9BADC977CBB804DBDCBA6029A9710869A453F27DFDDF83C016D928B3CBF4C7";

	private static Cipher cipher ;
	
	static{
		try {
			cipher = Cipher.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
	
	public static String rsa_encrypt(String src){
		try {
			cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(pub_rsa_key));
			return Base64.encode(cipher.doFinal(src.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/** 
     * 得到公钥 
     *  
     * @param key 
     *            密钥字符串（经过base64编码） 
     * @throws Exception 
     */  
    public static PublicKey getPublicKey(String key) throws Exception {  
        byte[] keyBytes;  
        keyBytes = Base64.decode(key);  
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
        PublicKey publicKey = keyFactory.generatePublic(keySpec);  
        return publicKey;  
    }  
}
