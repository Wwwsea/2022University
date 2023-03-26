package com.city.oa.rest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.ManagerModel;
import com.city.oa.result.Result;
import com.city.oa.service.IManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 雇員登录验证REST API
 */
@WebServlet("/api/manager/validate.do")
public class UserLoginController extends HttpServlet {
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
		
		Result<ManagerModel> result=new Result<ManagerModel>();
		
		try {
			//取得请求对象的reader
			Reader reader=request.getReader();
			//读取reader中的字符串，转换为Model对象
			ManagerModel em=mapper.readValue(reader, ManagerModel.class);
			//取得雇員的业务实现类对象
			IManagerService es=ServiceFactory.createManagerService();
			//调用雇員的的验证账号和密码的业务方法
			if(es.validate(em.getId(),em.getPassword())) {
				HttpSession session=request.getSession();
				ManagerModel emm=es.selectById(em.getId());
				session.setAttribute("user",emm );
				result.setStatus("Y");
				result.setModel(emm);
				result.setMessage("雇員验证成功⎛⎝≥⏝⏝≤⎛⎝");
			}
			else {
				
				result.setStatus("N");
				result.setMessage("雇員验证失败 XoX....");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			result.setStatus("N");
			result.setMessage("验证用户失败 XoX....,原因:"+e.getLocalizedMessage());
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
