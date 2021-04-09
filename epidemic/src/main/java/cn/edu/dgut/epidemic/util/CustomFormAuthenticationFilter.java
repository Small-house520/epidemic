package cn.edu.dgut.epidemic.util;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 进行认证前的一些过滤器
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	// 自定义记住我过滤器
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		// 过滤器完成了登陆条件的过滤，要么通过权限认证登陆成功，要么通过记住我登陆成功
		if (!subject.isAuthenticated() && subject.isRemembered()) {
			if (subject.getSession().getAttribute(Constants.GLOBLE_USER_SESSION) == null
					&& subject.getPrincipal() != null) {
				subject.getSession().setAttribute(Constants.GLOBLE_USER_SESSION, subject.getPrincipal());
			}
		}

		return subject.isAuthenticated() || subject.isRemembered();
	}

	/*
	 * 用于验证码验证的 Shiro 拦截器在用于身份认证的拦截器之前运行；
	 * 
	 * 但是如果验证码验证拦截器失败了，就不需要进行身份认证拦截器流程了；
	 * 
	 * 所以需要修改如下FormAuthenticationFilter 身份认证拦截器，
	 * 
	 * 当验证码验证失败时不再走身份认证拦截器。
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 从session获取正确验证码
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		// 取出session的验证码（正确的验证码）
		String validateCode = (String) session.getAttribute("checkCode_session");

		// 取出页面的验证码
		String checkCode = req.getParameter("checkCode");
		// 输入的验证和session中的验证进行对比
		if (checkCode != null && validateCode != null && !validateCode.equals(checkCode)) {
			// 如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
			request.setAttribute("shiroLoginFailure", "randomCodeError");
			// 拒绝访问，不再校验账号和密码
			return true;
		}

		return super.onAccessDenied(request, response);
	}

	// 验证成功后，设置重定向的位置
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		WebUtils.getAndClearSavedRequest(request);
		WebUtils.redirectToSavedRequest(request, response, "/home/home");
		return false;
	}
}
