package com.city.oa.rest.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.EquipmentModel;
import com.city.oa.result.Result;
import com.city.oa.service.IEquipmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 取得指定的設備对象
 */
@WebServlet("/api/client/get.do")
public class EquiptmentGetController extends HttpServlet {
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
		Result<EquipmentModel> result=new Result<EquipmentModel>();
		
		try {
			String sno=request.getParameter("no");
			if(sno!=null&&sno.trim().length()>0) {
				int no=Integer.parseInt(sno);
				IEquipmentService cs=ServiceFactory.createClientService();
				EquipmentModel cm=cs.getByNo(no);
				result.setModel(cm);
				result.setStatus("Y");
				result.setMessage("取得指定設備成功⎛⎝≥⏝⏝≤⎛⎝");
			}
			else {
				result.setStatus("N");
				result.setMessage("没有传送設備编号");
			}
		}
		catch(Exception e) {
			result.setStatus("ERROR");
			result.setMessage("取得指定設備失败 XoX....,原因:"+e.getMessage());
			
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

