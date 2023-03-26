package com.city.oa.rest.controller;

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
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 取得指定等級的REST API
 
 */
@WebServlet("/api/work/detail.do")
public class StatusDetailController extends HttpServlet {
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
			Reader reader=request.getReader();
			StatusModel dm01=mapper.readValue(reader, StatusModel.class);
			StatusModel dm=ds.getByNo(dm01.getNo());
			if(dm==null) {
				result.setStatus("N");
				result.setMessage("此等級不存在");
			}
			else {
				result.setStatus("Y");
				result.setMessage("取得指定等級成功⎛⎝≥⏝⏝≤⎛⎝");
				result.setModel(dm); //设置取得的等級对象
			}
			
			
		}
		catch(Exception e) {
			result.setStatus("ERROR");
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
