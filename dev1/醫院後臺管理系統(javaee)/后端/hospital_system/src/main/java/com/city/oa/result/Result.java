package com.city.oa.result;

import java.util.List;

import lombok.Data;

//REST API标准的返回结果
//所有的REST Controller都使用此类的对象生成JSON并返回给前端Vue
@Data
public class Result<T> {
	private String status=null; //状态， OK：正常，ERROR：异常
	private String message=null; //消息
	private T model=null; //单个Model类对象结果
	private List<T> list=null; //查询返回多个结果
	private int count=0; //对象的个数
	private int pageCount=0; //页数
	private int rows=10; //每个页面显示10个
	private int page=1; //第几页

}
