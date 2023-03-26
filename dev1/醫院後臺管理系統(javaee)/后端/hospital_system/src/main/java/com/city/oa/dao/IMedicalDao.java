package com.city.oa.dao;

import java.util.List;

import com.city.oa.model.MedicalModel;


public interface IMedicalDao {
	//插入新藥物，执行insert into
	public void insert(MedicalModel hm) throws Exception;
	//修改藥物
	public void update(MedicalModel hm) throws Exception;
	//删除藥物
	public void delete(MedicalModel hm) throws Exception;
	//取得所有藥物列表
	public List<MedicalModel> selectByAll() throws Exception;
	//取得所有藥物列表，分页
	public List<MedicalModel> selectByAllWithPage(int start, int rows) throws Exception;
	public MedicalModel selectByNo(int no) throws Exception;
	//取得藥物的个数
	public int selectCountByAll() throws Exception;
}
