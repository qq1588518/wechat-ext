package io.github.xinyangpan.wechatext.api;

import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.core.WechatExtService;
import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.TemplateMessage;
import okhttp3.HttpUrl;

public class MessageApi {
	private RestTemplate restTemplate;
	private CoreApi coreApi;
	private WechatExtService wechatExtService;
	
	public <T> ApiError sendTemplateMessage(TemplateMessage<T> templateMessage) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("message")
			.addPathSegment("template")
			.addPathSegment("send")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		ApiError apiError = restTemplate.postForObject(url.toString(), templateMessage, ApiError.class);
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
