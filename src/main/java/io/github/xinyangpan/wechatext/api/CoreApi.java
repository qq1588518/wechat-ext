package io.github.xinyangpan.wechatext.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.core.WechatExtProperties;
import io.github.xinyangpan.wechatext.core.WechatExtService;
import io.github.xinyangpan.wechatext.core.vo.json.AccessToken;
import okhttp3.HttpUrl;

@Component
@ConditionalOnMissingBean
public class CoreApi {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WechatExtProperties wechatExtProperties;
	@Autowired
	private WechatExtService wechatExtService;
	
	// 
	private String accessTokenStr;
	private long nextRequestTime;

	public synchronized String currentAccessToken() {
		if (accessTokenStr != null && wechatExtService.now() < nextRequestTime) {
			return accessTokenStr;
		}
		AccessToken accessToken = this.accessToken(wechatExtProperties.getAppId(), wechatExtProperties.getAppSecret());
		accessTokenStr = accessToken.getAccessToken();
		nextRequestTime = wechatExtService.now() + accessToken.getExpiresIn() * 1000;
		return accessTokenStr;
	}
	
	private AccessToken accessToken(String appId, String appSecret) {
		HttpUrl url = wechatExtService.commonBuilder()
			.addPathSegment("token")
			.addQueryParameter("grant_type", "client_credential")
			.addQueryParameter("appid", appId)
			.addQueryParameter("secret", appSecret)
			.build();
		return restTemplate.getForObject(url.toString(), AccessToken.class).throwExceptionIfError();
	}

}
