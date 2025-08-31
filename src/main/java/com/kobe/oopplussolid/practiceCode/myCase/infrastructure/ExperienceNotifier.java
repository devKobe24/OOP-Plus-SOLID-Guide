package com.kobe.oopplussolid.practiceCode.myCase.infrastructure;

import com.kobe.oopplussolid.practiceCode.myCase.domain.KillNotifier;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.myCase.infrastructure
 * fileName       : ExperienceNotifier
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
@Component("experienceNotifier")
public class ExperienceNotifier implements KillNotifier {
	@Override
	public void send(String championName, String message) {
		System.out.println(championName + "을 Kill 했습니다 : " + message);
		// 실제로는 챔피언을 kill 함으로써 얻는 경험치에 대한 복잡한 로직이 여기에 위치합니다.
	}
}
