package org.jc.kp.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@Import(HibConfig.class)
@ComponentScan(basePackages={"org.jc.kp.PhControllers","org.jc.kp.model","org.jc.kp.dao","org.jc.kp.exceptions","org.jc.kp.service"})

public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*staticfiles/**").addResourceLocations("staticfiles");
	}
	@Bean
	public InternalResourceViewResolver viewResolver() {
    	InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		  viewResolver.setViewClass(JstlView.class);
		  viewResolver.setPrefix("/WEB-INF/views/products/");
		  viewResolver.setSuffix(".jsp");
		return viewResolver;
		}
	
	 @Bean
	   public MessageSource messageSource() {
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasename("messages");
	      return source;
	   }

	   @Override
	   public Validator getValidator() {
	      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	      validator.setValidationMessageSource(messageSource());
	      return validator;
	   }
}



