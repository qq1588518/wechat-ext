package io.github.xinyangpan.wechatext.core.vo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class QrCode {
	private String actionName;
	private ActionInfo actionInfo;
    @JsonInclude(Include.NON_NULL)
	@JsonProperty("expire_seconds")
	private Long expireSecond;

	public static QrCode permanent(long sceneId) {
		ActionInfo actionInfo = buildActionInfo(sceneId);
		// 
		QrCode instance = new QrCode();
		instance.setActionInfo(actionInfo);
		instance.setActionName("QR_LIMIT_SCENE");
		return instance;
	}
	
	public static QrCode temporary(long sceneId, long expireSecond) {
		ActionInfo actionInfo = buildActionInfo(sceneId);
		// 
		QrCode instance = new QrCode();
		instance.setActionInfo(actionInfo);
		instance.setActionName("QR_SCENE");
		return instance;
	}
	
	private static ActionInfo buildActionInfo(long sceneId) {
		Scene scene = new Scene();
		scene.setSceneId(sceneId);
		// 
		ActionInfo actionInfo = new ActionInfo();
		actionInfo.setScene(scene);
		return actionInfo;
	}

	@Override
	public String toString() {
		return String.format("QrCode [actionName=%s, actionInfo=%s, expireSecond=%s]", actionName, actionInfo, expireSecond);
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public ActionInfo getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}

	public Long getExpireSecond() {
		return expireSecond;
	}

	public void setExpireSecond(Long expire_seconds) {
		this.expireSecond = expire_seconds;
	}

}
