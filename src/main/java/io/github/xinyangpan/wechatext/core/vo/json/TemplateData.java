package io.github.xinyangpan.wechatext.core.vo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TemplateData {
	// 
	private DataEntry first;
	private DataEntry keyword1;
	private DataEntry keyword2;
	private DataEntry keyword3;
	private DataEntry keyword4;
	private DataEntry keyword5;
	private DataEntry keyword6;
	private DataEntry keyword7;
	private DataEntry keyword8;
	private DataEntry keyword9;
	private DataEntry remark;

	@Override
	public String toString() {
		return String.format("TemplateData [first=%s, keyword1=%s, keyword2=%s, keyword3=%s, keyword4=%s, keyword5=%s, keyword6=%s, keyword7=%s, keyword8=%s, keyword9=%s, remark=%s]", first, keyword1, keyword2, keyword3, keyword4, keyword5, keyword6, keyword7, keyword8, keyword9, remark);
	}

	public DataEntry getFirst() {
		return first;
	}

	public void setFirst(DataEntry first) {
		this.first = first;
	}

	public DataEntry getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(DataEntry keyword1) {
		this.keyword1 = keyword1;
	}

	public DataEntry getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(DataEntry keyword2) {
		this.keyword2 = keyword2;
	}

	public DataEntry getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(DataEntry keyword3) {
		this.keyword3 = keyword3;
	}

	public DataEntry getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(DataEntry keyword4) {
		this.keyword4 = keyword4;
	}

	public DataEntry getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(DataEntry keyword5) {
		this.keyword5 = keyword5;
	}

	public DataEntry getKeyword6() {
		return keyword6;
	}

	public void setKeyword6(DataEntry keyword6) {
		this.keyword6 = keyword6;
	}

	public DataEntry getKeyword7() {
		return keyword7;
	}

	public void setKeyword7(DataEntry keyword7) {
		this.keyword7 = keyword7;
	}

	public DataEntry getKeyword8() {
		return keyword8;
	}

	public void setKeyword8(DataEntry keyword8) {
		this.keyword8 = keyword8;
	}

	public DataEntry getKeyword9() {
		return keyword9;
	}

	public void setKeyword9(DataEntry keyword9) {
		this.keyword9 = keyword9;
	}

	public DataEntry getRemark() {
		return remark;
	}

	public void setRemark(DataEntry remark) {
		this.remark = remark;
	}
	
}
