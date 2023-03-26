package com.city.oa.service.impl;

import java.util.List;

import com.city.oa.dao.IDeptDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.DeptModel;
import com.city.oa.service.IDeptService;
//部門的业务实现类
public class DeptServiceImpl implements IDeptService {
	//通过DAO工厂取得DAO接口的实现类对象
	private IDeptDao bdao=DaoFactory.createAreaDao();
	
	@Override
	public void add(DeptModel bm) throws Exception {
		bdao.insert(bm);
	}
	@Override
	public void modify(DeptModel bm) throws Exception {
		bdao.update(bm);
	}

	@Override
	public void delete(DeptModel bm) throws Exception {
		bdao.delete(bm);
	}

	@Override
	public List<DeptModel> getListByAll() throws Exception {
		return bdao.selectListByAll();
	}
	@Override
	public List<DeptModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return bdao.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public DeptModel getByNo(int no) throws Exception {
		
		return bdao.selectByNo(no);
	}

	@Override
	public int getCountByAll() throws Exception {
		
		return bdao.selectCountByAll();
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
