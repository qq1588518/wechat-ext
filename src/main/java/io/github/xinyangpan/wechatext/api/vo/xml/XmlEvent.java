package io.github.xinyangpan.wechatext.api.vo.xml;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XmlEvent extends Xml {
	
	@JsonProperty("Event")
	private EventType event;
	@JsonProperty("EventKey")
	private String eventKey;
	@JsonProperty("MenuId")
	private Long menuId;

	@Override
	public String toString() {
		return String.format("XmlEvent [event=%s, eventKey=%s, menuId=%s, toUserName=%s, fromUserName=%s, createTime=%s, msgType=%s]", event, eventKey, menuId, getToUserName(), getFromUserName(), getCreateTime(), getMsgType());
	}

	public EventType getEvent() {
		return event;
	}

	public void setEvent(EventType event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

}
