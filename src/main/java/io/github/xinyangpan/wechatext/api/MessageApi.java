package io.github.xinyangpan.wechatext.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.core.WechatExtService;
import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.TemplateMessage;
import okhttp3.HttpUrl;

@Component
@ConditionalOnMissingBean
public class MessageApi {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CoreApi coreApi;
	@Autowired
	private WechatExtService wechatExtService;
	
	public <T> ApiError sendTemplateMessage(TemplateMessage<T> templateMessage) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("message")
			.addPathSegment("template")
			.addPathSegment("send")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), templateMessage, ApiError.class).throwExceptionIfError();
	}
}
