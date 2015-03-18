package com.kael.login.qzone.model;

import java.util.Date;

import junit.framework.Assert;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

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
}
