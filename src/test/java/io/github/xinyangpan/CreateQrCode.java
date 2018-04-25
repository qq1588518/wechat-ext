package io.github.xinyangpan;

import java.io.File;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import io.github.xinyangpan.wechatext.WechatExtAutoConfiguration;
import io.github.xinyangpan.wechatext.api.CoreApi;
import io.github.xinyangpan.wechatext.api.QrCodeApi;
import io.github.xinyangpan.wechatext.core.WechatExtProperties;
import io.github.xinyangpan.wechatext.core.vo.json.QrCode;

@RunWith(SpringRunner.class)
@Import(WechatExtAutoConfiguration.class)
public class CreateQrCode {
	// 
	@Autowired
	protected ApplicationContext applicationContext;
	@Autowired
	protected WechatExtProperties wechatExtProperties;
	@Autowired
	protected QrCodeApi qrCodeApi;
	@Autowired
	protected CoreApi coreApi;
	@Autowired
	protected ObjectMapper objectMapper;

	@Before
	public void before() throws Exception {
		CharSource charSource = Files.asCharSource(new File("app_secret.txt"), Charset.defaultCharset());
		String appSecret = charSource.read();
		System.out.println(appSecret);
		wechatExtProperties.setAppId("wxad7f4e65a5154252");
		wechatExtProperties.setAppSecret(appSecret);
		System.out.println(coreApi.currentAccessToken());
	}

	@Test
	public void qrCode() throws Exception {
		// 
		QrCode permanent = QrCode.permanent(3);
		System.out.println(qrCodeApi.create(permanent));
	}

}
