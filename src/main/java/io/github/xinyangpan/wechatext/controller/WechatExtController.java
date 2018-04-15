package io.github.xinyangpan.wechatext.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.xinyangpan.wechatext.core.WechatExtProperties;
import io.github.xinyangpan.wechatext.core.WechatExtService;
import io.github.xinyangpan.wechatext.core.listener.IncomeMessageListener;

@Controller
@RequestMapping(value = "/wechat")
public class WechatExtController {
	private static final Logger log = LoggerFactory.getLogger(WechatExtController.class);
	@Autowired
	private WechatExtProperties wechatExtProperties;
	@Autowired
	private IncomeMessageListener incomeMessageListener;
	@Autowired
	private WechatExtService wechatExtService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String token(
		@RequestParam("signature") String signature,
		@RequestParam("echostr") String echostr,
		@RequestParam("timestamp") String timestamp,
		@RequestParam("nonce") String nonce) {
		// 
		if (!wechatExtService.isSignatureValid(signature, wechatExtProperties.getToken(), timestamp, nonce)) {
			log.warn("invalid signature: " + signature);
			return "fail";
		}
		return echostr;
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String weixinRedirect(@RequestParam(name = "scope", defaultValue = "snsapi_base") String scope) {
		return String.format("redirect:%s", wechatExtService.authorizeUrl(scope));
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "text/xml")
	@ResponseBody
	public String business(
		@RequestParam("signature") String signature,
		@RequestParam("timestamp") String timestamp,
		@RequestParam("nonce") String nonce,
		@RequestBody String content) throws IOException {
		// 
		if (!wechatExtService.isSignatureValid(signature, wechatExtProperties.getToken(), timestamp, nonce)) {
			log.warn("invalid signature: " + signature);
			return "fail";
		}
		// 
		log.info("business method. content:\n{}", content);
		return incomeMessageListener.onMessage(content);
	}

	public WechatExtProperties getWechatExtProperties() {
		return wechatExtProperties;
	}

	public void setWechatExtProperties(WechatExtProperties wechatExtProperties) {
		this.wechatExtProperties = wechatExtProperties;
	}

	public IncomeMessageListener getIncomeMessageListener() {
		return incomeMessageListener;
	}

	public void setIncomeMessageListener(IncomeMessageListener incomeMessageListener) {
		this.incomeMessageListener = incomeMessageListener;
	}

	public WechatExtService getWechatExtService() {
		return wechatExtService;
	}

	public void setWechatExtService(WechatExtService wechatExtService) {
		this.wechatExtService = wechatExtService;
	}

}
