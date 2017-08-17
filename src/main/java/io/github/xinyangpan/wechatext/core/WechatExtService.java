package io.github.xinyangpan.wechatext.core;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;

import okhttp3.HttpUrl;

@Service
@ConditionalOnMissingBean
public class WechatExtService {
	@Autowired
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

}
