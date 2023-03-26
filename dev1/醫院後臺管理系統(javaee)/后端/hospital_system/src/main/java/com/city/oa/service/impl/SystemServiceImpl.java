package com.city.oa.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.city.oa.mail.MailAuthenticator;
import com.city.oa.service.ISystemService;
//系统服务接口的业务实现类
public class SystemServiceImpl implements ISystemService {

	@Override
	public void sendMail(String to, String title, String content) throws Exception {
		
		//注意:新浪邮箱使用授权码，不是密码
		//MailAuthenticator auth=new MailAuthenticator("lvhaidong9001@sina.com","授权码");
		MailAuthenticator auth=new MailAuthenticator("2667657399@qq.com","krgncjumefqkebfa");
		
		
		Properties p=new  Properties();
		p.put("mail.smtp.host", "smtp.qq.com");
		p.put("mail.smtp.port", "25");
		p.put("mail.smtp.auth", "true");  
		p.setProperty("mail.transport.protocol", "smtp");  
		//建立与Mail Server的连接
		Session session=Session.getInstance(p,auth);
		//2.创建邮件Mail
		Message mail=new MimeMessage(session);
		//3.设定发件人：
		Address sender=new InternetAddress("2667657399@qq.com");
		mail.setFrom(sender);
		//4.设定收件人：
		//设置收件人地址
		Address receiver=new InternetAddress(to);
		//设置收件人
		mail.setRecipient(Message.RecipientType.TO, receiver);
		//mail.setRecipient(Message.RecipientType.CC, receiverCC);
		//mail.setRecipient(Message.RecipientType.BCC, receiverBCC);
		
		//5.设定标题
		mail.setSubject(title);

		//6.设置邮件的内容
		//(1)设定纯文本内容
		//mail.setText("Mail COntent测试内容");
		//(2)设定HTML页面内容：
		mail.setContent("<h1>"+content+"</h1>", "text/html;charset=UTF-8");
		//7.设定日期
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		//mail.setSentDate(df.parse("2020-09-12"));
		mail.setSentDate(new Date());
		//8.发送邮件：
		Transport.send(mail);		

	}

}
