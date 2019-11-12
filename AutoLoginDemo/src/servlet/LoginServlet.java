package servlet;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String autoLogin = request.getParameter("auto_login");
			UserBean user = new UserBean();
			user.setUsername(userName);
			user.setPassword(password);
			
			UserDao dao = new UserDaoImpl();
			UserBean userBean = dao.login(user);
			
			if(userBean != null){
				
				//页面提交上来的时候，是否选择了自动登录
				if("on".equals(autoLogin)){
					
					//发送cookie给客户端
					
					Cookie cookie = new Cookie("auto_login", userName+"#分割符#"+password);
					cookie.setMaxAge(60*60*24*7);//7天有效期
					cookie.setPath("/AutoLoginDemo");
					//cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
					
				}
				
				
				//成功了，进入首页
				request.getSession().setAttribute("userBean", userBean);
				response.sendRedirect("index.jsp");
			}else{
				//不成功...
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
