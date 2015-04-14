package com.kael.login.qzone.model;

import java.util.Date;

import junit.framework.Assert;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

import com.kael.login.qzone.util.Utils;

public class QzoneUser {

	private String qq;
	private String passwd;
	private CookieStore cookieStore;
	private String openId;
	
	private transient String ptvfsession;

	public QzoneUser() {
		cookieStore = new BasicCookieStore();
		BasicClientCookie cookie = new BasicClientCookie("_qz_referrer", "qzone.qq.com");
//		Calendar c = Calendar.getInstance();
//		c.setTimeInMillis(System.currentTimeMillis());
//		c.add(Calendar.YEAR, 1);
//		cookie.setExpiryDate(c.getTime());
		cookieStore.addCookie(cookie);
	}

	public QzoneUser(String qq, String pwd) {
		this();
		Assert.assertNull("qq is null", qq);
		Assert.assertNull("pwd is null", pwd);
		this.qq = qq;
		this.passwd = pwd;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public CookieStore getCookieStore() {
		return cookieStore;
	}

	public void setCookieStore(CookieStore cookieStore) {
		this.cookieStore = cookieStore;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPtvfsession() {
		if(ptvfsession == null)
		{
			for(Cookie cookie : cookieStore.getCookies()){
				if("ptvfsession".equals(cookie.getName()) && cookie.isExpired(new Date())){
					ptvfsession = cookie.getValue();
					break;
				}
			}
		}
		return ptvfsession;
	}
	
	public String toUrl(PTUI ptui,String vcode,String uin) throws Exception{
		StringBuilder builder = new StringBuilder();
		builder.append("http://ptlogin2.qq.com/login?u=").append(qq)
		       .append("&p=").append(Utils.getPwd(uin == null ? Utils.uin2hex(qq) : uin, passwd.trim(), vcode))
		       .append("&verifycode=").append(vcode)
		       .append("&low_login=0")
		       .append("&pt_verifysession_v1=").append(getPtvfsession())
               .append("&js_ver=").append(ptui.getPtui_version())
		       .append("&aid=549000912&u1=http%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dizone&h=1&ptredirect=0&ptlang=2052&daid=5&from_ui=1&dumy=&low_login_enable=0&regmaster=&fp=loginerroralert&action=2-21-1385452444158&mibao_css=&t=1&g=1&js_ver=")
		       .append(ptui).append("&js_type=1&login_sig=").append(ptui.getLogin_sig())
		       .append("&pt_rsa=0&pt_qzone_sig=1");
		return builder.toString();
	}
}
