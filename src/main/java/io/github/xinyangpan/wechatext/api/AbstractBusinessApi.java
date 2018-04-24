package io.github.xinyangpan.wechatext.api;

public class AbstractBusinessApi extends AbstractApi {

	protected CoreApi coreApi;

	public CoreApi getCoreApi() {
		return coreApi;
	}

	public void setCoreApi(CoreApi coreApi) {
		this.coreApi = coreApi;
	}

}
