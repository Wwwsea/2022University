package com.city.oa.service;

import java.util.List;

import com.city.oa.model.DeptModel;

//部門的业务接口
public interface IDeptService {
	//增加部門
	public void add(DeptModel bm) throws Exception;
	//修改部門
	public void modify(DeptModel bm) throws Exception;
	//删除部門
	public void delete(DeptModel bm) throws Exception;
	//取得所有部門列表
	public List<DeptModel> getListByAll() throws Exception;
	//取得所有部門列表,分页模式
	public List<DeptModel> getListByAllWithPage(int rows, int page) throws Exception;
	
	//取得指定的部門
	public DeptModel getByNo(int no) throws Exception;
	//取得部門的个数
	public int getCountByAll() throws Exception;
	//取得部門的页数
	public int getPageCountByAll(int rows) throws Exception;
	

}
