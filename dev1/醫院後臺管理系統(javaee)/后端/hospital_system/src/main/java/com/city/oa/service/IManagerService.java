package com.city.oa.service;

import java.util.List;

import com.city.oa.model.AddressModel;
import com.city.oa.model.DeptModel;
import com.city.oa.model.StatusModel;
import com.city.oa.model.ManagerModel;

//雇員业务接口
public interface IManagerService {

	public void add(ManagerModel em) throws Exception;
	public void modify(ManagerModel em) throws Exception;
	public void delete(ManagerModel em) throws Exception;
	//登录验证
	public boolean validate(String id,String password) throws Exception;
	//修改密码
	public void changePassword(String id,String password) throws Exception;
	
	public ManagerModel selectById(String id) throws Exception;
	public List<ManagerModel> selectListByAll() throws Exception;
	
	//分页方式取得雇員列表
	public List<ManagerModel> getByAllWithPage(int rows,int page) throws Exception;
	//取得雇員个数
	public int getCountByAll() throws Exception;
	//取得雇員列表的页数
	public int getPageCountByAll(int rows) throws Exception;
	
	//取得指定雇員的等級
	public StatusModel getWorkById(String id) throws Exception;
	//======================================================================
	//雇員的部門管理
	//=======================================================================
	//给雇員增加部門（多个)
	public void addAreas(String id,int[] areas) throws Exception;
	//取得指定雇員关联的部門集合
	public List<DeptModel> getAreasById(String id) throws Exception;
	//================================================================================
	//雇員的地址类
	//================================================================================
	//增加地址
	public void addAddress(AddressModel am) throws Exception;
	//修改地址
	public void modifyAddress(AddressModel am) throws Exception;
	//删除地址
	public void deleteAddress(AddressModel am) throws Exception;
	//取得指定雇員的地址
	public AddressModel getAddressById(String id) throws Exception;
	
}
