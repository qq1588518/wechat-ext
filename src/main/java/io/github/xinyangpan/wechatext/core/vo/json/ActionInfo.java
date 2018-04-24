package io.github.xinyangpan.wechatext.core.vo.json;

public class ActionInfo {
	private Scene scene;

	@Override
	public String toString() {
		return String.format("ActionInfo [scene=%s]", scene);
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
