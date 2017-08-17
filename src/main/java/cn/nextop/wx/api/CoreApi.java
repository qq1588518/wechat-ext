package cn.nextop.wx.api;

import static cn.nextop.wx.api.WeixinUtils.now;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cn.nextop.wx.api.vo.json.AccessToken;
import cn.nextop.wx.configuration.WechatExtProperties;
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
		HttpUrl url = WeixinApiUtils.commonBuilder()
			.addPathSegment("token")
			.addQueryParameter("grant_type", "client_credential")
			.addQueryParameter("appid", appId)
			.addQueryParameter("secret", appSecret)
			.build();
		return restTemplate.getForObject(url.toString(), AccessToken.class).throwExceptionIfError();
	}

}
