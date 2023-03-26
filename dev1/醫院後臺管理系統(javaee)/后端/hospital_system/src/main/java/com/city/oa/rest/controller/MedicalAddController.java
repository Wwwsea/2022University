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
import com.city.oa.model.MedicalModel;
import com.city.oa.result.Result;
import com.city.oa.service.IMedicalService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 增加的REST API
 * 接收藥物的JSON数据。
 */
@WebServlet("/api/dish/add.do")
public class MedicalAddController extends HttpServlet {
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
			//取得请求对象的reader
			Reader reader=request.getReader();
			//读取reader中的字符串，转换为Model对象
			MedicalModel hm=mapper.readValue(reader, MedicalModel.class);
			//取得藥物业务接口实现类的对象
			IMedicalService hs=ServiceFactory.createDishService();
			//调用藥物的业务方法
			hs.add(hm);
	
			
			//REST发送JSON给前端
			result.setStatus("Y");
			result.setMessage("增加藥物成功⎛⎝≥⏝⏝≤⎛⎝");
			
		}
		catch(Exception e) {
			result.setStatus("N");
			result.setMessage("增加藥物失败 XoX....,失败 XoX....原因:"+e.getLocalizedMessage());
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
