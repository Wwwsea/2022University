package com.city.oa.service;

import java.util.List;

import com.city.oa.model.MedicalModel;

public interface IMedicalService {
	//增加藥物
		public void add(MedicalModel hm) throws Exception;
		//修改藥物
		public void modify(MedicalModel hm) throws Exception;
		//删除藥物
		public void delete(MedicalModel hm) throws Exception;
		//取得所有藥物列表
		public List<MedicalModel> getListByAll() throws Exception;
		//取得所有藥物列表，分页模式
		public List<MedicalModel> getListByAllWithPage(int rows, int page) throws Exception;
		//取得指定的藥物
		public MedicalModel getByNo(int no) throws Exception;
		//取得所有藥物的个数
		public int getCountByAll() throws Exception;
		//取得所有藥物的页数
		public int getPageCountByAll(int rows) throws Exception;
}
