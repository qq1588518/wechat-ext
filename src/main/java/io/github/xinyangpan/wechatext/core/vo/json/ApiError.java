package io.github.xinyangpan.wechatext.core.vo.json;

public class ApiError {

	protected Integer errcode;
	protected String errmsg;

	@SuppressWarnings("unchecked")
	public <T extends ApiError> T throwExceptionIfError() {
		if (errcode != null && errcode != 0) {
			throw new RuntimeException(this.toString());
		}
		return (T) this;
	}

	@Override
	public String toString() {
		return String.format("ApiError [errcode=%s, errmsg=%s]", errcode, errmsg);
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
