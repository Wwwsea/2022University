package com.city.oa.mail;

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

public class SendMail {

	public static void main(String[] args) {
		
		
		MailAuthenticator auth=new MailAuthenticator("2667657399@qq.com","krgncjumefqkebfa");
		
		try {
		
		Properties p=new Properties();
		p.put("mail.smtp.host", "smtp.qq.com");
		p.put("mail.smtp.port", "25");
		p.put("mail.smtp.auth", "true");  
		p.setProperty("mail.transport.protocol", "smtp");  
		//建立与Mail Server的连接
		Session session=Session.getInstance(p,auth);
		//2.创建邮件Mail
		Message mail=new MimeMessage(session);
		//3.设定发件人：2736106716
		Address sender=new InternetAddress("2667657399@qq.com");
		mail.setFrom(sender);
		//4.设定收件人：
		Address receiver=new InternetAddress("wy2667657399@126.com");
	
		mail.setRecipient(Message.RecipientType.TO, receiver);
	
		
		//5.设定标题
		mail.setSubject("Test Subject测试");

		//6.设置邮件的内容
		//(1)设定纯文本内容
		//mail.setText("Mail Content测试内容");
		//(2)设定HTML页面内容：
		mail.setContent("<h1>账号激活</h1><a href='http://localhost:8080/web05/login.jsp'>点击激活</a>", "text/html;charset=UTF-8");
		//7.设定日期
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		mail.setSentDate(new Date());

		//8.发送邮件：
		Transport.send(mail);
		System.out.println("OK");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
