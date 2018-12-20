package com.lc.web.util;

import com.lc.web.login.entity.user;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class IntercproHanderController implements HandlerInterceptor {

	private List<String> excludedUrls;

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object arg2) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		user user = (com.lc.web.login.entity.user) request.getSession().getAttribute("user");
		String uri = request.getRequestURI();
		for (String string : excludedUrls) {
			if (uri.contains(string)) {
				return true;
			}

		}
		if (user == null) {
			try {
				ThisAssertion.getThisRuntimeException("用户非法登录已经打回登录页面");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath()
						+ "/page/login/login.html");
			}

		}
		return true;
	}

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

}
