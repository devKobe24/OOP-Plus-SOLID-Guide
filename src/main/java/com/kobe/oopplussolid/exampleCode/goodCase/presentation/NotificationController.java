package com.kobe.oopplussolid.exampleCode.goodCase.presentation;

import com.kobe.oopplussolid.exampleCode.goodCase.application.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.kobe.oopplussolid.exampleCode.goodCase.presentation
 * fileName       : NotificationController
 * author         : kobe
 * date           : 2025. 8. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 30.        kobe       최초 생성
 */
@RestController
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 만들어줍니다 (생성자 주입).
public class NotificationController {

	private final NotificationService notificationService;

	// 예시 API: /send-notification?channel=kakao&to=010-1234-5678&message=쿠폰이 발급되었습니다!
	@PostMapping("/send-notification")
	public String sendNotification(@RequestParam String channel,
                                 @RequestParam String to,
	                             @RequestParam String message) {
		notificationService.sendNotification(channel, to, message);
		return "알림 발송 요청 성공!";
	}

}
