package io.github.xinyangpan.wechatext.api;

import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.TemplateMessage;
import okhttp3.HttpUrl;

public class MessageApi extends AbstractBusinessApi {

	public <T> ApiError sendTemplateMessage(TemplateMessage<T> templateMessage) {
		HttpUrl url = wechatExtService.commonBuilder()//
			.addPathSegment("message")//
			.addPathSegment("template")//
			.addPathSegment("send")//
			.addQueryParameter("access_token", coreApi.currentAccessToken())//
			.build();
		// 
		ApiError apiError = restTemplate.postForObject(url.toString(), templateMessage, ApiError.class);
		return apiError.throwExceptionIfError();
	}

}
