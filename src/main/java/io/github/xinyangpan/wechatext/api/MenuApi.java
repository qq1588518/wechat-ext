package io.github.xinyangpan.wechatext.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.api.vo.json.ApiError;
import io.github.xinyangpan.wechatext.api.vo.json.ConditionalMenuBar;
import io.github.xinyangpan.wechatext.api.vo.json.MenuBar;
import io.github.xinyangpan.wechatext.api.vo.json.MenuId;
import io.github.xinyangpan.wechatext.core.WechatExtService;
import okhttp3.HttpUrl;

@Component
public class MenuApi {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CoreApi coreApi;
	@Autowired
	private WechatExtService wechatExtService;
	
	public ApiError create(MenuBar menuBar) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("create")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), menuBar, ApiError.class).throwExceptionIfError();
	}
	
	public MenuId addConditional(ConditionalMenuBar conditionalMenuBar) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("addconditional")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), conditionalMenuBar, MenuId.class).throwExceptionIfError();
	}
	
	public ApiError delConditional(MenuId menuId) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("delconditional")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), menuId, ApiError.class).throwExceptionIfError();
	}
	
}
