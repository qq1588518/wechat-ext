package io.github.xinyangpan.wechatext.api;

import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.MenuBar;
import okhttp3.HttpUrl;

public class QrCodeApi extends AbstractApi {

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
	
}
