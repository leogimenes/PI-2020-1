package projeto.calc02.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import projeto.calc02.interceptors.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/webjars/**")
		.addResourceLocations("/webjars/");
	}*/
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns( "/login", "/fazerLogin", "/webjars/**", "/bootstrap/**");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/minha_conta").setViewName("minha_conta");
	}
}
