package com.city.oa.rest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.DeptModel;
import com.city.oa.result.Result;
import com.city.oa.service.IDeptService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 取得指定部門的REST API
 */
@WebServlet("/api/area/get.do")
public class DeptGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得传递的爱好编号
		String sNo=request.getParameter("no");
		//创建JSON的Mapper对象
		ObjectMapper mapper = new ObjectMapper();
		//设置响应类型
		response.setContentType("application/json");
		//设置响应字符编码
		response.setCharacterEncoding("UTF-8");
		//取得到客户端的文本流
		PrintWriter out=response.getWriter();
		
		Result<DeptModel> result=new Result<DeptModel>();
		
		try {
			if(sNo!=null&&sNo.trim().length()>0) {
				//调用部門的业务方法
				int no=Integer.parseInt(sNo);
				IDeptService bs=ServiceFactory.createAreaService();
				DeptModel bm=bs.getByNo(no);
				//REST发送JSON给前端
				result.setStatus("Y");
				result.setMessage("取得指定部門成功⎛⎝≥⏝⏝≤⎛⎝");
				result.setModel(bm);
			}
			else {
				result.setStatus("N");
				result.setMessage("增加部門失败 XoX....,失败 XoX....原因:没有传递部門编号");
			}
			
			
		}
		catch(Exception e) {
			result.setStatus("N");
			result.setMessage("增加部門失败 XoX....,失败 XoX....原因:"+e.getLocalizedMessage());
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
