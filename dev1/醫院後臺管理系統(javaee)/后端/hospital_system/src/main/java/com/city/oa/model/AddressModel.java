package com.city.oa.model;

import lombok.Data;

//雇員的地址Mode类
@Data
public class AddressModel {
	//雇員ID
	private String id=null;
	private String address=null; //地址
	private String city=null; //城市
	private String postcode=null; //邮政编码
	
}
