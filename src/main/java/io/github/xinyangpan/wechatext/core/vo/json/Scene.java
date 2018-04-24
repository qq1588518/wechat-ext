package io.github.xinyangpan.wechatext.core.vo.json;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Scene {
	private long sceneId;

	@Override
	public String toString() {
		return String.format("Scene [sceneId=%s]", getSceneId());
	}

	public long getSceneId() {
		return sceneId;
	}

	public void setSceneId(long sceneId) {
		this.sceneId = sceneId;
	}

}
