package com.city.oa.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//雇員Model类
@Data
public class ManagerModel {
	
	private String id=null;
	private String password=null;
	private String name=null;
	private String sex=null;
	private int age=0;
	private double salary=0;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday=null;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date joinDate=null;
	
	@JsonIgnore
	private byte[] photo=null; //雇員照片
	private String photoType=null; //图片类型
	private String photoFileName=null; //图片文件名
	
	//雇員的等級工作
	private StatusModel work=null;
	//雇員的部門
	private List<DeptModel> areas=null;
	//雇員的地址
	private AddressModel address=null;

}
