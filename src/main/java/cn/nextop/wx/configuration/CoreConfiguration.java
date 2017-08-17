package cn.nextop.wx.configuration;

import java.util.concurrent.atomic.AtomicReference;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.collect.Lists;

@Configuration
public class CoreConfiguration {
	@Autowired
	private WechatExtProperties wechatExtProperties;

	@Bean
	@ConditionalOnProperty("app.request-dump-enable")
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new RequestDumperFilter());
		registration.addUrlPatterns("/*");
		registration.setName("RequestDumperFilter");
		registration.setOrder(1);
		registration.setEnabled(wechatExtProperties.isRequestDumpEnable());
		return registration;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(Lists.newArrayList(new MappingJackson2HttpMessageConverter()));
		return restTemplate;
	}

	@Bean
	public XmlMapper xmlMapper() {
		return new XmlMapper();
	}

	@Bean
	public AtomicReference<String> lastOpenIdHolder() {
		return new AtomicReference<String>("opKYO0usv-lgVs4fVTP9sr4tLh8w");
	}

}
