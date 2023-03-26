package com.city.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.StatusModel;
import com.city.oa.result.Result;
import com.city.oa.service.IStatusService;
import com.city.oa.service.impl.StatusServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 */
@WebServlet("/test/test03.do")
public class Test03Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			//取得请求对象的reader
			Reader reader=request.getReader();
			//读取reader中的字符串，转换为Model对象
			StatusModel dm=mapper.readValue(reader, StatusModel.class);
			//调用部门的业务方法
			IStatusService ds=new StatusServiceImpl();
			ds.modify(dm);
	
			
			//REST发送JSON给前端
			result.setStatus("Y");
			result.setMessage("增加部门成功⎛⎝≥⏝⏝≤⎛⎝");
			
		}
		catch(Exception e) {
			result.setStatus("N");
			result.setMessage("增加部门失败 XoX.... XoX....,失败 XoX....原因:"+e.getLocalizedMessage());
		}
		//将Result对象转换为JSON
		String resultjson=mapper.writeValueAsString(result);
		out.println(resultjson);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			//取得请求对象的reader
			String sno=request.getParameter("no");
			int no=Integer.parseInt(sno);
			//读取reader中的字符串，转换为Model对象
			StatusModel dm=new StatusModel();
			dm.setNo(no);
			//调用部门的业务方法
			IStatusService ds=ServiceFactory.createWorkService();
			ds.delete(dm);
			//REST发送JSON给前端
			result.setStatus("Y");
			result.setMessage("删除部门成功⎛⎝≥⏝⏝≤⎛⎝");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			result.setStatus("N");
			result.setMessage("删除部门失败 XoX....,失败 XoX....原因:"+e.getLocalizedMessage());
		}
		//将Result对象转换为JSON
		String resultjson=mapper.writeValueAsString(result);
		out.println(resultjson);
		out.flush();
		out.close();
		
	}

}
