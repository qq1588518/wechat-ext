package cn.nextop.wx.api.vo.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;

public class XmlText extends Xml {
	
	@JacksonXmlCData
	@JsonProperty("Content")
	private String content;
	
	@JsonProperty("MsgId")
	private Long msgId;

	@Override
	public String toString() {
		return String.format("XmlText [content=%s, msgId=%s, toUserName=%s, fromUserName=%s, createTime=%s, msgType=%s]", content, msgId, getToUserName(), getFromUserName(), getCreateTime(), getMsgType());
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

}
