package com.city.oa.dao;

import java.util.List;

import com.city.oa.model.AddressModel;
import com.city.oa.model.DeptModel;
import com.city.oa.model.StatusModel;
import com.city.oa.model.ManagerModel;
//雇員的DAO层接口
public interface IManagerDao {
	
	public void insert(ManagerModel em) throws Exception;
	public void insertWithPhoto(ManagerModel em) throws Exception;
	public void update(ManagerModel em) throws Exception;
	public void updateWithPhoto(ManagerModel em) throws Exception;
	public void delete(ManagerModel em) throws Exception;
	public ManagerModel selectById(String id) throws Exception;
	public List<ManagerModel> selectListByAll() throws Exception;
	//分页方式取得雇員列表
	public List<ManagerModel> selectListByAllWithPage(int rows,int page) throws Exception;
	//取得雇員个数
	public int selectCountByAll() throws Exception;
	//取得指定雇員的等級
	public StatusModel selectWorkById(String id) throws Exception;
	//=============================================================================
	//雇員的部門管理
	//=============================================================================
	//为雇員增加部門
	public void insertAreas(String id,int[] areas) throws Exception;
	//删除指定雇員的部門
	public void deleteAreas(String id) throws Exception;
	//取得指定雇員的部門列表
	public List<DeptModel> selectAreaListById(String id) throws Exception;
	//================================================================================
	//雇員的地址类
	//================================================================================
	//增加地址
	public void insertAddress(AddressModel am) throws Exception;
	//修改地址
	public void updateAddress(AddressModel am) throws Exception;
	//删除地址
	public void deleteAddress(AddressModel am) throws Exception;
	//取得指定雇員的地址
	public AddressModel selectAddressById(String id) throws Exception;
	
}
