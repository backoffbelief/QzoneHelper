package com.kael.login.qzone.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import com.kael.login.qzone.model.QzoneUser;
public class Utils {
	private Utils() {

	}

	private static boolean hexcase = true;
    private static int mode = 32;
    private static int chrsz = 8;
    
    public static String md5(String A) {
        return hex_md5(A);
    }
    
    public static String hex_md5(String A) {
       return binl2hex(core_md5(str2binl(A), A.length() * chrsz));
    }
    
    public static String str_md5(String A) {
        return binl2str(core_md5(str2binl(A), A.length() * chrsz));
    }
    
    public static int[] core_md5(int[] x, int len) {
        int[] X = new int[(((len + 64) >>> 9) << 4) + 14 + 2];
        for (int i = 0; i < x.length; i++) {
            X[i] = x[i];
        }
        
        X[len >> 5] |= 128 << ((len) % 32);
        X[(((len + 64) >>> 9) << 4) + 14] = len;
        int a = 1732584193;
        int b = -271733879;
        int c = -1732584194;
        int d = 271733878;
        for (int C = 0; C < X.length; C += 16) {
            int olda = a;
            int oldb = b;
            int oldc = c;
            int oldd = d;
            a = md5_ff(a, b, c, d, X[C + 0], 7, -680876936);
            d = md5_ff(d, a, b, c, X[C + 1], 12, -389564586);
            c = md5_ff(c, d, a, b, X[C + 2], 17, 606105819);
            b = md5_ff(b, c, d, a, X[C + 3], 22, -1044525330);
            a = md5_ff(a, b, c, d, X[C + 4], 7, -176418897);
            d = md5_ff(d, a, b, c, X[C + 5], 12, 1200080426);
            c = md5_ff(c, d, a, b, X[C + 6], 17, -1473231341);
            b = md5_ff(b, c, d, a, X[C + 7], 22, -45705983);
            a = md5_ff(a, b, c, d, X[C + 8], 7, 1770035416);
            d = md5_ff(d, a, b, c, X[C + 9], 12, -1958414417);
            c = md5_ff(c, d, a, b, X[C + 10], 17, -42063);
            b = md5_ff(b, c, d, a, X[C + 11], 22, -1990404162);
            a = md5_ff(a, b, c, d, X[C + 12], 7, 1804603682);
            d = md5_ff(d, a, b, c, X[C + 13], 12, -40341101);
            c = md5_ff(c, d, a, b, X[C + 14], 17, -1502002290);
            b = md5_ff(b, c, d, a, X[C + 15], 22, 1236535329);
            a = md5_gg(a, b, c, d, X[C + 1], 5, -165796510);
            d = md5_gg(d, a, b, c, X[C + 6], 9, -1069501632);
            c = md5_gg(c, d, a, b, X[C + 11], 14, 643717713);
            b = md5_gg(b, c, d, a, X[C + 0], 20, -373897302);
            a = md5_gg(a, b, c, d, X[C + 5], 5, -701558691);
            d = md5_gg(d, a, b, c, X[C + 10], 9, 38016083);
            c = md5_gg(c, d, a, b, X[C + 15], 14, -660478335);
            b = md5_gg(b, c, d, a, X[C + 4], 20, -405537848);
            a = md5_gg(a, b, c, d, X[C + 9], 5, 568446438);
            d = md5_gg(d, a, b, c, X[C + 14], 9, -1019803690);
            c = md5_gg(c, d, a, b, X[C + 3], 14, -187363961);
            b = md5_gg(b, c, d, a, X[C + 8], 20, 1163531501);
            a = md5_gg(a, b, c, d, X[C + 13], 5, -1444681467);
            d = md5_gg(d, a, b, c, X[C + 2], 9, -51403784);
            c = md5_gg(c, d, a, b, X[C + 7], 14, 1735328473);
            b = md5_gg(b, c, d, a, X[C + 12], 20, -1926607734);
            a = md5_hh(a, b, c, d, X[C + 5], 4, -378558);
            d = md5_hh(d, a, b, c, X[C + 8], 11, -2022574463);
            c = md5_hh(c, d, a, b, X[C + 11], 16, 1839030562);
            b = md5_hh(b, c, d, a, X[C + 14], 23, -35309556);
            a = md5_hh(a, b, c, d, X[C + 1], 4, -1530992060);
            d = md5_hh(d, a, b, c, X[C + 4], 11, 1272893353);
            c = md5_hh(c, d, a, b, X[C + 7], 16, -155497632);
            b = md5_hh(b, c, d, a, X[C + 10], 23, -1094730640);
            a = md5_hh(a, b, c, d, X[C + 13], 4, 681279174);
            d = md5_hh(d, a, b, c, X[C + 0], 11, -358537222);
            c = md5_hh(c, d, a, b, X[C + 3], 16, -722521979);
            b = md5_hh(b, c, d, a, X[C + 6], 23, 76029189);
            a = md5_hh(a, b, c, d, X[C + 9], 4, -640364487);
            d = md5_hh(d, a, b, c, X[C + 12], 11, -421815835);
            c = md5_hh(c, d, a, b, X[C + 15], 16, 530742520);
            b = md5_hh(b, c, d, a, X[C + 2], 23, -995338651);
            a = md5_ii(a, b, c, d, X[C + 0], 6, -198630844);
            d = md5_ii(d, a, b, c, X[C + 7], 10, 1126891415);
            c = md5_ii(c, d, a, b, X[C + 14], 15, -1416354905);
            b = md5_ii(b, c, d, a, X[C + 5], 21, -57434055);
            a = md5_ii(a, b, c, d, X[C + 12], 6, 1700485571);
            d = md5_ii(d, a, b, c, X[C + 3], 10, -1894986606);
            c = md5_ii(c, d, a, b, X[C + 10], 15, -1051523);
            b = md5_ii(b, c, d, a, X[C + 1], 21, -2054922799);
            a = md5_ii(a, b, c, d, X[C + 8], 6, 1873313359);
            d = md5_ii(d, a, b, c, X[C + 15], 10, -30611744);
            c = md5_ii(c, d, a, b, X[C + 6], 15, -1560198380);
            b = md5_ii(b, c, d, a, X[C + 13], 21, 1309151649);
            a = md5_ii(a, b, c, d, X[C + 4], 6, -145523070);
            d = md5_ii(d, a, b, c, X[C + 11], 10, -1120210379);
            c = md5_ii(c, d, a, b, X[C + 2], 15, 718787259);
            b = md5_ii(b, c, d, a, X[C + 9], 21, -343485551);
            a = safe_add(a, olda);
            b = safe_add(b, oldb);
            c = safe_add(c, oldc);
            d = safe_add(d, oldd);
        }
        if (mode == 16) {
            int[] r = { b, c };
            return r;
        } else {
            int[] r = { a, b, c, d };
            return r;
        }       
    }

