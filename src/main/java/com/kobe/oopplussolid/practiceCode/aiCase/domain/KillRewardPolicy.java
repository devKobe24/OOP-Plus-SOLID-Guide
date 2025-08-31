package com.kobe.oopplussolid.practiceCode.aiCase.domain;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.aiCase.domain
 * fileName       : KillRewardPolicy
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
// 🚀 [개선] 인터페이스 이른 변경: '알림기(Notifier)'가 아닌 '보상 정책(Reward Policy)'이라는 역할 명시
public interface KillRewardPolicy {
	// 🚀 [개선] 메서드 이름 변경: '보낸다(send)'가 아닌 '적용한다(apply)'는 의미
	void apply(String championName, String killedChampionName);
}
