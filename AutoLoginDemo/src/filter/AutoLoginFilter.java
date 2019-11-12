package filter;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.UserBean;
import util.CookieUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements javax.servlet.Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}


	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {


		try {
			HttpServletRequest request = (HttpServletRequest) req;
			
			//先判断，现在session中还有没有那个userBean.
			UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
			//还有，有效。
			if(userBean != null){
				chain.doFilter(request, response);
			}else{
				//代表session失效了。
				
				//2. 看cookie。
				
				//1. 来请求的时候，先从请求里面取出cookie , 但是cookie有很多的key-value
				Cookie[] cookies = request.getCookies();
				//2. 从一堆的cookie里面找出我们以前给浏览器发的那个cookie
				Cookie cookie = CookieUtil.findCookie(cookies, "auto_login");
				
				//第一次来
				if(cookie  == null){
					chain.doFilter(request, response);
				}else{
					
					//不是第一次。
					
					String value = cookie.getValue();
					String username = value.split("#itheima#")[0];
					String password = value.split("#itheima#")[1];

					//完成登录
					UserBean user = new UserBean();
					user.setUsername(username);
					user.setPassword(password);

					UserDao dao = new UserDaoImpl();
					userBean = dao.login(user);
					
					//使用session存这个值到域中，方便下一次未过期前还可以用。
					request.getSession().setAttribute("userBean", userBean);
					
					chain.doFilter(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			chain.doFilter(req, response);
		}
	}


	@Override
	public void init(javax.servlet.FilterConfig fConfig) throws ServletException {
//		有可能在这里面执行10分钟的耗时
	}

}
