package com.city.oa.service;
//系统服务业务接口
public interface ISystemService {
	//发送电子邮件方法
	public void sendMail(String to,String title,String context) throws Exception;

}
