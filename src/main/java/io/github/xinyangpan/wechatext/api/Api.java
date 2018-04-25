package io.github.xinyangpan.wechatext.api;

public class Api {

	private CoreApi coreApi;
	private MenuApi menuApi;
	private MessageApi messageApi;
	private QrCodeApi qrCodeApi;
	private TagApi tagApi;

	public CoreApi core() {
		return coreApi;
	}

	public MenuApi menu() {
		return menuApi;
	}

	public MessageApi message() {
		return messageApi;
	}

	public QrCodeApi qrCode() {
		return qrCodeApi;
	}

	public TagApi tag() {
		return tagApi;
	}

	@Override
	public String toString() {
		return String.format("Api [coreApi=%s, menuApi=%s, messageApi=%s, qrCodeApi=%s, tagApi=%s]", coreApi, menuApi, messageApi, qrCodeApi, tagApi);
	}

	public CoreApi getCoreApi() {
		return coreApi;
	}

	public void setCoreApi(CoreApi coreApi) {
		this.coreApi = coreApi;
	}

	public MenuApi getMenuApi() {
		return menuApi;
	}

	public void setMenuApi(MenuApi menuApi) {
		this.menuApi = menuApi;
	}

	public MessageApi getMessageApi() {
		return messageApi;
	}

	public void setMessageApi(MessageApi messageApi) {
		this.messageApi = messageApi;
	}

	public QrCodeApi getQrCodeApi() {
		return qrCodeApi;
	}

	public void setQrCodeApi(QrCodeApi qrCodeApi) {
		this.qrCodeApi = qrCodeApi;
	}

	public TagApi getTagApi() {
		return tagApi;
	}

	public void setTagApi(TagApi tagApi) {
		this.tagApi = tagApi;
	}

}
