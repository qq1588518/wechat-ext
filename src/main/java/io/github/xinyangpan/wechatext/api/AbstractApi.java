package io.github.xinyangpan.wechatext.api;

import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.core.WechatExtProperties;
import io.github.xinyangpan.wechatext.core.WechatExtService;

public class AbstractApi {
	// 
	protected RestTemplate restTemplate;
	protected CoreApi coreApi;
	protected WechatExtService wechatExtService;
	protected WechatExtProperties wechatExtProperties;

}
