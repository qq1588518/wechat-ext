package io.github.xinyangpan.wechatext.api.vo.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tagging {
	@JsonProperty("tagid")
	private int tagId;
	@JsonProperty("openid_list")
	private List<String> openIdList;

	@Override
	public String toString() {
		return String.format("Tag [tagId=%s, openIdList=%s]", tagId, openIdList);
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public List<String> getOpenIdList() {
		return openIdList;
	}

	public void setOpenIdList(List<String> openIdList) {
		this.openIdList = openIdList;
	}

}
