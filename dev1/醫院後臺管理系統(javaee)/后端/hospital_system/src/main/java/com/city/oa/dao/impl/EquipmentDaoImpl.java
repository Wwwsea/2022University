package com.city.oa.dao.impl;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.city.oa.factory.ConnectionFactory;

import com.city.oa.dao.IEquipmentDao;
import com.city.oa.model.EquipmentModel;

public class EquipmentDaoImpl implements IEquipmentDao {

	@Override
	public void insert(EquipmentModel cm) throws Exception {
		String sql="insert into client (CLNAME,CLTEL) values(?,?)";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, cm.getName());
		ps.setString(2, cm.getTel());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public void update(EquipmentModel cm) throws Exception {
		String sql="update client set CLNAME=?,CLTEL=? where CLNO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, cm.getName());
		ps.setString(2, cm.getTel());
		ps.setInt(3, cm.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public void delete(EquipmentModel cm) throws Exception {
		String sql="delete from client where CLNO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, cm.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}

	@Override
	public List<EquipmentModel> selectByAll() throws Exception {
		List<EquipmentModel> list=new ArrayList<EquipmentModel>();
		String sql="select * from client";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			EquipmentModel cm=new EquipmentModel();
			cm.setNo(rs.getInt("CLNO"));
			cm.setName(rs.getString("CLNAME"));
			cm.setTel(rs.getString("CLTEL"));
			list.add(cm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public List<EquipmentModel> selectByAllWithPage(int start, int rows) throws Exception {
		List<EquipmentModel> list=new ArrayList<EquipmentModel>();
		String sql="select * from client limit ?,?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();		
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, rows);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			EquipmentModel cm=new EquipmentModel();
			cm.setNo(rs.getInt("CLNO"));
			cm.setName(rs.getString("CLNAME"));
			cm.setTel(rs.getString("CLTEL"));
			list.add(cm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public EquipmentModel selectByNo(int no) throws Exception {
		EquipmentModel cm=null;
		String sql="select * from client where CLNO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			cm=new EquipmentModel();
			cm.setNo(rs.getInt("CLNO"));
			cm.setName(rs.getString("CLNAME"));
			cm.setTel(rs.getString("CLTEL"));
			
		}
		rs.close();
		ps.close();
		cn.close();
		
		return cm;
	}

	@Override
	public int selectCountByAll() throws Exception {
		int count=0;
		String sql="SELECT  NULLIF(COUNT(CLNO),0) CCOUNT FROM client";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt("CCOUNT");
		}
		rs.close();
		ps.close();
		cn.close();
		return count;
	}

}
