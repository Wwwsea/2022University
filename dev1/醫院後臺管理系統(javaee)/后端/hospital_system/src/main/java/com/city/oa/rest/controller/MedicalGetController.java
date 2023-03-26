package com.city.oa.rest.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.MedicalModel;
import com.city.oa.result.Result;
import com.city.oa.service.IMedicalService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 取得指定的藥物对象
 */
@WebServlet("/api/dish/get.do")
public class MedicalGetController extends HttpServlet {
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
		//创建返回结果对象
		Result<MedicalModel> result=new Result<MedicalModel>();
		
		try {
			String sno=request.getParameter("no");
			if(sno!=null&&sno.trim().length()>0) {
				int no=Integer.parseInt(sno);
				IMedicalService hs=ServiceFactory.createDishService();
				MedicalModel hm=hs.getByNo(no);
				result.setModel(hm);
				result.setStatus("Y");
				result.setMessage("取得指定藥物成功⎛⎝≥⏝⏝≤⎛⎝");
			}
			else {
				result.setStatus("N");
				result.setMessage("没有传送藥物编号");
			}
		}
		catch(Exception e) {
			result.setStatus("ERROR");
			result.setMessage("取得指定藥物失败 XoX....,原因:"+e.getMessage());
			
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
