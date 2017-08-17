package cn.nextop.wx.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cn.nextop.wx.api.vo.json.ApiError;
import cn.nextop.wx.api.vo.json.ConditionalMenuBar;
import cn.nextop.wx.api.vo.json.MenuBar;
import cn.nextop.wx.api.vo.json.MenuId;
import okhttp3.HttpUrl;

@Component
public class MenuApi {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CoreApi coreApi;
	
	public ApiError create(MenuBar menuBar) {
		HttpUrl url = WeixinApiUtils.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("create")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), menuBar, ApiError.class).throwExceptionIfError();
	}
	
	public MenuId addConditional(ConditionalMenuBar conditionalMenuBar) {
		HttpUrl url = WeixinApiUtils.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("addconditional")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), conditionalMenuBar, MenuId.class).throwExceptionIfError();
	}
	
	public ApiError delConditional(MenuId menuId) {
		HttpUrl url = WeixinApiUtils.commonBuilder()
			.addPathSegment("menu")
			.addPathSegment("delconditional")
			.addQueryParameter("access_token", coreApi.currentAccessToken())
			.build();
		// 
		return restTemplate.postForObject(url.toString(), menuId, ApiError.class).throwExceptionIfError();
	}
	
}
