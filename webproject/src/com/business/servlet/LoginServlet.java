package com.business.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.business.entity.Admin;
import com.business.service.AdminService;
import com.sun.tools.internal.ws.processor.model.Request;
import com.sun.tools.internal.ws.processor.model.Response;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; Charset=UTF-8");
		
		String name = request.getParameter("userName");
		String password = request.getParameter("password");			
		
		AdminService as = new AdminService();
		Admin admin = as.findAdminByLogin(new Admin(name,password));
		//System.out.println(name+" "+password);
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if(admin != null){
			//把登陆的用户设置到session里
			//pageContext.setAttribute("pageValue", "页面上的值");
			session.setAttribute("loginName", admin.getAdmin_name());
			//application.setAttribute("appValue", "服务器上的值");
			
			// 设置时间格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	 
			// 获取当前时间
			String cutTime = sdf.format(new Date());
	 
			/**
			 * 先把所有的cookie放入数组
			 */
	 
			Cookie[] cookies = request.getCookies();
	 
			String lastTime = null;
			/**
			 * 查询数组是否有lastTime的cookie
			 */
	 
			if (cookies != null) {
				for (Cookie cookie : cookies) {
	 
					// 如果有上次的登陆痕迹
					if (cookie.getName().equals("lastTime")) {
	 					
						session.setAttribute("loginTime", cookie.getValue());
						// 把时间显示在浏览器
						lastTime = cookie.getValue();
						//response.getWriter().write("欢迎回来! 您上次登录是在:" + lastTime);
						// 更新cookie
						cookie.setValue(cutTime);
						// 设置过期时间一个月
						cookie.setMaxAge(1 * 30 * 24 * 60 * 60);
						// 把更新的数据发送到浏览器储存起来
						response.addCookie(cookie);
						break;
					}
	 
				}
			}
	 
			if (cookies == null || lastTime == null) {
	 
				// 没有cookie 创建对象
				// 显示当前时间
	 			session.setAttribute("loginTime", cutTime);
				//response.getWriter().write("你好,欢迎登录 这是您的第一次" + cutTime);
				// 把数据存储到cookie中
				Cookie cookie = new Cookie("lastTime", cutTime);
				// 设置过期时间
				cookie.setMaxAge(1 * 30 * 60 * 24 * 60);
				// 存储到服务器
				response.addCookie(cookie);
			}


			//生成一个Cookie("loginTime" String)
			//Cookie cookie = new Cookie("loginTime",TimeHelper.getTime(t));
			
			out.write("<script>alert('恭喜，登录成功！');location.href='main.jsp'</script>");
		}else{
			out.write("<script>alert('对不起，用户名或密码错误！');location.href='login.jsp'</script>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
