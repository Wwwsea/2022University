package com.city.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.oa.dao.IManagerDao;

import com.city.oa.factory.ConnectionFactory;

import com.city.oa.model.AddressModel;
import com.city.oa.model.DeptModel;
import com.city.oa.model.StatusModel;
import com.city.oa.model.ManagerModel;

public class ManagerDaoImpl implements IManagerDao {

	@Override
	public void insert(ManagerModel em) throws Exception {
		String sql="insert into manager (MANID,MANPassword,MANNAME,MANSEX,AGE,SALARY,BirthDAY,JOINDATE,WORKNO) values(?,?,?,?,?,?,?,?,?)";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, em.getId());
		ps.setString(2, em.getPassword());
		ps.setString(3, em.getName());
		ps.setString(4, em.getSex());
		ps.setInt(5,em.getAge());
		ps.setDouble(6, em.getSalary());
		ps.setDate(7,new java.sql.Date(em.getBirthday().getTime()));
		ps.setDate(8,new java.sql.Date(em.getBirthday().getTime()));
		ps.setInt(9, em.getWork().getNo()); //设置雇員的等級
		
		ps.executeUpdate();
		ps.close();
		cn.close();
	}
	@Override
	public void insertWithPhoto(ManagerModel em) throws Exception {
		String sql="insert into manager (MANID,MANPassword,MANNAME,MANSEX,AGE,SALARY,BirthDAY,JOINDATE,Photo,PhotoFileName,PhotoContentType,WORKNO) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, em.getId());
		ps.setString(2, em.getPassword());
		ps.setString(3, em.getName());
		ps.setString(4, em.getSex());
		ps.setInt(5,em.getAge());
		ps.setDouble(6, em.getSalary());
		ps.setDate(7,new java.sql.Date(em.getBirthday().getTime()));
		ps.setDate(8,new java.sql.Date(em.getBirthday().getTime()));
		ps.setBytes(9, em.getPhoto());
		ps.setString(10,em.getPhotoFileName());
		ps.setString(11, em.getPhotoType());
		ps.setInt(12, em.getWork().getNo()); //设置雇員的等級
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}


	@Override
	public void update(ManagerModel em) throws Exception {
		String sql="update manager set MANPassword=?,MANNAME=?,MANSEX=?,AGE=?,SALARY=?,BirthDAY=?,JOINDATE=?,WORKNO=? where MANID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setString(1, em.getPassword());
		ps.setString(2, em.getName());
		ps.setString(3, em.getSex());
		ps.setInt(4,em.getAge());
		ps.setDouble(5, em.getSalary());
		ps.setDate(6, new java.sql.Date(em.getBirthday().getTime()));
		ps.setDate(7, new java.sql.Date(em.getJoinDate().getTime()));
		ps.setInt(8,em.getWork().getNo()); //更新雇員的等級
		ps.setString(9, em.getId());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}
	@Override
	public void updateWithPhoto(ManagerModel em) throws Exception {
		String sql="update manager set MANPassword=?,MANNAME=?,MANSEX=?,AGE=?,SALARY=?,BirthDAY=?,JOINDATE=?,Photo=?,PhotoFileName=?,PhotoContentType=?,WORKNO=? where MANID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setString(1, em.getPassword());
		ps.setString(2, em.getName());
		ps.setString(3, em.getSex());
		ps.setInt(4,em.getAge());
		ps.setDouble(5, em.getSalary());
		ps.setDate(6, new java.sql.Date(em.getBirthday().getTime()));
		ps.setDate(7, new java.sql.Date(em.getJoinDate().getTime()));
		ps.setBytes(8, em.getPhoto());
		ps.setString(9,em.getPhotoFileName());
		ps.setString(10, em.getPhotoType());
		ps.setInt(11,em.getWork().getNo()); //更新雇員的等級
		ps.setString(12, em.getId());	
		ps.executeUpdate();
		ps.close();
		cn.close();
		
		
	}
	//删除雇員
	@Override
	public void delete(ManagerModel em) throws Exception {
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		String sql="delete from manager where MANID=?";
		String sqlforemployeebehave="delete from managerarea where MANID=?";
		//删除雇員关联的部門
		PreparedStatement ps01=cn.prepareStatement(sqlforemployeebehave);
		ps01.setString(1, em.getId());
		ps01.executeUpdate();
		ps01.close();
		//删除指定的雇員
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, em.getId());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}
	@Override
	public ManagerModel selectById(String id) throws Exception {
		ManagerModel em=null;
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		String sql="select * from manager where MANID=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			em=new ManagerModel();
			em.setId(rs.getString("MANID"));
			em.setPassword(rs.getString("MANPassword"));
			em.setName(rs.getString("MANNAME"));
			em.setSex(rs.getString("MANSEX"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			em.setBirthday(rs.getDate("BirthDAY"));
			em.setJoinDate(rs.getDate("JOINDATE"));
			em.setPhoto(rs.getBytes("Photo"));
			em.setPhotoFileName(rs.getString("PhotoFileName"));		
			em.setPhotoType(rs.getString("PhotoContentType"));
			
		}
		rs.close();
		ps.close();
		cn.close();
		return em;
	}

	
	@Override
	public List<ManagerModel> selectListByAll() throws Exception {
		List<ManagerModel> list=new ArrayList<ManagerModel>();
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		
		String sql="select * from manager";
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			ManagerModel em=new ManagerModel();
			em.setId(rs.getString("MANID"));
			em.setName(rs.getString("MANNAME"));
			em.setSex(rs.getString("MANSEX"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			em.setBirthday(rs.getDate("BirthDAY"));
			em.setJoinDate(rs.getDate("JOINDATE"));
			em.setPhotoType(rs.getString("PhotoContentType"));
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}
	
	//分页方式取得雇員列表
	public List<ManagerModel> selectListByAllWithPage(int rows,int page) throws Exception{
		
		List<ManagerModel> list=new ArrayList<ManagerModel>();
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		
		String sql="select * from manager limit ?,?";		
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, rows*(page-1));
		ps.setInt(2, rows);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			ManagerModel em=new ManagerModel();
			em.setId(rs.getString("MANID"));
			em.setName(rs.getString("MANNAME"));
			em.setSex(rs.getString("MANSEX"));
			em.setAge(rs.getInt("AGE"));
			em.setSalary(rs.getDouble("SALARY"));
			//em.setSalary(rs.getDouble("SALARY"));
			em.setBirthday(rs.getDate("BirthDAY"));
			em.setJoinDate(rs.getDate("JOINDATE"));
			em.setPhotoType(rs.getString("PhotoContentType"));
			//取得雇員关联的等級
			StatusModel dm=this.selectWorkById(em.getId());
			em.setWork(dm);
			list.add(em);
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
		
	}
	//取得雇員个数
	public int selectCountByAll() throws Exception{
		int count=0;
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		String sql="select IFNULL(count(MANID),0) MANCOUNT from manager";
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			count=rs.getInt("MANCOUNT");
		}
		rs.close();
		ps.close();
		cn.close();
		return count;
	}

	//取得指定雇員的等級对象
	@Override
	public StatusModel selectWorkById(String id) throws Exception {
		StatusModel dm=null;
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		String sql="select * from work where WORKNO=(select WORKNO from manager where MANID=?)";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
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
	//=============================================================================
	//雇員的部門管理
	//=============================================================================
	//为雇員增加部門
	public void insertAreas(String id,int[] areas) throws Exception{
		String sqlfordelete="delete from managerarea where MANID=?";
		String sql="insert into managerarea (MANID,ANO) values (?,?)";		
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		//先删除雇員的现有部門
		PreparedStatement ps00=cn.prepareStatement(sqlfordelete);
		ps00.setString(1, id);
		ps00.executeUpdate();
		ps00.close();
		//再增加雇員的新部門 
		PreparedStatement ps=cn.prepareStatement(sql);
		for(int bno:areas) {
			ps.setString(1, id);
			ps.setInt(2, bno);
			ps.executeUpdate();
		}
		ps.close();
		cn.close();
	}
	//删除指定雇員的部門
	public void deleteAreas(String id) throws Exception{
		String sqlfordelete="delete from managerarea where MANID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		//删除雇員的现有部門
		PreparedStatement ps=cn.prepareStatement(sqlfordelete);
		ps.setString(1, id);
		ps.executeUpdate();
		ps.close();
		
		cn.close();
	}
	//取得指定雇員的部門列表
	@Override
	public List<DeptModel> selectAreaListById(String id) throws Exception {
		List<DeptModel> list=new ArrayList<DeptModel>();
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		String sql="select * from area where ANO in (select ANO from managerarea where MANID=?)";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, id);
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
	public void insertAddress(AddressModel am) throws Exception {
		String sql="insert into manageraddress (MANID,CITY,ADDRESS,POSTCODE) values(?,?,?,?)";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, am.getId());
		ps.setString(2, am.getCity());
		ps.setString(3, am.getAddress());
		ps.setString(4, am.getPostcode());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}
	@Override
	public void updateAddress(AddressModel am) throws Exception {
		String sql="update manageraddress set CITY=?,ADDRESS=?,POSTCODE=? where MANID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, am.getCity());
		ps.setString(2, am.getAddress());
		ps.setString(3, am.getPostcode());
		ps.setString(4, am.getId());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}
	@Override
	public void deleteAddress(AddressModel am) throws Exception {
		String sql="delete from manageraddress where MANID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, am.getId());
		ps.executeUpdate();
		ps.close();
		cn.close();
		
	}
	@Override
	public AddressModel selectAddressById(String id) throws Exception {
		AddressModel am=null;
		String sql="select * from manageraddress where MANID=?";
		Connection cn=ConnectionFactory.getConenctionFromHarikeCP();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			am=new AddressModel();
			am.setId(id);
			am.setCity(rs.getString("CITY"));
			am.setAddress(rs.getString("ADDRESS"));
			am.setPostcode(rs.getString("POSTCODE"));
		}
		ps.close();
		cn.close();
		
		return am;
	}
	
}
