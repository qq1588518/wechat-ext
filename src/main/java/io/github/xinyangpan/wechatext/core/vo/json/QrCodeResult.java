package io.github.xinyangpan.wechatext.core.vo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QrCodeResult extends ApiError {
	private String ticket;
	@JsonProperty("expire_seconds")
	private Integer expireSecond;

	@Override
	public String toString() {
		return String.format("MenuId [ticket=%s, expireSecond=%s, errcode=%s, errmsg=%s]", ticket, expireSecond, errcode, errmsg);
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpireSecond() {
		return expireSecond;
	}

	public void setExpireSecond(Integer expireSecond) {
		this.expireSecond = expireSecond;
	}

}
