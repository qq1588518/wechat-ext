package io.github.xinyangpan.wechatext;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.github.xinyangpan.wechatext.api.CoreApi;
import io.github.xinyangpan.wechatext.api.MenuApi;
import io.github.xinyangpan.wechatext.api.MessageApi;
import io.github.xinyangpan.wechatext.api.TagApi;
import io.github.xinyangpan.wechatext.core.WechatExtProperties;
import io.github.xinyangpan.wechatext.core.WechatExtService;

@EnableConfigurationProperties(WechatExtProperties.class)
@Configuration
public class WechatExtAutoConfiguration {
	@Autowired
	private WechatExtProperties wechatExtProperties;

	@Bean
	@ConditionalOnProperty("wechat.request-dump-enable")
	public FilterRegistrationBean<RequestDumperFilter> filterRegistration() {
		FilterRegistrationBean<RequestDumperFilter> registration = new FilterRegistrationBean<>();
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
//		restTemplate.setMessageConverters(Lists.newArrayList(new MappingJackson2HttpMessageConverter()));
		return restTemplate;
	}

	@Bean
	@ConditionalOnMissingBean
	public XmlMapper xmlMapper() {
		return new XmlMapper();
	}

	@Bean
	@ConditionalOnMissingBean
	public WechatExtService wechatExtService() {
		WechatExtService wechatExtService = new WechatExtService();
		wechatExtService.setWechatExtProperties(wechatExtProperties);
		return wechatExtService;
	}

	// -----------------------------
	// ----- API
	// -----------------------------

	@Bean
	@ConditionalOnMissingBean
	public CoreApi coreApi() {
		CoreApi coreApi = new CoreApi();
		coreApi.setRestTemplate(restTemplate());
		coreApi.setWechatExtProperties(wechatExtProperties);
		coreApi.setWechatExtService(wechatExtService());
		return coreApi;
	}

	@Bean
	@ConditionalOnMissingBean
	public MenuApi menuApi() {
		MenuApi menuApi = new MenuApi();
		menuApi.setCoreApi(coreApi());
		menuApi.setRestTemplate(restTemplate());
		menuApi.setWechatExtService(wechatExtService());
		return menuApi;
	}

	@Bean
	@ConditionalOnMissingBean
	public MessageApi messageApi() {
		MessageApi messageApi = new MessageApi();
		messageApi.setCoreApi(coreApi());
		messageApi.setRestTemplate(restTemplate());
		messageApi.setWechatExtService(wechatExtService());
		return messageApi;
	}

	@Bean
	@ConditionalOnMissingBean
	public TagApi tagApi() {
		TagApi tagApi = new TagApi();
		tagApi.setCoreApi(coreApi());
		tagApi.setRestTemplate(restTemplate());
		tagApi.setWechatExtService(wechatExtService());
		return tagApi;
	}

}
