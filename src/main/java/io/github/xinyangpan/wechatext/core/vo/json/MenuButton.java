package io.github.xinyangpan.wechatext.core.vo.json;

//button	是	一级菜单数组，个数应为1~3个
//sub_button	否	二级菜单数组，个数应为1~5个
//type	是	菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
//name	是	菜单标题，不超过16个字节，子菜单不超过60个字节
//key	click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
//url	view、miniprogram类型必须	网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。
//media_id	media_id类型和view_limited类型必须	调用新增永久素材接口返回的合法media_id
//appid
//miniprogram类型必须	小程序的appid（仅认证公众号可配置）
//pagepath
//miniprogram类型必须	小程序的页面路径
public class MenuButton {
	private String name;
	private String type;
	private String url;

	@Override
	public String toString() {
		return String.format("MenuButton [name=%s, type=%s, url=%s]", name, type, url);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
