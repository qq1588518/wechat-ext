package io.github.xinyangpan.wechatext;

import java.util.List;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.collect.Lists;

import io.github.xinyangpan.wechatext.api.AbstractApi;
import io.github.xinyangpan.wechatext.api.AbstractBusinessApi;
import io.github.xinyangpan.wechatext.api.CoreApi;
import io.github.xinyangpan.wechatext.api.MenuApi;
import io.github.xinyangpan.wechatext.api.MessageApi;
import io.github.xinyangpan.wechatext.api.QrCodeApi;
import io.github.xinyangpan.wechatext.api.TagApi;
import io.github.xinyangpan.wechatext.core.RestWrapper;
import io.github.xinyangpan.wechatext.core.WechatExtProperties;
import io.github.xinyangpan.wechatext.core.WechatExtService;
import io.github.xinyangpan.wechatext.core.listener.IncomeMessageListener;

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
		// exclude XML converter
		List<HttpMessageConverter<?>> messageConverters = Lists.newArrayList();
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		// 
		RestTemplate restTemplate = new RestTemplate(messageConverters);
		return restTemplate;
	}

	@Bean
	@ConditionalOnMissingBean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
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
		wechatExtService.setRestWrapper(restWrapper());
		return wechatExtService;
	}

	@Bean
	@ConditionalOnMissingBean
	public IncomeMessageListener incomeMessageListener() {
		return new IncomeMessageListener() {};
	}

	// -----------------------------
	// ----- API
	// -----------------------------

	@Bean
	@ConditionalOnMissingBean
	public RestWrapper restWrapper() {
		RestWrapper restWrapper = new RestWrapper();
		restWrapper.setRestTemplate(restTemplate());
		restWrapper.setObjectMapper(objectMapper());
		return restWrapper;
	}

	@Bean
	@ConditionalOnMissingBean
	public CoreApi coreApi() {
		return this.buildAbstractApi(new CoreApi());
	}

	@Bean
	@ConditionalOnMissingBean
	public MenuApi menuApi() {
		return this.buildAbstractBusinessApi(new MenuApi());
	}

	@Bean
	@ConditionalOnMissingBean
	public MessageApi messageApi() {
		return this.buildAbstractBusinessApi(new MessageApi());
	}

	@Bean
	@ConditionalOnMissingBean
	public TagApi tagApi() {
		return this.buildAbstractBusinessApi(new TagApi());
	}

	@Bean
	@ConditionalOnMissingBean
	public QrCodeApi qrCodeApi() {
		return this.buildAbstractBusinessApi(new QrCodeApi());
	}

	public <T extends AbstractBusinessApi> T buildAbstractBusinessApi(T t) {
		this.buildAbstractApi(t);
		t.setCoreApi(coreApi());
		return t;
	}

	public <T extends AbstractApi> T buildAbstractApi(T t) {
		t.setRestTemplate(restTemplate());
		t.setWechatExtProperties(wechatExtProperties);
		t.setWechatExtService(wechatExtService());
		return t;
	}

}
