package io.github.xinyangpan.wechatext.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("wechat")
public class WechatExtProperties {

	private String appId;
	private String appSecret;
	private String token;
	private String wechatUrl = "https://api.weixin.qq.com/cgi-bin";
	private boolean requestDumpEnable = false;

	@Override
	public String toString() {
		return String.format("WechatExtProperties [appId=%s, appSecret=%s, token=%s, wechatUrl=%s, requestDumpEnable=%s]", appId, appSecret, token, wechatUrl, requestDumpEnable);
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getWechatUrl() {
		return wechatUrl;
	}

	public void setWechatUrl(String wechatUrl) {
		this.wechatUrl = wechatUrl;
	}

	public boolean isRequestDumpEnable() {
		return requestDumpEnable;
	}

	public void setRequestDumpEnable(boolean requestDumpEnable) {
		this.requestDumpEnable = requestDumpEnable;
	}

}