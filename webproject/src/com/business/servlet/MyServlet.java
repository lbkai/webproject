package com.business.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("---destory-----");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("------初始化了！-------");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("----service----");
		ServletOutputStream out = response.getOutputStream();
		out.print("<html>");
		out.print("<head>");
		out.print("<tittle>");
		out.print("</tittle>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h3><font color = 'red'>java,hello<font><h3>");
		out.print("</body>");
		out.print("</html>");
	}

}
