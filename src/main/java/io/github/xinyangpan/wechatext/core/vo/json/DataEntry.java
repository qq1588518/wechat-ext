package io.github.xinyangpan.wechatext.core.vo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DataEntry {
	private String value;
	private String color;

	public static DataEntry entry(String value) {
		DataEntry dataEntry = new DataEntry();
		dataEntry.setValue(value);
		return dataEntry;
	}

	public static DataEntry entry(String value, String color) {
		DataEntry dataEntry = new DataEntry();
		dataEntry.setValue(value);
		dataEntry.setColor(color);
		return dataEntry;
	}

	@Override
	public String toString() {
		return String.format("DataEntry [value=%s, color=%s]", value, color);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