    public static int md5_cmn(int F, int C, int B, int A, int E, int D) {
        return safe_add(bit_rol(safe_add(safe_add(C, F), safe_add(A, D)), E), B);
    }

    public static int md5_ff(int C, int B, int G, int F, int A, int E, int D) {
        return md5_cmn((B & G) | ((~B) & F), C, B, A, E, D);
    }

    public static int md5_gg(int C, int B, int G, int F, int A, int E, int D) {
        return md5_cmn((B & F) | (G & (~F)), C, B, A, E, D);
    }

    public static int md5_hh(int C, int B, int G, int F, int A, int E, int D) {
        return md5_cmn(B ^ G ^ F, C, B, A, E, D);
    }

    public static int md5_ii(int C, int B, int G, int F, int A, int E, int D) {
        return md5_cmn(G ^ (B | (~F)), C, B, A, E, D);
    }

    public static int safe_add(int x, int y) {
        int lsw = (x & 65535) + (y & 65535);
        int nsw = (x >> 16) + (y >> 16) + (lsw >> 16);
        return (nsw << 16) | (lsw & 65535);
    }

    public static int bit_rol(int A, int B) {
        return (A << B) | (A >>> (32 - B));
    }
    
    public static int[] str2binl(String D) {
        int[] C = new int[(D.length() / 4) + (D.length() % 4 > 0 ? 1 : 0)];
        int A = (1 << chrsz) - 1;
        for (int B = 0; B < D.length() * chrsz; B += chrsz) {
            C[B >> 5] |= (D.charAt(B / chrsz) & A) << (B % 32);
        }
        return C;
    }
        
