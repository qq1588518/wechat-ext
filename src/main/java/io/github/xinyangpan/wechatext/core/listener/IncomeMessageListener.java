package io.github.xinyangpan.wechatext.core.listener;

import java.io.IOException;

public interface IncomeMessageListener {

	public String onMessage(String message) throws IOException;

}
