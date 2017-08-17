package io.github.xinyangpan.wechatext.api.vo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuId extends ApiError{
	@JsonProperty("menuid")
	private Integer menuId;

	@Override
	public String toString() {
		return String.format("MenuId [menuid=%s, errcode=%s, errmsg=%s]", getMenuId(), this.getErrcode(), this.getErrmsg());
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

}