    public static String binl2str(int[] C) {
        String D = "";
        int A = (1 << chrsz) - 1;
        for (int B = 0; B < C.length * 32; B += chrsz) {
            D += fromCharCode((C[B >> 5] >>> (B % 32)) & A);
        }
        return D;
    }
    
    public static String fromCharCode(int... codePoints) {
        StringBuilder builder = new StringBuilder(codePoints.length);
        for (int codePoint : codePoints) {
            builder.append(Character.toChars(codePoint));
        }
        return builder.toString();
    }
    
    public static String binl2hex(int[] C) {
        String B = hexcase ? "0123456789ABCDEF" : "0123456789abcdef";
        String str = "";
        for (int n : C) {
            for (int j = 0; j <= 3; j++)
                str = str + B.charAt((n >> (j * 8 + 4)) & 0x0F) + B.charAt((n >> (j * 8)) & 0x0F);
        }
        return str.toUpperCase();
    }
    
    public static String hexchar2bin(String str) throws UnsupportedEncodingException {
        String B = hexcase ? "0123456789ABCDEF" : "0123456789abcdef";
        ByteArrayOutputStream baos = new ByteArrayOutputStream(str.length() / 2);
        for (int i = 0; i < str.length(); i = i + 2) {
            baos.write((B.indexOf(str.charAt(i)) << 4 | B.indexOf(str.charAt(i + 1))));
        }
        return new String(baos.toByteArray(), "ISO-8859-1");
    }
    
    public static String uin2hex(String str) throws UnsupportedEncodingException {
        int maxLength = 16;
        Integer strValue = Integer.parseInt(str);
        String hex = Integer.toString(strValue, 16);
        int len = hex.length();
        for (int i = len; i < maxLength; i++) {
            hex = "0" + hex;
        }
        return hex;
    }
    
//    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
//        String H = hexchar2bin(md5("201314.."));
//        String F = md5(H + hexchar2bin("\\x00\\x00\\x00\\x00\\x03\\x7b\\xab\\x09".replace("\\x", "").toUpperCase()));
//        String C = md5(F + "!PZM");
//        System.out.println(C);
//    }
//    
    
    public static String charset = "UTF-8";
    public static String FUNCTION_PATTERN = "\\'(.+)\\'";

//    public static String getCharset() {
//        return charset;
//    }
    
    public static String getPwd(String salt, String pwd, String verifyCode) throws Exception {
        String C = "";
        try {
            String h1 = hexchar2bin(md5(pwd));
            String F = md5(h1 + hexchar2bin(salt.replace("\\x", "").toUpperCase()));
            C = md5(F + verifyCode.toUpperCase());
        } catch (Exception e) {
            throw new Exception("getPwd error:", e);
        }
        return C;
    }
    
    public static int getGTK(String skey){
        int hash = 5381;
        for(int i = 0, len = skey.length(); i < len; ++i){
            hash += (hash << 5) + skey.charAt(i);
        }
        return hash & 0x7fffffff;
    }
    
    private static char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    public static String byteToHex(byte b) {
        // Returns hex String representation of byte b
        char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
        return new String(array);
    }

    public static String charToHex(char c) {
        // Returns hex String representation of char c
        byte hi = (byte) (c >>> 8);
        byte lo = (byte) (c & 0xff);
        return byteToHex(hi) + byteToHex(lo);
    }
    
