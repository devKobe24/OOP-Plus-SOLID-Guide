package com.kobe.oopplussolid.practiceCode.myCase.infrastructure;

import com.kobe.oopplussolid.practiceCode.myCase.domain.KillNotifier;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.myCase.infrastructure
 * fileName       : GoldNotifier
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
@Component("goldNotifier") // Spring Bean으로 등록하며, "goldNotifier"리는 고유한 이름을 부여합니다.
public class GoldNotifier implements KillNotifier {
	@Override
	public void send(String championName, String message) {
		System.out.println(championName + "을 Kill 했습니다 : " + message);
		// 실제로는 챔피언을 Kill 함으로써 얻는 획득 Gold의 양에 대한 복잡한 로직이 여기에 위치합니다.
	}
}
