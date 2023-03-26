package com.city.oa.factory;

import com.city.oa.service.IDeptService;
import com.city.oa.service.IEquipmentService;
import com.city.oa.service.IMedicalService;
import com.city.oa.service.IStatusService;
import com.city.oa.service.IManagerService;
import com.city.oa.service.ISystemService;
import com.city.oa.service.impl.DeptServiceImpl;
import com.city.oa.service.impl.EquipmentServiceImpl;
import com.city.oa.service.impl.MedicalServiceImpl;
import com.city.oa.service.impl.StatusServiceImpl;
import com.city.oa.service.impl.ManagerServiceImpl;
import com.city.oa.service.impl.SystemServiceImpl;

//业务工厂类
public class ServiceFactory {
	//等級工作业务接口的对象
	public static IStatusService createWorkService() {
		return new StatusServiceImpl();
	}
	//取得部門爱好的业务接口对象
	public static IDeptService createAreaService() {
		return new DeptServiceImpl();
	}
	//取得雇員的业务接口对象
	public static IManagerService createManagerService() {
		return new ManagerServiceImpl();
	}
	//取得藥物的业务接口对象
	public static IMedicalService createDishService() {
		return  new MedicalServiceImpl();
	}
	//取得設備的业务接口对象
		public static IEquipmentService createClientService() {
			return  new EquipmentServiceImpl();
		}
	//取得系统服务的业务实现类对象
	public static ISystemService createSystemService() {
		return new SystemServiceImpl();
	}
	
	

}
