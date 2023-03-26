package com.city.oa.rest.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.factory.ServiceFactory;
import com.city.oa.model.ManagerModel;
import com.city.oa.service.IManagerService;

/**
 * 取得雇員的照片的Controller，不是REST API
 * 直接返回二进制响应，即雇員的照片
 */
@WebServlet("/api/manager/photo.do")
public class ManagerPhotoGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		if(id!=null) {
			IManagerService es=ServiceFactory.createManagerService();
			try {
				ManagerModel em=es.selectById(id);
				if(em!=null) {
					response.setContentType(em.getPhotoType());
					ServletOutputStream out=response.getOutputStream();
					out.write(em.getPhoto());//顯示照片
					out.close();
					
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
