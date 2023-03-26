package com.city.oa.dao;


import java.util.List;

import com.city.oa.model.EquipmentModel;


public interface IEquipmentDao {
	//插入新設備行insert into
		public void insert(EquipmentModel cm) throws Exception;
		//修改設備
		public void update(EquipmentModel cm) throws Exception;
		//删除設備
		public void delete(EquipmentModel cm) throws Exception;
		//取得所有設備列表
		public List<EquipmentModel> selectByAll() throws Exception;
		//取得所有設備列表，分页
		public List<EquipmentModel> selectByAllWithPage(int start, int rows) throws Exception;
		public EquipmentModel selectByNo(int no) throws Exception;
		//取得設備的个数
		public int selectCountByAll() throws Exception;
}
