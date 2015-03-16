package com.kael.login.qzone;

import com.alibaba.fastjson.JSON;
import com.kael.login.qzone.model.PTUI;
import com.kael.login.qzone.util.Utils;

public class AppStrTest {

	public static void main(String[] args) {
		String url= "http://ui.ptlogin2.qq.com/cgi-bin/login?daid=5&pt_qzone_sig=1&hide_title_bar=1&low_login=0&qlogin_auto_login=1&no_verifyimg=1&link_target=blank&appid=549000912&style=12&target=self&s_url=http%3A//qzs.qq.com/qzone/v5/loginsucc.html?para=izone&pt_qr_app=%CA%D6%BB%FAQQ%BF%D5%BC%E4&pt_qr_link=http%3A//z.qzone.com/download.html&self_regurl=http%3A//qzs.qq.com/qzone/v6/reg/index.html&pt_qr_help_link=http%3A//z.qzone.com/download.html";
		String str = new String(Utils.requestGet(url));
		str = Utils.findPattern("pt.ptui\\=\\{(.+)}", str);
		System.out.println(str);
		str = str.substring(0,str.indexOf(";"));
		System.out.println(str);
		str = str.replace("pt.ptui=", "").replace("encodeURIComponent(", "").replace(")", "");
		//str = str.substring(str.indexOf("=") + 1);
		System.out.println(str);
		PTUI ptui = JSON.parseObject(str, PTUI.class);
		System.out.println(ptui);
		
	}
}
