package com.city.oa.service.impl;

import java.util.List;

import com.city.oa.dao.IManagerDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.AddressModel;
import com.city.oa.model.DeptModel;
import com.city.oa.model.StatusModel;
import com.city.oa.model.ManagerModel;
import com.city.oa.service.IManagerService;
//雇員的业务实现类
public class ManagerServiceImpl implements IManagerService {
	//通过DAO工厂取得DAO接口的实现类对象
	private IManagerDao edo=DaoFactory.createManagerDao();
	
	@Override
	public void add(ManagerModel em) throws Exception {
		if(em.getPhotoType()!=null) {
			edo.insertWithPhoto(em);
		}
		else {
			edo.insert(em);
		}
		
		
	}

	@Override
	public void modify(ManagerModel em) throws Exception {
		if(em.getPhotoType()!=null) {
			edo.updateWithPhoto(em);
		}
		else {
			edo.update(em);
		}
		
	}

	@Override
	public void delete(ManagerModel em) throws Exception {
		AddressModel am=new AddressModel();
		am.setId(em.getId());
		edo.deleteAreas(em.getId()); //删除雇員的管理部門
		edo.deleteAddress(am); //删除雇員的地址信息 
		edo.delete(em);
		
	}
	
	@Override
	public ManagerModel selectById(String id) throws Exception {
		ManagerModel em=edo.selectById(id);
		em.setWork(edo.selectWorkById(id));
		em.setAreas(edo.selectAreaListById(id));
		return em;  
	}

	@Override
	public List<ManagerModel> selectListByAll() throws Exception {
		
		return edo.selectListByAll();
	}
	//分页方式取得雇員列表
	public List<ManagerModel> getByAllWithPage(int rows,int page) throws Exception{
		return edo.selectListByAllWithPage(rows, page);
	}
	//取得雇員个数
	public int getCountByAll() throws Exception{
		return edo.selectCountByAll();
	}
	//取得雇員列表的页数
	public int getPageCountByAll(int rows) throws Exception{
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public boolean validate(String id, String password) throws Exception {
		boolean result=false;
		ManagerModel em=edo.selectById(id);
		if(em!=null&&em.getPassword().equals(password)) {
			result=true;
		}		
		return result;
	}

	@Override
	public void changePassword(String id, String password) throws Exception {
		ManagerModel em=edo.selectById(id);
		em.setPassword(password);
		edo.update(em);
		
	}

	@Override
	public StatusModel getWorkById(String id) throws Exception {
		
		return edo.selectWorkById(id);
	}
	//======================================================================
	//雇員的部門管理
	//=======================================================================
	//给雇員增加部門（多个)
	public void addAreas(String id,int[] areas) throws Exception{
		edo.insertAreas(id, areas);
	}
	//取得指定雇員关联的部門集合

	@Override
	public List<DeptModel> getAreasById(String id) throws Exception {
		return edo.selectAreaListById(id);
	}
	//==========================================================================
	// 雇員的地址管理
	//=========================================================================
	@Override
	public void addAddress(AddressModel am) throws Exception {
		edo.insertAddress(am);		
	}

	@Override
	public void modifyAddress(AddressModel am) throws Exception {
		edo.updateAddress(am);		
	}

	@Override
	public void deleteAddress(AddressModel am) throws Exception {
		edo.deleteAddress(am);		
	}

	@Override
	public AddressModel getAddressById(String id) throws Exception {
		return edo.selectAddressById(id);
	}


}
