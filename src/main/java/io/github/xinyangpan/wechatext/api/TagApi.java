package io.github.xinyangpan.wechatext.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.api.vo.json.ApiError;
import io.github.xinyangpan.wechatext.api.vo.json.Tagging;
import okhttp3.HttpUrl;

@Component
public class TagApi {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CoreApi coreApi;
	
	public <T> ApiError tagging(Tagging tagging) {
		HttpUrl url = WeixinUtils.commonBuilder()
			.addPathSegment("tags")
			.addPathSegment("members")
			.addPathSegment("batchtagging")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), tagging, ApiError.class).throwExceptionIfError();
	}

}
