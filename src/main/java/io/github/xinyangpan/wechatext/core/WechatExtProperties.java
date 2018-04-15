package io.github.xinyangpan.wechatext.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("wechat")
public class WechatExtProperties {

	private String appId;
	private String appSecret;
	private String token;
	private String redirectUri;
	private boolean requestDumpEnable = false;

	@Override
	public String toString() {
		return String.format("WechatExtProperties [appId=%s, appSecret=%s, token=%s, redirectUri=%s, requestDumpEnable=%s]", appId, appSecret, token, redirectUri, requestDumpEnable);
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

	public boolean isRequestDumpEnable() {
		return requestDumpEnable;
	}

	public void setRequestDumpEnable(boolean requestDumpEnable) {
		this.requestDumpEnable = requestDumpEnable;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

}