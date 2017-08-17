package cn.nextop.wx.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cn.nextop.wx.api.vo.json.ApiError;
import cn.nextop.wx.api.vo.json.TemplateMessage;
import okhttp3.HttpUrl;

@Component
public class MessageApi {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CoreApi coreApi;
	
	public <T> ApiError sendTemplateMessage(TemplateMessage<T> templateMessage) {
		HttpUrl url = WeixinApiUtils.commonBuilder()
			.addPathSegment("message")
			.addPathSegment("template")
			.addPathSegment("send")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), templateMessage, ApiError.class).throwExceptionIfError();
	}
}
