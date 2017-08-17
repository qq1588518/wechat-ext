package io.github.xinyangpan.wechatext.core.vo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConditionalMenuBar extends MenuBar {
	@JsonProperty("matchrule")
	private MatchRule matchRule;

	@Override
	public String toString() {
		return String.format("MenuBar [button=%s, matchRule=%s]", this.getButton(), matchRule);
	}

	public MatchRule getMatchRule() {
		return matchRule;
	}

	public void setMatchRule(MatchRule matchRule) {
		this.matchRule = matchRule;
	}

}
