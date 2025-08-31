package com.kobe.oopplussolid.practiceCode.aiCase.presentation;

import com.kobe.oopplussolid.practiceCode.aiCase.appilcation.ChampionKillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.aiCase.presentation
 * fileName       : KillEventController
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
// 🚀 [개선] Controller 이름 및 파라미터 이름 변경
@RestController
@RequiredArgsConstructor
public class KillEventController {

	private final ChampionKillService championKillService;

	// 예시 API: /kill-event?rewardType=gold&killer=야스오&killed=티모
	@PostMapping("/kill-event")
	public String onChampionKilled(@RequestParam String rewardType,
	                               @RequestParam String killer,
	                               @RequestParam String killed) {
		championKillService.processKillReward(rewardType, killer, killed);
		return "처치 이번트 처리 성공!";
	}
}
