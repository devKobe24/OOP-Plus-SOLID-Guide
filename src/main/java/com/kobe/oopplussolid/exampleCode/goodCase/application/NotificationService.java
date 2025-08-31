package com.kobe.oopplussolid.exampleCode.goodCase.application;

import com.kobe.oopplussolid.exampleCode.goodCase.domain.Notifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * packageName    : com.kobe.oopplussolid.exampleCode.goodCase.application
 * fileName       : NotificationService
 * author         : kobe
 * date           : 2025. 8. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 30.        kobe       최초 생성
 */
@Service
public class NotificationService {

	private final Map<String, Notifier> notifiers;

	public NotificationService(List<Notifier> notifierList) {
		// Java Stream API를 사용하여 List를 Map으로 효율적으로 변환합니다.
		// 각 Notifier의 클래스 이름에서 "Notifier"를 제외하고 소문자로 만든 값을 Key로 사용합니다.
		// 예: KakaoNotifier -> "kakao"
		this.notifiers = notifierList.stream()
			.collect(Collectors.toMap(
				notifier -> notifier.getClass().getSimpleName().replace("Notifier", "").toLowerCase(),
				Function.identity()
			));
	}

	public void sendNotification(String channel, String recipient, String message) {
		Notifier notifier = notifiers.get(channel);

		if (notifier == null) {
			throw new IllegalArgumentException("지원하지 않는 알림 채널입니다: " + channel);
		}

		System.out.println("알림 발송을 시작합니다... (채널: " + channel + ")");
		notifier.send(recipient, message);
		System.out.println("알림 발송이 완료되었습니다.");
	}
}
