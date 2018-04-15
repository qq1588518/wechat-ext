package io.github.xinyangpan.wechatext.core;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

import io.github.xinyangpan.wechatext.core.vo.json.UserBaseInfo;
import okhttp3.HttpUrl;

public class WechatExtService {
	private static final Logger log = LoggerFactory.getLogger(WechatExtService.class);
	private static String BUSINESS_URL = "https://api.weixin.qq.com/cgi-bin";
	private static String AUTHORIZE_STATE = "ppp";

	private RestWrapper restWrapper;
	private WechatExtProperties wechatExtProperties;

	public HttpUrl.Builder commonBuilder() {
		return HttpUrl.parse(BUSINESS_URL).newBuilder();
	}

	/**
	 * @param scope 
	 * 		snsapi_base - 不弹出授权页面，直接跳转，只能获取用户openid
	 * 		snsapi_userinfo - 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息
	 * @return
	 */
	public String authorizeUrl(String scope) {
		String appId = wechatExtProperties.getAppId();
		String redirectUri = wechatExtProperties.getRedirectUri();
		String responseType = "code";
		if ("snsapi_base".equals(scope)||"snsapi_userinfo".equals(scope)) {
			return HttpUrl.parse("https://open.weixin.qq.com/connect/oauth2/authorize").newBuilder()
				.addQueryParameter("appid", appId)
				.addQueryParameter("redirect_uri", redirectUri)
				.addQueryParameter("response_type", responseType)
				.addQueryParameter("scope", scope)
				.addQueryParameter("state", AUTHORIZE_STATE)
				.encodedFragment("wechat_redirect")
				.toString();
		} else {
			throw new IllegalArgumentException(String.format("scope[%s] is not valid", scope));
		}
	}
	
	public UserBaseInfo userBaseInfo(String code) {
		String url = HttpUrl.parse("https://api.weixin.qq.com/sns/oauth2/access_token").newBuilder()
			.addQueryParameter("appid", wechatExtProperties.getAppId())
			.addQueryParameter("secret", wechatExtProperties.getAppSecret())
			.addQueryParameter("code", code)
			.addQueryParameter("grant_type", "authorization_code")
			.toString();
		return restWrapper.getForObject(url, UserBaseInfo.class);
	}
	
	public boolean isSignatureValid(String signature, String token, String timestamp, String nonce) {
		log.info("isSignatureValid: signature={}, token={}, timestamp={}, nonce={}", signature, token, timestamp, nonce);
		String[] strs = new String[] { token, timestamp, nonce };
		Arrays.sort(strs);
		String concat = Joiner.on("").join(strs);
		String calculateSignature = DigestUtils.sha1Hex(concat);
		log.info("Calculated Signature: {}", calculateSignature);
		return Objects.equals(signature, calculateSignature);
	}

	public long now() {
		return System.currentTimeMillis();
	}

	public WechatExtProperties getWechatExtProperties() {
		return wechatExtProperties;
	}

	public void setWechatExtProperties(WechatExtProperties wechatExtProperties) {
		this.wechatExtProperties = wechatExtProperties;
	}

	public RestWrapper getRestWrapper() {
		return restWrapper;
	}

	public void setRestWrapper(RestWrapper restWrapper) {
		this.restWrapper = restWrapper;
	}

}
