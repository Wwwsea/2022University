package com.city.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.dao.IDeptDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.model.DeptModel;

//部門的DAO实现类
public class DeptDaoImpl implements IDeptDao {

	@Override
	public void insert(DeptModel bm) throws Exception {
		String sql="insert into area (ANAME) values(?)";
		
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, bm.getName());
		ps.executeUpdate();
		ps.close();
		cn.close();

	}

	@Override
	public void update(DeptModel bm) throws Exception {
		String sql="update area set ANAME=? where ANO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, bm.getName());
		ps.setInt(2, bm.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();

	}

	@Override
	public void delete(DeptModel bm) throws Exception {
		String sql="delete from area  where ANO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, bm.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();

	}
	//取得所有部門列表
	@Override
	public List<DeptModel> selectListByAll() throws Exception {
		List<DeptModel> list=new ArrayList<DeptModel>();
		String sql="select * from area";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			DeptModel bm=new DeptModel();
			bm.setNo(rs.getInt("ANO"));
			bm.setName(rs.getString("ANAME"));
			list.add(bm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}
	@Override
	public List<DeptModel> selectListByAllWithPage(int start, int rows) throws Exception {
		List<DeptModel> list=new ArrayList<DeptModel>();
		String sql="select * from area limit ?,?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();		
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1,start);
		ps.setInt(2, rows);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			DeptModel bm=new DeptModel();
			bm.setNo(rs.getInt("ANO"));
			bm.setName(rs.getString("ANAME"));
			list.add(bm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public DeptModel selectByNo(int no) throws Exception {
		DeptModel bm=null;
		String sql="select * from area where ANO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			bm=new DeptModel();
			bm.setNo(rs.getInt("ANO"));
			bm.setName(rs.getString("ANAME"));
		}
		rs.close();
		ps.close();
		cn.close();
		return bm;
	}

	@Override
	public int selectCountByAll() throws Exception {
		int count=0;
		String sql="SELECT  NULLIF(COUNT(ANO),0) ACOUNT FROM area";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt("ACOUNT");
		}
		rs.close();
		ps.close();
		cn.close();
		return count;
	}

	

}
