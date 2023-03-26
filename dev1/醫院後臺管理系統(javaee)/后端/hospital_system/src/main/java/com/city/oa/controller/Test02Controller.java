package com.city.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.city.oa.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Test02Controller
 */
@WebServlet("/test/test02.do")
@MultipartConfig
public class Test02Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		Part photo=request.getPart("photo");
		System.out.println("文件上传方式接收---------------------");
		System.out.println("ID="+id);
		System.out.println("Name="+name);
//		System.out.println("接收文件名="+photo.getSubmittedFileName());
		
		ObjectMapper mapper = new ObjectMapper();
		//设置响应类型
		response.setContentType("application/json");
		//设置响应字符编码
		response.setCharacterEncoding("UTF-8");
		//取得到客户端的文本流
		PrintWriter out=response.getWriter();
		
		Result<String> result=new Result<String>();
		result.setStatus("Y");
		result.setMessage("测试02OK");
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
