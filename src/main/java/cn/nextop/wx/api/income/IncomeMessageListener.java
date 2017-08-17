package cn.nextop.wx.api.income;

import java.io.IOException;

public interface IncomeMessageListener {

	public String onMessage(String message) throws IOException;

}
