package com.kobe.oopplussolid.exampleCode.goodCase.infrastructure;

import com.kobe.oopplussolid.exampleCode.goodCase.domain.Notifier;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.kobe.oopplussolid.exampleCode.goodCase.infrastructure
 * fileName       : KakaoNotifier
 * author         : kobe
 * date           : 2025. 8. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 29.        kobe       최초 생성
 */
@Component("kakaoNotifier") // Spring Bean으로 등록하며, "kakaoNotifier"라는 고유한 이름을 부여합니다.
public class KakaoNotifier implements Notifier {
	@Override
	public void send(String recipient, String message) {
		System.out.println("카카오톡 발송 성공! -> " + recipient + ": " + message);
		// 실제로는 외부 카카오톡 API와 연동하는 복잡한 로직이 여기에 위치합니다.
	}
}
