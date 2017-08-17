package io.github.xinyangpan.wechatext.core.vo.json;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AccessToken extends ApiError {
	private String accessToken;
	private int expiresIn;

	@Override
	public String toString() {
		return String.format("AccessToken [accessToken=%s, expiresIn=%s, errcode=%s, errmsg=%s]", accessToken, expiresIn, this.getErrcode(), this.getErrmsg());
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

}
