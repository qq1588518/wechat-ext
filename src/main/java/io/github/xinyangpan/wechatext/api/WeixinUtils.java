package io.github.xinyangpan.wechatext.api;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.base.Joiner;

import okhttp3.HttpUrl;

public class WeixinUtils {

	public static long now() {
		return System.currentTimeMillis();
	}
	
	public static HttpUrl.Builder commonBuilder() {
		return new HttpUrl.Builder()
			.scheme("https")
			.host("api.weixin.qq.com")
			.addPathSegment("cgi-bin");
	}


	public static boolean isSignatureValid(String signature, String token, String timestamp, String nonce) {
		String[] strs = new String[] { token, timestamp, nonce };
		Arrays.sort(strs);
		String concat = Joiner.on("").join(strs);
		String calculateSignature = DigestUtils.sha1Hex(concat);
		return Objects.equals(signature, calculateSignature);
	}

}
