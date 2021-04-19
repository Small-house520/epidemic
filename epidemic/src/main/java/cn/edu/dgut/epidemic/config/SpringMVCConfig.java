package cn.edu.dgut.epidemic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;

import cn.edu.dgut.epidemic.util.DateConverter;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

	@Autowired
	private DateConverter dateConverter;

	// 添加视图控制器
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/panel").setViewName("panel");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/unAuth").setViewName("unAuth");

		registry.addViewController("/process/processAdd").setViewName("process/process_add");
		
		
	}

	// 配置视图解析器
	/*
	 * @Override public void configureViewResolvers(ViewResolverRegistry registry) {
	 * //定义了一个内部资源视图解析器(InternalResourceViewResolver) registry.jsp("/WEB-INF/jsp/",
	 * ".jsp"); }
	 */

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(dateConverter);
	}

	// 这里配置静态资源文件的路径导包都是默认的直接导入就可以
	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX
	// + "/static/");
	// }

	/*
	 * @Override public void
	 * configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	 * //启用默认的configureDefaultServletHandling，获取静态资源 configurer.enable(); }
	 */

}
