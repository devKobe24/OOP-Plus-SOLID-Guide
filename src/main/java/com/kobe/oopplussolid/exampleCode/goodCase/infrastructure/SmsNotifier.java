package com.kobe.oopplussolid.exampleCode.goodCase.infrastructure;

import com.kobe.oopplussolid.exampleCode.goodCase.domain.Notifier;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.kobe.oopplussolid.exampleCode.goodCase.infrastructure
 * fileName       : SmsNotifier
 * author         : kobe
 * date           : 2025. 8. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 29.        kobe       최초 생성
 */
@Component("smsNotifier") // "smsNotifier"라는 고유한 이름을 부여합니다.
public class SmsNotifier implements Notifier {
	@Override
	public void send(String recipient, String message) {
		System.out.println("SMS 발송 성공! -> " + recipient + ": " + message);
		// 실제로는 외부 SMS API와 연동하는 로직이 여기에 위치합니다.
	}
}
