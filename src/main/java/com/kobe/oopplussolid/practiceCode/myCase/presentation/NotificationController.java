package com.kobe.oopplussolid.practiceCode.myCase.presentation;

import com.kobe.oopplussolid.practiceCode.myCase.application.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.myCase.presentation
 * fileName       : NotificationController
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class NotificationController {

	private final NotificationService notificationService;

	@PostMapping("/send-notification")
	public String sendNotification(@RequestParam String channel,
                                   @RequestParam String champion,
	                               @RequestParam String message) {
		notificationService.sendNotification(channel, champion, message);
		return "알림 발송 요청 성공!";
	}
}
