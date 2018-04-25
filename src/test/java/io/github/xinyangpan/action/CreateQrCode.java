package io.github.xinyangpan.action;

import org.junit.Test;

import io.github.xinyangpan.wechatext.core.vo.json.QrCode;

public class CreateQrCode extends AbstractAction {

	@Test
	public void qrCode() throws Exception {
		// 
		QrCode permanent = QrCode.permanent(3);
		System.out.println(qrCodeApi.create(permanent));
	}

}
