package com.city.oa.rest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.AddressModel;
import com.city.oa.model.StatusModel;
import com.city.oa.model.ManagerModel;
import com.city.oa.result.Result;
import com.city.oa.service.IStatusService;
import com.city.oa.service.IManagerService;
import com.city.oa.service.impl.ManagerServiceImpl;
import com.city.oa.util.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 雇員增加REST API
 */
@WebServlet("/api/manager/add.do")
//启用内置的文件上传解析机制
@MultipartConfig
public class ManagerAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//创建JSON的Mapper对象
		ObjectMapper mapper = new ObjectMapper();
		//设置响应类型
		response.setContentType("application/json");
		//设置响应字符编码
		response.setCharacterEncoding("UTF-8");
		//取得到客户端的文本流
		PrintWriter out=response.getWriter();
		
		Result<String> result=new Result<String>();
		
		try {
			IStatusService ds=ServiceFactory.createWorkService();
			//取得前端发送的数据
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			String sage=request.getParameter("age");
			String ssalary=request.getParameter("salary");
			String sDepartmentNo=request.getParameter("department.no"); //取得等級编号
			String sBirthday=request.getParameter("birthday");
			String sJoinDate=request.getParameter("joinDate");
			Part photo=request.getPart("photo"); //取得上传图片文件
			String city=request.getParameter("address.city");
			String address=request.getParameter("address.address");
			String postcode=request.getParameter("address.postcode");
			//取得雇員的部門
			String sareas=request.getParameter("manareas");
			
			//类型转换
			int departmentNo=Integer.parseInt(sDepartmentNo);
			StatusModel dm=ds.getByNo(departmentNo); //取得指定等級对象
			int age=Integer.parseInt(sage);
			double salary=Double.parseDouble(ssalary);
			
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date birthday=df.parse(sBirthday);
			Date joinDate=df.parse(sJoinDate);
			
			ManagerModel em=new ManagerModel();			
			em.setId(id);
			em.setPassword(password);
			em.setName(name);
			em.setSex(sex);
			em.setAge(age);
			em.setSalary(salary);
			em.setBirthday(birthday);
			em.setJoinDate(joinDate);
			if(photo!=null) {
				String photoType=photo.getContentType(); //取得图片类型
//				String photoFileName=photo.getSubmittedFileName();
//				byte[] photos=photo.getInputStream().readAllBytes(); //取得图片的字节数组

				byte[] photos = photo.getInputStream().readAllBytes();
				String photoFileName=photo.getName();

				em.setPhoto(photos);
//				em.setPhotoFileName(null);
//				em.setPhoto(null);
				em.setPhotoFileName(photoFileName);
				em.setPhotoType(photoType);
			}
			//构建雇員的地址对象
			AddressModel am=new AddressModel();
			am.setId(id);
			am.setAddress(address);
			am.setCity(city);
			am.setPostcode(postcode);
			
			em.setWork(dm); //将等級与雇員对象关联
						
			IManagerService es=new ManagerServiceImpl();
			//增加雇員
			es.add(em);
			//增加雇員的地址
			es.addAddress(am);
			//给雇員增加爱好
			if(sareas!=null) {
				es.addAreas(id, Tools.getFormString(sareas));
			}
			
			//REST发送JSON给前端
			result.setStatus("Y");
			result.setMessage("增加雇員成功⎛⎝≥⏝⏝≤⎛⎝");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			result.setStatus("N");
			result.setMessage("增加雇員失败 XoX....,失败 XoX....原因:"+e.getLocalizedMessage());
		}
		//将Result对象转换为JSON
		String resultjson=mapper.writeValueAsString(result);
		out.println(resultjson);
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
