package com.lc.web.util;

import com.lc.web.login.entity.user;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jsp拦截器
 *
 * @author Administrator
 * @date 2018年3月7日
 */
// 此注解表示不需要再web.xml文件里面配置，可以直接过滤所有jsp文件
@WebFilter("*.jsp")
public class InterceptorJspFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String uri = httpRequest.getRequestURI();

		user user = (user) httpRequest.getSession().getAttribute("user");
		if (user != null) {
			chain.doFilter(httpRequest, httpResponse);
		} else if (uri.contains("/page/login/login.html")) {
			chain.doFilter(httpRequest, httpResponse);
		} else {
			try {
				ThisAssertion.getThisRuntimeException("用户非法登录，已打回登录页面");
			} catch (Exception e) {
				System.out.print(httpRequest.getContextPath());
				e.printStackTrace();
				httpResponse.sendRedirect(httpRequest.getContextPath()
						+ "/page/login/login.html");
			}

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
