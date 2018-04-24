package io.github.xinyangpan.wechatext.api;

import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.Tagging;
import okhttp3.HttpUrl;

public class TagApi extends AbstractBusinessApi {

	public <T> ApiError tagging(Tagging tagging) {
		HttpUrl url = wechatExtService.commonBuilder()//
			.addPathSegment("tags")//
			.addPathSegment("members")//
			.addPathSegment("batchtagging")//
			.addQueryParameter("access_token", coreApi.currentAccessToken())//
			.build();
		// 
		ApiError apiError = restTemplate.postForObject(url.toString(), tagging, ApiError.class);
		return apiError.throwExceptionIfError();
	}

}
