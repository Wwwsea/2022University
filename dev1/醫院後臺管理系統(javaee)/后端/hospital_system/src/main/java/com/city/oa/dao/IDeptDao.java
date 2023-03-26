package com.city.oa.dao;

import java.util.List;

import com.city.oa.model.DeptModel;

//部門DAO接口
public interface IDeptDao {
	//增加部門
	public void insert(DeptModel bm) throws Exception;
	//修改部門
	public void update(DeptModel bm) throws Exception;
	//删除部門
	public void delete(DeptModel bm) throws Exception;
	//取得所有部門列表
	public List<DeptModel> selectListByAll() throws Exception;
	//取得所有部門列表,分页模式
	public List<DeptModel> selectListByAllWithPage(int start, int rows) throws Exception;
	//取得指定的部門
	public DeptModel selectByNo(int no) throws Exception;
	//取得部門的个数
	public int selectCountByAll() throws Exception;
	

}
