package com.kobe.oopplussolid.practiceCode.myCase.application;

import com.kobe.oopplussolid.exampleCode.goodCase.domain.Notifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.myCase.application
 * fileName       : NotificationService
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
@Service
public class NotificationService {

	private final Map<String, Notifier> notifiers;

	public NotificationService(List<Notifier> notifierList) {
		this.notifiers = notifierList.stream()
			.collect(Collectors.toMap(
				notifier -> notifier.getClass().getSimpleName().replace("KillNotifier", "").toLowerCase(), Function.identity()));
	}

	public void sendNotification(String channel, String champion, String message) {
		Notifier notifier = notifiers.get(channel);

		if (notifier == null) {
			throw new IllegalArgumentException("지원하지 않는 알림 채널입니다: " + channel);
		}
		notifier.send(champion, message);
	}
}
