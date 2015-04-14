package com.kael.login.qzone.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class RsaUtil {

	static String pub_rsa_key = "F20CE00BAE5361F8FA3AE9CEFA495362FF7DA1BA628F64A347F0A8C012BF0B254A30CD92ABFFE7A6EE0DC424CB6166F8819EFA5BCCB20EDFB4AD02E412CCF579B1CA711D55B8B0B3AEB60153D5E0693A2A86F3167D7847A0CB8B00004716A9095D9BADC977CBB804DBDCBA6029A9710869A453F27DFDDF83C016D928B3CBF4C7";
    static String z = "3";
    static int O = 256;
    
//	private static Cipher cipher ;
//	
//	static{
//		try {
//			cipher = Cipher.getInstance("RSA");
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static String rsa_encrypt(String src){
//		try {
//			cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(pub_rsa_key));
//			return Base64.encode(cipher.doFinal(src.getBytes()));
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//	
//	/** 
//     * 得到公钥 
//     *  
//     * @param key 
//     *            密钥字符串（经过base64编码） 
//     * @throws Exception 
//     */  
//    public static PublicKey getPublicKey(String key) throws Exception {  
//        byte[] keyBytes;  
//        keyBytes = Base64.decode(key);  
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
//        PublicKey publicKey = keyFactory.generatePublic(keySpec);  
//        return publicKey;  
//    }  
	static String aj(String aC,int aD){
		int z = 0;
		String t = "";
		while(z < aC.length() - aD){
			t += aC.substring(z, z + aD) + "\n";
            z += aD;
		}
		return t + aC.substring(z, aC.length());
	}
	
	static String u(int t){
		if(t < 16){
			return "0"+Integer.toHexString(t);
		}
		return Integer.toHexString(t);
	}
	
	static Object ah(String aD, int aG) {
		if (aG < aD.length() + 11) {
			System.err.println("Message too long for RSA");
			return null;
		}
		
		int aC = aD.length() - 1;
		int[] aF = new int[Math.min(aC + 1, aG)];
		while (aC >= 0 && aG > 0) {
			aF[--aG] = aD.codePointAt(aC--);
		}
		aF[--aG] = 0;
		
		return null;
	}
	
    static String rsa_encrypt(String src){
    	N t = new N();
    	t.setPublic(pub_rsa_key, z);
    	return t.encrypt(src);
    }
    

	static boolean isEmpty(String src){
		if(src == null || src.length() == 0){
			return true;
		}
		return false;
	}

	static boolean isNonEmpty(String src){
		return !isEmpty(src);
	}
	
	
	static void au(Object z,Object t,Object ac,String ret){
		if(z != null){
			
		}
	}
	
	static String h(String z, int i) {
		AU au = new AU();
//		return au.au(z,i);
		return null;
	}
	
	static long K(char[] E, int F, int B) {
		B = Math.min(B, 4);
		int C = 0;
		for (int D = F; D < F + B; D++) {
			C <<= 8;
			C |= E[D];
		}
		return (C & 4294967295l) >>> 0;
	}
	
	static void b(long[] C, int D, int B) {
        C[D + 3] = (B >> 0) & 255;
        C[D + 2] = (B >> 8) & 255;
        C[D + 1] = (B >> 16) & 255;
        C[D + 0] = (B >> 24) & 255;
    }

	static String x(String C) {
		StringBuilder d = new StringBuilder();
		for (int B = 0; B < C.length(); B += 2) {
			// D += String.fromCharCode(parseInt(C.substr(B, 2), 16));
			d.append((char) (Integer.parseInt(C.substring(B, B + 2))));
		}
		return d.toString();
	}

	static String y(String E) {
		if (null == E) {
			return "";
		}
		StringBuilder B = new StringBuilder();
		for (int C = 0; C < E.length(); C++) {
			String D = Integer.toString(E.charAt(C), 16);
			if (D.length() == 1) {
				D = "0" + D;
			}
			B.append(D);
		}
		return B.toString();
	}

	static class N{
		String n = null;
		int e = 0;
		
		void setPublic(String z,String t){
	    	if(isNonEmpty(z) && isNonEmpty(t)){
	    		n = h(z,16);
	    		e = Integer.parseInt(t, 16);
	    	}else{
	    		System.err.println("error.........................--");
	    	}
	    	
	    }
		
		String encrypt(String src) {
			int[] C = q(src, null);
//	            var B = j(C);
			return null;
		}
		
		int[] q(String F, Object E) {
			int[] d;
			if (E != null) {
				d = new int[F.length()];
				for (int C = 0; C < F.length(); C++) {
					d[C] = F.codePointAt(C) & 255;
				}
			} else {
				d = new int[F.length() / 2];
				int B = 0;
				for (int C = 0; C < F.length(); C += 2) {
					d[B++] = Integer.parseInt(F.substring(C, C + 2), 16);
				}
			}
			return d;
		}

		String r(String ac){
			
			return null;
		}
	}
	
	static class AU{
		int ac = 52;
		int ay = 0;
		int DM = ((1 << ay) - 1);
		int DV = (1 << ay);
		long FV  = (long) Math.pow(2, ac);
		int F1 = ac-ay;
		int F2 = 2*ay-ac;
		String ag = "0123456789abcdefghijklmnopqrstuvwxyz";
		int[]ai = null;
		long now ;
		
		//bitLength
		private AU() {
			int ar = "0".codePointAt(0);
			int x = 0;
			ai = new int[62];
			for (; x <= 9; ++x) {
		        ai[ar++] = x;
		    }
		    ar = "a".codePointAt(0);
		    for (x = 10; x < 36; ++x) {
		        ai[ar++] = x;
		    }
		    ar = "A".codePointAt(0);
		    for (x = 10; x < 36; ++x) {
		        ai[ar++] = x;
		    }
			now = System.currentTimeMillis();
		}

		int  w(){
			if (this.now <= 0) {
	            return 0;
	        }
			return 0;
//	        return this.ay * (this.now - 1) + l(this[this.now - 1] ^ (this.s & this.DM));
		}
		//modPowInt
//		function ap(aC, t) {
//	        var aD;
//	        if (aC < 256 || t.isEven()) {
//	            aD = new M(t)
//	        } else {
//	            aD = new g(t)
//	        }
//	        return this.exp(aC, aD)
//	    }
		
		//fromString
		void fromString(String aG,int z){
			int aD ;
			switch (z) {
			case 2:aD = 1;break;
			case 4:aD = 2;break;
			case 8:aD = 3;break;
			case 16:aD = 4;break;
			case 32:aD = 5;break;
//			case 64:aD = 6;break;
//			case 128:aD = 7;break;
			case 256:aD = 8;break;

			default:
//				 this.fromRadix(aG, z);
				 return ;
			}
			
			int aF = aG.length();
		    boolean aC = false;
		    int aE = 0;
		    
		    while( -- aF >= 0){
		    	int t = (aD == 8) ? aG.charAt(aF) & 255 : C(aG, aF);
		    	if (t < 0) {
	                if (aG.charAt(aF) == '-') {
	                    aC = true;
	                }
	                continue;
	            }
	            aC = false;
//	            if (aE == 0) {
//	                this[this.t++] = t
//	            } else {
//	                if (aE + aD > this.DB) {
//	                    this[this.t - 1] |= (t & ((1 << (this.DB - aE)) - 1)) << aE;
//	                    this[this.t++] = (t >> (this.DB - aE))
//	                } else {
//	                    this[this.t - 1] |= t << aE
//	                }
//	            }
//	            aE += aD;
//	            if (aE >= this.DB) {
//	                aE -= this.DB
//	            }
		    }
		}
		
		int C(String z, int t) {
			return ai[z.charAt(t)];
		}
	}
	
	static class AF{
		int ae;
		int[] W;
		M o;
		private AF() {
			W = new int[O % 2 == 0 ? O + 1 : O + 2];
			int K;
//			if (navigator.appName == "Netscape" && navigator.appVersion < "5" && window.crypto && window.crypto.random) {
//	            var H = window.crypto.random(32);
//	            for (K = 0; K < H.length; ++K) {
//	                W[ae++] = H.charCodeAt(K) & 255
//	            }
//	        }
			while(ae < O ){
				K = (int) Math.floor(65536 * Math.random());
				W[ae ++ ] = K>>>8;
     		    W[ae ++ ] = K & 255;
			}
			 ae = 0;
			 V();
		}
		
		private void V() {
			long now = System.currentTimeMillis();
//			add(W, ae++, value);
//			add(W, ae++, value);
//			add(W, ae++, value);
//			add(W, ae++, value);
//			add(W, ae++, value);
			W[ae++] ^= now & 255;
	        W[ae++] ^= (now >> 8) & 255;
	        W[ae++] ^= (now >> 16) & 255;
	        W[ae++] ^= (now >> 24) & 255;
	        if (ae >= O) {
	            ae -= O;
	        }
		}
		
		int E(){
			if(o == null){
				o = new M();
				o.init(W);
				
				for(int i = 0 ;i <W.length;i++){
					W[i] = 0;
				}
				ae = 0;
			}
			return o.next();
		}
		
		
		static class M {

			private int i;
			private int j;
			private int[] S;

			private M() {
				this.i = 0;
				this.j = 0;
			}

			void init(int[] aE) {
				this.S = new int[256];
				int aD = 0, z = 0, aC;
				for (aD = 0; aD < 256; ++aD) {
					this.S[aD] = aD;
				}
				for (aD = 0; aD < 256; ++aD) {
					z = (z + this.S[aD] + aE[aD % aE.length]) & 255;
					aC = this.S[aD];
					this.S[aD] = this.S[z];
					this.S[z] = aC;
				}
				this.i = 0;
				this.j = 0;
			}

			int next() {
				i = (i + 1) & 255;
				j = (j + S[i]) & 255;
				int z = S[i];
				S[i] = S[j];
				S[j] = z;
				return S[(z + S[i]) & 255];
			}
		}
		
	}
	
	
//	static void add(int[] src,int index,int value){
//		if(index >= src.length){
//			src = Arrays.copyOf(src, index + 1);
//		}
//		src[index] = value;
//	}
}
