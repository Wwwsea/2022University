package com.city.oa.rest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.AddressModel;
import com.city.oa.model.DeptModel;
import com.city.oa.model.StatusModel;
import com.city.oa.model.ManagerModel;
import com.city.oa.result.Result;
import com.city.oa.service.IManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 取得指定雇員的REST API
 */
@WebServlet("/api/manager/get.do")
public class ManagerGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		//创建员工业务对象
		IManagerService es=ServiceFactory.createManagerService();
		//创建JSON的Mapper对象
		ObjectMapper mapper = new ObjectMapper();
		//设置响应类型
		response.setContentType("application/json");
		//设置响应字符编码
		response.setCharacterEncoding("UTF-8");
		//取得到客户端的文本流
		PrintWriter out=response.getWriter();
		//创建返回结果对象
		Result<ManagerModel> result=new Result<ManagerModel>();
		try {
			if(id!=null&&id.trim().length()>0) {
				ManagerModel em=es.selectById(id);
				StatusModel dm=es.getWorkById(id);
				List<DeptModel> list=es.getAreasById(id);
				AddressModel am=es.getAddressById(id);
				if(em!=null) {
					em.setWork(dm);
					em.setAreas(list);
					em.setAddress(am);
					result.setModel(em);
					result.setStatus("Y");
					result.setMessage("取得指定雇員的对象成功⎛⎝≥⏝⏝≤⎛⎝");
				}
				else {
					result.setStatus("N");
					result.setMessage("没有取得指定雇員的对象");
				}
				
			}
			else {
				result.setStatus("N");
				result.setMessage("没有给定雇員的账号");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			result.setStatus("N");
			result.setMessage("取得指定雇員的对象异常。异常原因:"+e.getLocalizedMessage());
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
