package com.city.oa.rest.controller;

import java.io.*;
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
import com.city.oa.util.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 雇員修改REST API
 */
@WebServlet("/api/manager/modify.do")
@MultipartConfig
public class ManagerModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			//取得等級的业务对象
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
			//取得雇員的地址数据
			String city=request.getParameter("address.city");
			String address=request.getParameter("address.address");
			String postcode=request.getParameter("address.postcode");
			//取得雇員的爱好
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

//				OutputStream outphoto=response.getOutputStream();
//				InputStream in= new ByteArrayInputStream(em.getPhoto());
//				int data=0;
//				while((data=in.read())!=-1) {
//					outphoto.write(data);//直接輸出圖片？data？
//				}

				byte[] photos = photo.getInputStream().readAllBytes();
				String photoFileName=photo.getName();
//				String photoFileName=photo.getSubmittedFileName();
//				byte[] photos= inputStream.readAllBytes(); //取得图片的字节数组

				em.setPhoto(photos);
				em.setPhotoFileName(photoFileName);
//				em.setPhoto(null);
//				em.setPhotoFileName(null);
				em.setPhotoType(photoType);
			}

			//构建雇員的地址对象
			AddressModel am=new AddressModel();
			am.setId(id);
			am.setAddress(address);
			am.setCity(city);
			am.setPostcode(postcode);
			
			em.setWork(dm); //将等級与雇員对象关联
			//取得雇員的业务实现类对象
			IManagerService es=ServiceFactory.createManagerService();
			//调用雇員的修改业务方法
			es.modify(em);
			//修改雇員的地址
			es.modifyAddress(am);
			if(sareas!=null) {
				int[] areas=Tools.getFormString(sareas);
				es.addAreas(id, areas); //重新增加雇員的的部門，将原有的部門删除
				
			}
			
			//REST发送JSON给前端
			result.setStatus("Y");
			result.setMessage("修改雇員成功⎛⎝≥⏝⏝≤⎛⎝");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			result.setStatus("N");
			result.setMessage("修改雇員失败 XoX....,失败 XoX....原因:"+e.getLocalizedMessage());
		}
		//将Result对象转换为JSON
		String resultjson=mapper.writeValueAsString(result);
		out.println(resultjson);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
