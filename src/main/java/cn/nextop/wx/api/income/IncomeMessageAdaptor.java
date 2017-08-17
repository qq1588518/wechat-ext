package cn.nextop.wx.api.income;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import cn.nextop.wx.api.vo.xml.Xml;
import cn.nextop.wx.api.vo.xml.XmlEvent;
import cn.nextop.wx.api.vo.xml.XmlText;

public abstract class IncomeMessageAdaptor implements IncomeMessageListener {

	public abstract XmlMapper getXmlMapper();

	@Override
	public String onMessage(String message) throws IOException {
		XmlMapper xmlMapper = this.getXmlMapper();
		Xml xml = xmlMapper.readValue(message, Xml.class);
		switch (xml.getMsgType()) {
		case text:
			return this.onText(xmlMapper.readValue(message, XmlText.class));
		case event:
			return this.onEvent(xmlMapper.readValue(message, XmlEvent.class));
		default:
			throw new IllegalArgumentException(xml.getMsgType().toString());
		}
	}

	public String onText(XmlText in) throws IOException {
		return "";
	}

	public String onEvent(XmlEvent xmlEvent) throws IOException {
		switch (xmlEvent.getEvent()) {
		case subscribe:
			return this.onSubscribeEvent(xmlEvent);
		case unsubscribe:
			return this.onUnsubscribeEvent(xmlEvent);
		case TEMPLATESENDJOBFINISH:
			return this.onTemplateSendJobFinishEvent(xmlEvent);
		case VIEW:
			return this.onViewEvent(xmlEvent);
		default:
			return "success";
		}
	}

	public String onSubscribeEvent(XmlEvent xmlEvent) throws IOException {
		return "";
	}

	public String onUnsubscribeEvent(XmlEvent xmlEvent) throws IOException {
		return "";
	}

	public String onTemplateSendJobFinishEvent(XmlEvent xmlEvent) throws IOException {
		return "";
	}

	public String onViewEvent(XmlEvent xmlEvent) {
		return "";
	}

}
