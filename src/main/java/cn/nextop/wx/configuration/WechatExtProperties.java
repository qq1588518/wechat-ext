package cn.nextop.wx.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("wechat")
public class WechatExtProperties {

	private String appId;
	private String appSecret;
	private String token;
	private String licenseTempId;
	private String vehicleInfoTempId;
	private String insuranceTempId;
	private boolean requestDumpEnable;

	@Override
	public String toString() {
		return String.format("AppProperties [appId=%s, appSecret=%s, token=%s, licenseTempId=%s, vehicleInfoTempId=%s, insuranceTempId=%s, requestDumpEnable=%s]", appId, appSecret, token, licenseTempId, vehicleInfoTempId, insuranceTempId, requestDumpEnable);
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLicenseTempId() {
		return licenseTempId;
	}

	public void setLicenseTempId(String licenseTempId) {
		this.licenseTempId = licenseTempId;
	}

	public String getVehicleInfoTempId() {
		return vehicleInfoTempId;
	}

	public void setVehicleInfoTempId(String vehicleInfoTempId) {
		this.vehicleInfoTempId = vehicleInfoTempId;
	}

	public String getInsuranceTempId() {
		return insuranceTempId;
	}

	public void setInsuranceTempId(String insuranceTempId) {
		this.insuranceTempId = insuranceTempId;
	}

	public boolean isRequestDumpEnable() {
		return requestDumpEnable;
	}

	public void setRequestDumpEnable(boolean requestDumpEnable) {
		this.requestDumpEnable = requestDumpEnable;
	}

}