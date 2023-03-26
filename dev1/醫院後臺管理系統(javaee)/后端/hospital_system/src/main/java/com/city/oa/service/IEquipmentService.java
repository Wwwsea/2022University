package com.city.oa.service;


import java.util.List;

import com.city.oa.model.EquipmentModel;


public interface IEquipmentService {
	//增加設備
			public void add(EquipmentModel cm) throws Exception;
			//修改設備
			public void modify(EquipmentModel cm) throws Exception;
		public void delete(EquipmentModel cm) throws Exception;
			//取得所有設備列表
			public List<EquipmentModel> getListByAll() throws Exception;
			//取得所有設備列表，分页模式
			public List<EquipmentModel> getListByAllWithPage(int rows, int page) throws Exception;
			//取得指定的設備
			public EquipmentModel getByNo(int no) throws Exception;
			//取得所有設備的个数
			public int getCountByAll() throws Exception;
			//取得所有設備的页数
			public int getPageCountByAll(int rows) throws Exception;
}
