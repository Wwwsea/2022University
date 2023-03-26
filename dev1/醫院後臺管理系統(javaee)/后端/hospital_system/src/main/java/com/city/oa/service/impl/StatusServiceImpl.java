package com.city.oa.service.impl;

import java.util.List;

import com.city.oa.dao.IStatusDao;
import com.city.oa.factory.DaoFactory;
import com.city.oa.model.StatusModel;
import com.city.oa.service.IStatusService;
//等級的业务实现类
public class StatusServiceImpl implements IStatusService {
	//通过DAO工厂取得DAO接口的实现类对象
	private IStatusDao ddao=DaoFactory.createWorkDao();
	
	@Override
	public void add(StatusModel dm) throws Exception {
		ddao.insert(dm);
	}

	@Override
	public void modify(StatusModel dm) throws Exception {
		ddao.update(dm);

	}

	@Override
	public void delete(StatusModel dm) throws Exception {
		ddao.delete(dm);

	}

	@Override
	public List<StatusModel> getListByAll() throws Exception {
		
		return ddao.selectByAll();
	}
	@Override
	public List<StatusModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return ddao.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public StatusModel getByNo(int no) throws Exception {
		return ddao.selectByNo(no);
	}

	

	@Override
	public int getCountByAll() throws Exception {
		
		return ddao.selectCountByAll();
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
