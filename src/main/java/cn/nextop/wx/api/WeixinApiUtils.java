package cn.nextop.wx.api;

import okhttp3.HttpUrl;

public class WeixinApiUtils {
	
	public static HttpUrl.Builder commonBuilder() {
		return new HttpUrl.Builder()
			.scheme("https")
			.host("api.weixin.qq.com")
			.addPathSegment("cgi-bin");
	}
	
}
