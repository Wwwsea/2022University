package com.city.oa.service.impl;

import java.util.List;


import com.city.oa.model.EquipmentModel;
import com.city.oa.service.IEquipmentService;
import com.city.oa.dao.IEquipmentDao;
import com.city.oa.factory.DaoFactory;

public class EquipmentServiceImpl implements IEquipmentService {

	private IEquipmentDao cdao=DaoFactory.createClientDao();
	
	@Override
	public void add(EquipmentModel cm) throws Exception {
		cdao.insert(cm);
		
	}

	@Override
	public void modify(EquipmentModel cm) throws Exception {
		cdao.update(cm);
		
	}

	@Override
	public void delete(EquipmentModel cm) throws Exception {
		cdao.delete(cm);
		
	}

	@Override
	public List<EquipmentModel> getListByAll() throws Exception {
		
		return cdao.selectByAll();
	}

	@Override
	public List<EquipmentModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return cdao.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public EquipmentModel getByNo(int no) throws Exception {
	
		return cdao.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return cdao.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
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

}
