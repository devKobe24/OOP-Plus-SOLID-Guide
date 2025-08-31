package com.kobe.oopplussolid.practiceCode.aiCase.infrastructure;

import com.kobe.oopplussolid.practiceCode.aiCase.domain.KillRewardPolicy;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.aiCase.infrastructure
 * fileName       : GoldReward
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
// 🚀 [개선] 클래스 이름 변경 및 @Component 이름 명시
@Component("gold")
public class GoldReward implements KillRewardPolicy {
	@Override
	public void apply(String championName, String killedChampionName) {
		int gold = 300; // 실제로는 복잡한 골드 계산 로직
		System.out.printf("💰 %s가 $s를 처치하여 $d 골드를 획득했습니다!%n", championName, killedChampionName, gold);
	}
}
