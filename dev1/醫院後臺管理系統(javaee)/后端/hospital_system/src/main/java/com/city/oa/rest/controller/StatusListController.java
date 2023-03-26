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
 * 取得等級所有列表的REST API
 */
@WebServlet("/api/work/list.do")
public class StatusListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			List<StatusModel> list=ds.getListByAll();
			result.setStatus("Y");
			result.setMessage("取得等級列表成功⎛⎝≥⏝⏝≤⎛⎝");
			result.setList(list);
			
		}
		catch(Exception e) {
			result.setStatus("N");
			result.setMessage("取得等級列表失败 XoX....,原因:"+e.getLocalizedMessage());
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
