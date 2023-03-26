package com.city.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.dao.IMedicalDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.model.MedicalModel;

public class MedicalDaoImpl implements IMedicalDao {

	@Override
	public void insert(MedicalModel hm) throws Exception {
		String sql="insert into dish (DISNAME,DISPRICE) values(?,?)";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, hm.getName());
		ps.setString(2, hm.getPrice());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public void update(MedicalModel hm) throws Exception {
		String sql="update dish set DISNAME=?,DISPRICE=? where DISID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, hm.getName());
		ps.setString(2, hm.getPrice());
		ps.setInt(3, hm.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public void delete(MedicalModel hm) throws Exception {
		String sql="delete from dish where DISID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, hm.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public List<MedicalModel> selectByAll() throws Exception {
		List<MedicalModel> list=new ArrayList<MedicalModel>();
		String sql="select * from dish";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			MedicalModel hm=new MedicalModel();
			hm.setNo(rs.getInt("DISID"));
			hm.setName(rs.getString("DISNAME"));
			hm.setPrice(rs.getString("DISPRICE"));
			list.add(hm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public List<MedicalModel> selectByAllWithPage(int start, int rows) throws Exception {
		List<MedicalModel> list=new ArrayList<MedicalModel>();
		String sql="select * from dish limit ?,?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();		
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, rows);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			MedicalModel hm=new MedicalModel();
			hm.setNo(rs.getInt("DISID"));
			hm.setName(rs.getString("DISNAME"));
			hm.setPrice(rs.getString("DISPRICE"));
			list.add(hm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public MedicalModel selectByNo(int no) throws Exception {
		MedicalModel hm=null;
		String sql="select * from dish where DISID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			hm=new MedicalModel();
			hm.setNo(rs.getInt("DISID"));
			hm.setName(rs.getString("DISNAME"));
			hm.setPrice(rs.getString("DISPRICE"));
			
		}
		rs.close();
		ps.close();
		cn.close();
		
		return hm;
	}

	@Override
	public int selectCountByAll() throws Exception {
		int count=0;
		String sql="SELECT  NULLIF(COUNT(DISID),0) DCOUNT FROM dish";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt("DCOUNT");
		}
		rs.close();
		ps.close();
		cn.close();
		return count;
	}

}