    public static String String2Unicode(String str) {
        StringBuffer ostr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Does the char need to be converted to unicode?
            if ((ch >= 0x0020) && (ch <= 0x007e))  {
                ostr.append(ch); 
            } else {
                ostr.append("\\u"); // standard unicode format.
                String hex = Integer.toHexString(str.charAt(i) & 0xFFFF); // Get hex value of the char. 
                for (int j = 0; j < 4 - hex.length(); j++) {
                    // Prepend zeros because unicode requires 4 digits
                    ostr.append("0");
                }
                ostr.append(hex.toLowerCase()); // standard unicode format.
                //ostr.append(hex.toLowerCase(Locale.ENGLISH));
            }
        }
        return (new String(ostr)); //Return the stringbuffer cast as a string.
    }
    
    public static String unicode2String(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");    
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");    
        }
        return str;
    }
    
    public static boolean isBlank(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        return false;
    }

    public static String findPattern(String expression, String content) {
        String s = null;
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(content);
        if (m.find()) {
            s = m.group();
        }
        return s;
    }

    public static boolean exist(String s, String content) {
        Pattern p = Pattern.compile(s);
        Matcher m = p.matcher(content);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String getEncryption(String password, String salt,String vcode){
    	        
    	String h1="";
		try {
			h1 = hexchar2bin(md5(password));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String s2 = md5(h1+salt);
    	String rsaH1 = RsaUtil.rsa_encrypt(h1);
    	
    	String rsaH1Len =Integer.toString(rsaH1.length() / 2, 16) ;
    	String hexVcode = strToBytes(vcode.toUpperCase());
    	return "";
    }
    
    private static String strToBytes(String str){
    	
		String s = "";
		for (char c : str.toCharArray()) {
			s += charToHex(c);
		}
		return s;
    }
    
    public static void main(String[] args) {
		System.out.println(strToBytes("ab34"));
	}
    
    
    private static CloseableHttpClient httpclient = HttpClients.createDefault();
      
    private static CookieStore cookieStore = new BasicCookieStore();
    
    static{
    	cookieStore.addCookie(new BasicClientCookie("_qz_referrer", "qzone.qq.com"));
    }
    
    public static String uikey ="uikey";
    public static String pt_user_id ="pt_user_id";
    public static String pt_local_token ="pt_local_token";
    public static String ptui_identifier ="ptui_identifier";
    public static String confirmuin ="confirmuin";
    public static String ptvfsession ="ptvfsession";
    public static String ptisp ="ptisp";
    public static String pgv_info ="pgv_info";
    public static String pgv_pvid ="pgv_pvid";
    public static String qrsig ="qrsig";
    
    public static byte[] requestGet(String uri) {
    	return requestGet(uri, cookieStore, true);
    }
    
    public static byte[] requestGet(String uri,QzoneUser qzoneUser){
    	return requestGet(uri, qzoneUser.getCookieStore(), true);
    }

    public static byte[] requestGet(String uri,CookieStore localCookieStore, boolean isNeedTakeCookie){
    	HttpGet httpGet = new HttpGet(uri);
    	httpGet.setHeader("User_Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:36.0) Gecko/20100101 Firefox/36.0");
    	httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    	httpGet.setHeader("Accept-lang", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
    	httpGet.setHeader("Accept-encoding", "gzip, deflate");
    	try {
    		HttpContext httpContext = null;
    		if(isNeedTakeCookie){
    			httpContext = new BasicHttpContext();
    			httpContext.setAttribute(HttpClientContext.COOKIE_STORE, localCookieStore);
    		}
			byte[] ret = httpclient.execute(httpGet,new ResponseHandler<byte[]>() {

				@Override
				public byte[] handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
					    HttpEntity entity = response.getEntity();
					    return entity == null ? null : EntityUtils.toByteArray(entity);
					} else {
					    throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
				
			},httpContext);
			
//			for(Cookie ck : localCookieStore.getCookies()){
//				System.out.println(ck);
//			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    }

	public static CookieStore getCookieStore() {
		return cookieStore;
	}
    
}
