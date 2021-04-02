package cn.edu.dgut.epidemic.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn.edu.dgut.epidemic.util.CustomFormAuthenticationFilter;
import cn.edu.dgut.epidemic.util.CustomRealm;

/**
 * Shiro的配置类
 */
@Configuration
public class ShiroConfig {

	// 创建自定义Realm
	@Bean("customRealm")
	public CustomRealm customRealm() {
		return new CustomRealm();
	}

	// 配置缓存验证器
	// @Bean
	// public CacheManager cacheManager() {
	// return new MemoryConstrainedCacheManager();
	// }

	// 配置记住我Cookie对象参数
	public SimpleCookie rememberMeCookie() {
		// 这个参数是cookie的名称，对应前端的checkbox的name=rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		// cookie生效时间为7天
		simpleCookie.setMaxAge(604800);
		return simpleCookie;
	}

	// 配置Cookie管理对象
	@Bean
	public CookieRememberMeManager rememberMeManager() {
		// rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		return cookieRememberMeManager;
	}

	// 注入自定义过滤器
	@Bean
	public CustomFormAuthenticationFilter MyCustomFilter() {
		return new CustomFormAuthenticationFilter();
	}

	// 配置securityManager安全管理器
	@Bean("securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("customRealm") CustomRealm customRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 关联自定义Realm
		securityManager.setRealm(customRealm);
		// 注入自定义cacheManager
		// securityManager.setCacheManager(cacheManager());
		// 注入记住我管理器
		securityManager.setRememberMeManager(rememberMeManager());
		return securityManager;
	}

	// 创建ShiroFilterFactoryBean
	@Bean("shiroFilterFactoryBean")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		// 创建shiro对象
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 修改被拦截后跳转的登录页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 设置未授权的提示页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
		// 设置验证通过的的页面
		shiroFilterFactoryBean.setSuccessUrl("/home");

		// 添加Shiro内置过滤器
		/**
		 * Shiro内置过滤器，可以实现权限相关的的拦截器 常用的过滤器: anon:无需认证(登录)可以访问 authc:必须认证才可以访问
		 * user:使用rememberMe功能可以直接访问 perms:该资源必须得到资源权限才可以访问 role:该资源必须得到角色权限才可以访问
		 */
		Map<String, Filter> filterMap = new LinkedHashMap<String, Filter>();
		filterMap.put("CustomFormAuthenticationFilter", MyCustomFilter());
		shiroFilterFactoryBean.setFilters(filterMap);

		// 认证顺序是从上往下执行。
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

		// 在这儿配置退出登录地址，不需要专门去写控制器
		map.put("/logout", "logout");

		// map.put("/add","authc");
		// map.put("/update","authc");

		// 不过滤主页，主页可以访问
		map.put("/", "anon");
		map.put("/index", "anon");
		// 放行登录认证逻辑请求
		map.put("/login", "anon");

		// 配置以下页面不需要验证
		map.put("error", "anon");
		map.put("/static/**", "anon");
		map.put("/images/**", "anon");
		map.put("/bootstrap/**", "anon");
		map.put("/css/**", "anon");
		map.put("/echarts/**", "anon");
		map.put("/plugins/**", "anon");
		map.put("/js/**", "anon");
		map.put("/processes/**", "anon");

		// 授权过滤器
		// 注意当前授权拦截后,shiro会自动跳转到未授权页面
		map.put("/add", "perms[user:add]");
		map.put("/update", "perms[user:update]");

		// /*代表所有的一级请求路径会被拦截,/**代表所有的请求路径都会被拦截
		map.put("/**", "authc");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

		return shiroFilterFactoryBean;
	}

	// 配置shiro的生命周期
	// @Bean
	// public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	// return new LifecycleBeanPostProcessor();
	// }

	// 配置ShiroDialect,用于thymeleaf和shiro标签配合使用
	@Bean
	public ShiroDialect getShiroDialect() {
		return new ShiroDialect();
	}

}
