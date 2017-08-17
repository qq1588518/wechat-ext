package io.github.xinyangpan.wechatext.core.vo.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@JacksonXmlRootElement(localName = "xml")
public class Xml {
	
	@JacksonXmlCData
	@JsonProperty("ToUserName")
	private String toUserName;
	
	@JacksonXmlCData
	@JsonProperty("FromUserName")
	private String fromUserName;
	
	@JsonProperty("CreateTime")
	private Long createTime;

	@JacksonXmlCData
	@JsonProperty("MsgType")
	private MsgType msgType;

	@Override
	public String toString() {
		return String.format("Xml [toUserName=%s, fromUserName=%s, createTime=%s, msgType=%s]", toUserName, fromUserName, createTime, getMsgType());
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public MsgType getMsgType() {
		return msgType;
	}

	public void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}

}
