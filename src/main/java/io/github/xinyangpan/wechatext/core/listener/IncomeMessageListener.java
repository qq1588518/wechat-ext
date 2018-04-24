package io.github.xinyangpan.wechatext.core.listener;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IncomeMessageListener {
	Logger log = LoggerFactory.getLogger(IncomeMessageListener.class);

	public default String onMessage(String message) throws IOException {
		log.info("IncomeMessageListener[{}] - onMessage: {}", this.getClass().getSimpleName(), message);
		return "";
	}

}
