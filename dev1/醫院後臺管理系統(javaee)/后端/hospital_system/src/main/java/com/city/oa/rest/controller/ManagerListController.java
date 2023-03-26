package com.city.oa.rest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.ManagerModel;
import com.city.oa.result.Result;
import com.city.oa.service.IManagerService;
import com.city.oa.service.impl.ManagerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 取得雇員列表REST API
 */
@WebServlet("/api/manager/list.do")
public class ManagerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//通过Service工厂类取得雇員业务接口的实现类对象
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
		int page=1;
		int rows=5;
		try {
			String srows=request.getParameter("rows");
			String spage=request.getParameter("page");
			if(srows!=null&&srows.trim().length()>0) {
				
				rows=Integer.parseInt(srows);
			}
			if(spage!=null&&spage.trim().length()>0) {
				
				page=Integer.parseInt(spage);
			}

			
			result.setList(es.getByAllWithPage(rows, page));
			result.setCount(es.getCountByAll());
			result.setPageCount(es.getPageCountByAll(rows));
			result.setStatus("OK");
			result.setMessage("取得雇員列表成功⎛⎝≥⏝⏝≤⎛⎝");
		}
		catch(Exception e) {
			
			result.setStatus("ERROR");
			result.setMessage("取得雇員列表失败 XoX....");
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
