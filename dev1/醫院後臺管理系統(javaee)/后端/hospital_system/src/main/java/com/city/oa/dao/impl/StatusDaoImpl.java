package com.city.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.dao.IStatusDao;
import com.city.oa.factory.ConnectionFactory;
import com.city.oa.model.StatusModel;
//等級的DAO实现类型
public class StatusDaoImpl implements IStatusDao {

	@Override
	public void insert(StatusModel dm) throws Exception {
		String sql="insert into work (WORKCODE,WORKNAME) values(?,?)";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, dm.getCode());
		ps.setString(2, dm.getName());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void update(StatusModel dm) throws Exception {
		String sql="update work set WORKCODE=?,WORKNAME=? where WORKNO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, dm.getCode());
		ps.setString(2, dm.getName());
		ps.setInt(3, dm.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();

	}

	@Override
	public void delete(StatusModel dm) throws Exception {
		String sql="delete from work where WORKNO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, dm.getNo());
		ps.executeUpdate();
		ps.close();
		cn.close();

	}

	@Override
	public List<StatusModel> selectByAll() throws Exception {
		List<StatusModel> list=new ArrayList<StatusModel>();
		String sql="select * from work";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			StatusModel dm=new StatusModel();
			dm.setNo(rs.getInt("WORKNO"));
			dm.setCode(rs.getString("WORKCODE"));
			dm.setName(rs.getString("WORKNAME"));
			list.add(dm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}
	@Override
	public List<StatusModel> selectByAllWithPage(int start, int rows) throws Exception {
		List<StatusModel> list=new ArrayList<StatusModel>();
		String sql="select * from work limit ?,?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();		
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, rows);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			StatusModel dm=new StatusModel();
			dm.setNo(rs.getInt("WORKNO"));
			dm.setCode(rs.getString("WORKCODE"));
			dm.setName(rs.getString("WORKNAME"));
			list.add(dm);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}


	@Override
	public StatusModel selectByNo(int no) throws Exception {
		StatusModel dm=null;
		String sql="select * from work where WORKNO=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			dm=new StatusModel();
			dm.setNo(rs.getInt("WORKNO"));
			dm.setCode(rs.getString("WORKCODE"));
			dm.setName(rs.getString("WORKNAME"));
			
		}
		rs.close();
		ps.close();
		cn.close();
		
		return dm;
	}
	//取得等級的个数
	@Override
	public int selectCountByAll() throws Exception {
		int count=0;
		String sql="SELECT  NULLIF(COUNT(WORKNO),0) WCOUNT FROM work";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt("WCOUNT");
		}
		rs.close();
		ps.close();
		cn.close();
		return count;
	}


}
