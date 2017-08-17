package io.github.xinyangpan.wechatext;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.collect.Lists;

@Configuration
public class WechatExtConfiguration {

	@Bean
	@ConditionalOnProperty("wechat.request-dump-enable")
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new RequestDumperFilter());
		registration.addUrlPatterns("/*");
		registration.setName("RequestDumperFilter");
		registration.setOrder(1);
		return registration;
	}

	@Bean
	@ConditionalOnMissingBean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(Lists.newArrayList(new MappingJackson2HttpMessageConverter()));
		return restTemplate;
	}

	@Bean
	@ConditionalOnMissingBean
	public XmlMapper xmlMapper() {
		return new XmlMapper();
	}

}
