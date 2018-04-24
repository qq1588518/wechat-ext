package io.github.xinyangpan.wechatext.api;

import io.github.xinyangpan.wechatext.core.vo.json.AccessToken;
import okhttp3.HttpUrl;

public class CoreApi extends AbstractApi {
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
		HttpUrl url = wechatExtService.commonBuilder()//
			.addPathSegment("token")//
			.addQueryParameter("grant_type", "client_credential")//
			.addQueryParameter("appid", appId)//
			.addQueryParameter("secret", appSecret)//
			.build();
		AccessToken accessToken = restTemplate.getForObject(url.toString(), AccessToken.class);
		return accessToken.throwExceptionIfError();
	}

}
