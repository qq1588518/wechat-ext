package io.github.xinyangpan.wechatext.api;

import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.core.WechatExtService;
import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.ConditionalMenuBar;
import io.github.xinyangpan.wechatext.core.vo.json.MenuBar;
import io.github.xinyangpan.wechatext.core.vo.json.MenuId;
import okhttp3.HttpUrl;

public class MenuApi {
	private RestTemplate restTemplate;
	private CoreApi coreApi;
	private WechatExtService wechatExtService;
	
	public ApiError create(MenuBar menuBar) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("create")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		ApiError apiError = restTemplate.postForObject(url.toString(), menuBar, ApiError.class);
		return apiError.throwExceptionIfError();
	}
	
	public MenuId addConditional(ConditionalMenuBar conditionalMenuBar) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("addconditional")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		MenuId menuId = restTemplate.postForObject(url.toString(), conditionalMenuBar, MenuId.class);
		return menuId.throwExceptionIfError();
	}
	
	public ApiError delConditional(MenuId menuId) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("delconditional")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		ApiError apiError = restTemplate.postForObject(url.toString(), menuId, ApiError.class);
		return apiError.throwExceptionIfError();
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public CoreApi getCoreApi() {
		return coreApi;
	}

	public void setCoreApi(CoreApi coreApi) {
		this.coreApi = coreApi;
	}

	public WechatExtService getWechatExtService() {
		return wechatExtService;
	}

	public void setWechatExtService(WechatExtService wechatExtService) {
		this.wechatExtService = wechatExtService;
	}
	
}
