package io.github.xinyangpan.wechatext.api.vo.json;

import java.util.List;

public class MenuBar {
	private List<MenuButton> button;

	@Override
	public String toString() {
		return String.format("MenuBar [button=%s]", button);
	}

	public List<MenuButton> getButton() {
		return button;
	}

	public void setButton(List<MenuButton> button) {
		this.button = button;
	}

}
