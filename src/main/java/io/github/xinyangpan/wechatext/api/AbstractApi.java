package io.github.xinyangpan.wechatext.api;

import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.core.WechatExtProperties;
import io.github.xinyangpan.wechatext.core.WechatExtService;

public class AbstractApi {
	// 
	protected RestTemplate restTemplate;
	protected WechatExtService wechatExtService;
	protected WechatExtProperties wechatExtProperties;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public WechatExtProperties getWechatExtProperties() {
		return wechatExtProperties;
	}

	public void setWechatExtProperties(WechatExtProperties wechatExtProperties) {
		this.wechatExtProperties = wechatExtProperties;
	}

	public WechatExtService getWechatExtService() {
		return wechatExtService;
	}

	public void setWechatExtService(WechatExtService wechatExtService) {
		this.wechatExtService = wechatExtService;
	}

}
