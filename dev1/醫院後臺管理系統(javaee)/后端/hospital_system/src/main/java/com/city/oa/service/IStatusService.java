package com.city.oa.service;

import java.util.List;

import com.city.oa.model.StatusModel;

//等級的业务接口
public interface IStatusService {
	//等級
	public void add(StatusModel dm) throws Exception;
	//修改等級
	public void modify(StatusModel dm) throws Exception;
	//删除等級
	public void delete(StatusModel dm) throws Exception;
	//取得所有等級列表
	public List<StatusModel> getListByAll() throws Exception;
	//取得所有等級列表，分页模式
	public List<StatusModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得指定的等級
	public StatusModel getByNo(int no) throws Exception;
	//取得所有等級的个数
	public int getCountByAll() throws Exception;
	//取得所有等級的页数
	public int getPageCountByAll(int rows) throws Exception;
	
	
	
	
}
