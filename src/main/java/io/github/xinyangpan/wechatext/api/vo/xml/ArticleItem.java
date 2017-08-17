package io.github.xinyangpan.wechatext.api.vo.xml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ArticleItem {
	
	@JacksonXmlCData
	@JsonProperty("Title")
	private String title;
	
	@JacksonXmlCData
	@JsonProperty("Description")
	private String description;
	
	@JacksonXmlCData
	@JsonProperty("PicUrl")
	private String picUrl;
	
	@JacksonXmlCData
	@JsonProperty("Url")
	private String url;

	@Override
	public String toString() {
		return String.format("ArticleItem [title=%s, description=%s, picUrl=%s, url=%s]", title, description, picUrl, url);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
