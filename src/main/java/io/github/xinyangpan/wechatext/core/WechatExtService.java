package io.github.xinyangpan.wechatext.core;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

import okhttp3.HttpUrl;

public class WechatExtService {
	private static final Logger log = LoggerFactory.getLogger(WechatExtService.class);

	private WechatExtProperties wechatExtProperties;

	public HttpUrl.Builder commonBuilder() {
		return HttpUrl.parse(wechatExtProperties.getWechatUrl()).newBuilder();
	}

	public boolean isSignatureValid(String signature, String token, String timestamp, String nonce) {
		log.debug("isSignatureValid: signature={}, token={}, timestamp={}, nonce={}", signature, token, timestamp, nonce);
		String[] strs = new String[] { token, timestamp, nonce };
		Arrays.sort(strs);
		String concat = Joiner.on("").join(strs);
		String calculateSignature = DigestUtils.sha1Hex(concat);
		log.debug("Calculated Signature: {}", calculateSignature);
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

}
