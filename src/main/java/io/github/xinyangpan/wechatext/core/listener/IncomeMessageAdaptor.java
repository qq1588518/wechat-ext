package io.github.xinyangpan.wechatext.core.listener;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.github.xinyangpan.wechatext.core.vo.xml.Xml;
import io.github.xinyangpan.wechatext.core.vo.xml.XmlEvent;
import io.github.xinyangpan.wechatext.core.vo.xml.XmlText;

public class IncomeMessageAdaptor implements IncomeMessageListener {
	protected final XmlMapper xmlMapper;

	public IncomeMessageAdaptor(XmlMapper xmlMapper) {
		this.xmlMapper = xmlMapper;
	}

	@Override
	public String onMessage(String message) throws IOException {
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
		case SCAN:
			return this.onScanEvent(xmlEvent);
		default:
			return "success";
		}
	}

	protected String onScanEvent(XmlEvent xmlEvent) throws IOException {
		return "";
	}

	protected String onSubscribeEvent(XmlEvent xmlEvent) throws IOException {
		return "";
	}

	protected String onUnsubscribeEvent(XmlEvent xmlEvent) throws IOException {
		return "";
	}

	protected String onTemplateSendJobFinishEvent(XmlEvent xmlEvent) throws IOException {
		return "";
	}

	protected String onViewEvent(XmlEvent xmlEvent) throws IOException {
		return "";
	}

}
