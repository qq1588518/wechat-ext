package io.github.xinyangpan.action;

import org.junit.Test;

import com.google.common.collect.Lists;

import io.github.xinyangpan.wechatext.core.vo.json.ApiError;
import io.github.xinyangpan.wechatext.core.vo.json.MenuBar;
import io.github.xinyangpan.wechatext.core.vo.json.MenuButton;

public class CreateCommonMenuBar extends AbstractAction {

	@Test
	public void commonMenuBar() {
		// 
		MenuButton menu1 = new MenuButton();
		menu1.setName("我的服务");
		menu1.setType("view");
		menu1.setUrl("https://panxinyang.cn/service/");
		// 
		MenuButton menu2 = new MenuButton();
		menu2.setName("我的物业");
		menu2.setType("view");
		menu2.setUrl("https://panxinyang.cn/service/property");
		// 
		MenuButton menu3 = new MenuButton();
		menu3.setName("员工登录");
		menu3.setType("view");
		menu3.setUrl("https://panxinyang.cn/staff/login");
		// 
		MenuBar menuBar = new MenuBar();
		menuBar.setButton(Lists.newArrayList(menu1, menu2, menu3));
		ApiError apiError = api.menu().create(menuBar);
		System.out.println(apiError);
	}

}
