package io.github.xinyangpan.wechatext.api;

import static io.github.xinyangpan.wechatext.api.WeixinUtils.now;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.xinyangpan.wechatext.api.vo.json.AccessToken;
import io.github.xinyangpan.wechatext.configuration.WechatExtProperties;
import okhttp3.HttpUrl;

@Component
public class CoreApi {
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private WechatExtProperties wechatExtProperties;
	// 
	private String accessTokenStr;
	private long nextRequestTime;

	public synchronized String currentAccessToken() {
		if (accessTokenStr != null && now() < nextRequestTime) {
			return accessTokenStr;
		}
		AccessToken accessToken = this.accessToken(wechatExtProperties.getAppId(), wechatExtProperties.getAppSecret());
		accessTokenStr = accessToken.getAccessToken();
		nextRequestTime = now() + accessToken.getExpiresIn() * 1000;
		return accessTokenStr;
	}
	
	private AccessToken accessToken(String appId, String appSecret) {
		HttpUrl url = WeixinUtils.commonBuilder()
			.addPathSegment("token")
			.addQueryParameter("grant_type", "client_credential")
			.addQueryParameter("appid", appId)
			.addQueryParameter("secret", appSecret)
			.build();
		return restTemplate.getForObject(url.toString(), AccessToken.class).throwExceptionIfError();
	}

}
