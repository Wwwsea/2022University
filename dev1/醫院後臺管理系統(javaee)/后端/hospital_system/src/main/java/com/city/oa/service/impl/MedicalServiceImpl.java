package com.city.oa.service.impl;

import java.util.List;

import com.city.oa.dao.IMedicalDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.MedicalModel;
import com.city.oa.service.IMedicalService;

public class MedicalServiceImpl implements IMedicalService {
	private IMedicalDao hdao=DaoFactory.createDishDao();
	
	
	@Override
	public void add(MedicalModel hm) throws Exception {
		hdao.insert(hm);
		
	}

	@Override
	public void modify(MedicalModel hm) throws Exception {
		hdao.update(hm);
		
	}

	@Override
	public void delete(MedicalModel hm) throws Exception {
		hdao.delete(hm);
		
	}

	@Override
	public List<MedicalModel> getListByAll() throws Exception {
		
		return hdao.selectByAll();
	}

	@Override
	public List<MedicalModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return hdao.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public MedicalModel getByNo(int no) throws Exception {
		
		return hdao.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return hdao.selectCountByAll();
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
