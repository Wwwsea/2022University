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
 * 取得指定藥物的REST API
 
 */
@WebServlet("/api/dish/detail.do")
public class MedicalDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMedicalService ds=ServiceFactory.createDishService();
		
		//创建JSON的Mapper对象
		ObjectMapper mapper = new ObjectMapper();
		//设置响应类型
		response.setContentType("application/json");
		//设置响应字符编码
		response.setCharacterEncoding("UTF-8");
		//取得到客户端的文本流
		PrintWriter out=response.getWriter();
		
		Result<MedicalModel> result=new Result<MedicalModel>();
		try {
			Reader reader=request.getReader();
			MedicalModel hm01=mapper.readValue(reader, MedicalModel.class);
			MedicalModel hm=ds.getByNo(hm01.getNo());
			if(hm==null) {
				result.setStatus("N");
				result.setMessage("此藥物不存在");
			}
			else {
				result.setStatus("Y");
				result.setMessage("取得指定藥物成功⎛⎝≥⏝⏝≤⎛⎝");
				result.setModel(hm); //设置取得的藥物对象
			}
			
			
		}
		catch(Exception e) {
			result.setStatus("ERROR");
			result.setMessage("取得藥物列表失败 XoX....,原因:"+e.getLocalizedMessage());
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
