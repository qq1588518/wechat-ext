package io.github.xinyangpan.wechatext.core;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.base.Joiner;

import okhttp3.HttpUrl;

public class WechatExtService {
	private WechatExtProperties wechatExtProperties;

	public HttpUrl.Builder commonBuilder() {
		return HttpUrl.parse(wechatExtProperties.getWechatUrl()).newBuilder();
	}

	public boolean isSignatureValid(String signature, String token, String timestamp, String nonce) {
		String[] strs = new String[] { token, timestamp, nonce };
		Arrays.sort(strs);
		String concat = Joiner.on("").join(strs);
		String calculateSignature = DigestUtils.sha1Hex(concat);
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
