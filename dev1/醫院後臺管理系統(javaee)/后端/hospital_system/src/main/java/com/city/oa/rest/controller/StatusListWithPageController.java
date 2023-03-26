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
import com.city.oa.model.StatusModel;
import com.city.oa.result.Result;
import com.city.oa.service.IStatusService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 等級列表分页模式的REST API
 */
@WebServlet("/api/work/list/page.do")
public class StatusListWithPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String srows=request.getParameter("rows");
		String sPage=request.getParameter("page");
		int page=1;
		int rows=10;
		if(srows!=null) {
			rows=Integer.parseInt(srows);			
		}
		if(sPage!=null) {
			page=Integer.parseInt(sPage);
		}
		IStatusService ds=ServiceFactory.createWorkService();
		//创建JSON的Mapper对象
		ObjectMapper mapper = new ObjectMapper();
		//设置响应类型
		response.setContentType("application/json");
		//设置响应字符编码
		response.setCharacterEncoding("UTF-8");
		//取得到客户端的文本流
		PrintWriter out=response.getWriter();
		Result<StatusModel> result=new Result<StatusModel>();
		try {
			List<StatusModel> list=ds.getListByAllWithPage(rows, page);
			int count=ds.getCountByAll();
			int pageCount=ds.getPageCountByAll(rows);
			result.setList(list);
			result.setCount(count);
			result.setPageCount(pageCount);
			result.setRows(rows);
			result.setPage(page);
			result.setStatus("Y");
			result.setMessage("取得等級列表(分页模式)成功⎛⎝≥⏝⏝≤⎛⎝");
		}
		catch(Exception e) {
			result.setStatus("N");
			result.setMessage("取得等級列表(分页模式)失败 XoX....,原因:"+e.getLocalizedMessage());
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
