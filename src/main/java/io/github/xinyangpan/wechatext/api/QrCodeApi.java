package io.github.xinyangpan.wechatext.api;

import io.github.xinyangpan.wechatext.core.vo.json.QrCode;
import io.github.xinyangpan.wechatext.core.vo.json.QrCodeResult;
import okhttp3.HttpUrl;

public class QrCodeApi extends AbstractBusinessApi {

	public QrCodeResult create(QrCode qrCode) {
		HttpUrl url = wechatExtService.commonBuilder()//
			.addPathSegment("qrcode")//
			.addPathSegment("create")//
			.addQueryParameter("access_token", coreApi.currentAccessToken())//
			.build();
		// 
		System.out.println(url.toString());
		QrCodeResult qrCodeResult = restTemplate.postForObject(url.toString(), qrCode, QrCodeResult.class);
		return qrCodeResult.throwExceptionIfError();
	}

}
