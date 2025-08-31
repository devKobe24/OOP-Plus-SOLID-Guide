package com.kobe.oopplussolid.practiceCode.aiCase.appilcation;

import com.kobe.oopplussolid.practiceCode.aiCase.domain.KillRewardPolicy;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.aiCase.appilcation
 * fileName       : ChampionKillService
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
// 🚀 [개선] 클래스 이름 변경: '알림'이 아닌 '챔피언 처지' 서비스
@Service
public class ChampionKillService {

	// 🚀 [개선] Spring DI를 통해 Map을 직접 주입받는 전략 패턴 적용
	// Spring이 @Component의 이름("gold", "experience")을 Key로 , 해당 Bean 객체를 Value로 하여 Map을 자동으로 만들어줍니다.
	private final Map<String, KillRewardPolicy> rewardPolicies;

	public ChampionKillService(Map<String, KillRewardPolicy> rewardPolicies) {
		this.rewardPolicies = rewardPolicies;
	}

	// 🚀 [개선] 메서드 및 파라미터 이름 변경: 도메인 용어와 일치
	public void processKillReward(String rewardType, String championName, String killedChampionName) {
		KillRewardPolicy policy = rewardPolicies.get(rewardType);

		if (policy == null) {
			throw new IllegalArgumentException("지원하지 않는 보상 종류입니다: " + rewardType);
		}

		System.out.printf(">> %s가 %s를 처지했습니다! 보상 처리를 시작합니다...%n", championName, killedChampionName);
		policy.apply(championName, killedChampionName);
	}
}
