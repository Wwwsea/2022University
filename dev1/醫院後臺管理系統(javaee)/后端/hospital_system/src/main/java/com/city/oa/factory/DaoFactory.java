package com.city.oa.factory;

import com.city.oa.dao.IDeptDao;
import com.city.oa.dao.IEquipmentDao;
import com.city.oa.dao.IMedicalDao;
import com.city.oa.dao.IStatusDao;
import com.city.oa.dao.IManagerDao;
import com.city.oa.dao.impl.DeptDaoImpl;
import com.city.oa.dao.impl.EquipmentDaoImpl;
import com.city.oa.dao.impl.MedicalDaoImpl;
import com.city.oa.dao.impl.StatusDaoImpl;
import com.city.oa.dao.impl.ManagerDaoImpl;

//DAO工厂类
public class DaoFactory {
	//创建等級DAO接口对象
	public static IStatusDao createWorkDao() {
		return new StatusDaoImpl();
	}
	//创建部門DAO接口对象
	public static IDeptDao createAreaDao() {
		return new DeptDaoImpl();
		
	}
	//创建雇員DAO接口对象
	public static IManagerDao createManagerDao() {
		return new ManagerDaoImpl();
		
	}
	//创建藥物DAO接口对象
	public static IMedicalDao createDishDao() {
		return new MedicalDaoImpl();
	}
	//创建設備DAO接口对象
	public static IEquipmentDao createClientDao() {
		return new EquipmentDaoImpl();
	}
	
	

}
