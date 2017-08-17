package io.github.xinyangpan.wechatext.api.vo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//touser	是	接收者openid
//template_id	是	模板ID
//url	否	模板跳转链接
//miniprogram	否
//跳小程序所需数据，不需跳小程序可不用传该数据
//appid	是
//所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系）
//pagepath	是
//所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar）
//data	是	模板数据
//color	否	模板内容字体颜色，不填默认为黑色
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
public class TemplateMessage<T> {
	private String touser;
	private String templateId;
	private String url;
	private T data;

	@Override
	public String toString() {
		return String.format("TemplateMessage [touser=%s, templateId=%s, url=%s, data=%s]", touser, templateId, url, data);
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
