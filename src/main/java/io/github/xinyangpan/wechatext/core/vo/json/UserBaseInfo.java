package io.github.xinyangpan.wechatext.core.vo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserBaseInfo extends AccessToken {
	private String refreshToken;
	@JsonProperty("openid")
	private String openId;
	private String scope;

	@Override
	public String toString() {
		return String.format("Oauth2 [accessToken=%s, expiresIn=%s, refreshToken=%s, openId=%s, scope=%s]", accessToken, expiresIn, refreshToken, openId, scope);
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
