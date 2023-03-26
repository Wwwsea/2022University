package com.city.oa.dao;

import java.util.List;

import com.city.oa.model.StatusModel;
//等級接口
public interface IStatusDao {
	//插入新等級，执行insert into
	public void insert(StatusModel dm) throws Exception;
	//修改等級
	public void update(StatusModel dm) throws Exception;
	//删除等級
	public void delete(StatusModel dm) throws Exception;
	//取得所有等級列表
	public List<StatusModel> selectByAll() throws Exception;
	//取得所有等級列表，分页
	public List<StatusModel> selectByAllWithPage(int start, int rows) throws Exception;
	public StatusModel selectByNo(int no) throws Exception;
	//取得等級的个数
	public int selectCountByAll() throws Exception;
	

}
