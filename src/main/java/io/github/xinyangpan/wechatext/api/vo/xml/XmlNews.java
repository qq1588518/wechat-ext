package io.github.xinyangpan.wechatext.api.vo.xml;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class XmlNews extends Xml {
	@JsonProperty("ArticleCount")
	private int articleCount;
	@JsonProperty("item")
    @JacksonXmlElementWrapper(localName = "Articles")
	private List<ArticleItem> articleItems;

	@Override
	public String toString() {
		return String.format("XmlNews [articleCount=%s, articleItems=%s]", articleCount, articleItems);
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public List<ArticleItem> getArticleItems() {
		return articleItems;
	}

	public void setArticleItems(List<ArticleItem> articleItems) {
		this.articleItems = articleItems;
	}

}
