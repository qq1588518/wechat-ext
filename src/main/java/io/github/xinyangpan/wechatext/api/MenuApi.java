package io.github.xinyangpan.wechatext.api;

import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.ConditionalMenuBar;
import io.github.xinyangpan.wechatext.core.vo.json.MenuBar;
import io.github.xinyangpan.wechatext.core.vo.json.MenuId;
import okhttp3.HttpUrl;

public class MenuApi extends AbstractBusinessApi {

	public ApiError create(MenuBar menuBar) {
		HttpUrl url = wechatExtService.commonBuilder()//
			.addPathSegment("menu")//
			.addPathSegment("create")//
			.addQueryParameter("access_token", coreApi.currentAccessToken())//
			.build();
		// 
		ApiError apiError = restTemplate.postForObject(url.toString(), menuBar, ApiError.class);
		return apiError.throwExceptionIfError();
	}

	public MenuId addConditional(ConditionalMenuBar conditionalMenuBar) {
		HttpUrl url = wechatExtService.commonBuilder()//
			.addPathSegment("menu")//
			.addPathSegment("addconditional")//
			.addQueryParameter("access_token", coreApi.currentAccessToken())//
			.build();
		// 
		MenuId menuId = restTemplate.postForObject(url.toString(), conditionalMenuBar, MenuId.class);
		return menuId.throwExceptionIfError();
	}

	public ApiError delConditional(MenuId menuId) {
		HttpUrl url = wechatExtService.commonBuilder()//
			.addPathSegment("menu")//
			.addPathSegment("delconditional")//
			.addQueryParameter("access_token", coreApi.currentAccessToken())//
			.build();
		// 
		ApiError apiError = restTemplate.postForObject(url.toString(), menuId, ApiError.class);
		return apiError.throwExceptionIfError();
	}

}
