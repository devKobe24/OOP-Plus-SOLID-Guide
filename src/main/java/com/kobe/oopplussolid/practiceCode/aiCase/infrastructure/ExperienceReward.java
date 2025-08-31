package com.kobe.oopplussolid.practiceCode.aiCase.infrastructure;

import com.kobe.oopplussolid.practiceCode.aiCase.domain.KillRewardPolicy;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.aiCase.infrastructure
 * fileName       : ExperienceReward
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
@Component("experience")
public class ExperienceReward implements KillRewardPolicy {
	@Override
	public void apply(String championName, String killedChampionName) {
		int exp = 150; // 실제로는 복잡한 경험치 계산 로직
		System.out.printf("✨ %s가 %s를 처지하여 경험치 %d를 획득했습니다!%n", championName, killedChampionName, exp);
	}
}
