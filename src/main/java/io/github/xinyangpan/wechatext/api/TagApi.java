package io.github.xinyangpan.wechatext.api;

import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.core.WechatExtService;
import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.Tagging;
import okhttp3.HttpUrl;

public class TagApi {
	private RestTemplate restTemplate;
	private CoreApi coreApi;
	private WechatExtService wechatExtService;
	
	public <T> ApiError tagging(Tagging tagging) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("tags")
			.addPathSegment("members")
			.addPathSegment("batchtagging")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		ApiError apiError = restTemplate.postForObject(url.toString(), tagging, ApiError.class);
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
