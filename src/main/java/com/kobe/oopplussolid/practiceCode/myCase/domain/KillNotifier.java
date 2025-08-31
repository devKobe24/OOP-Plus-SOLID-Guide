package com.kobe.oopplussolid.practiceCode.myCase.domain;

/**
 * packageName    : com.kobe.oopplussolid.practiceCode.myCase.domain
 * fileName       : WeaponNotifier
 * author         : kobe
 * date           : 2025. 8. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 31.        kobe       최초 생성
 */
public interface KillNotifier {
	void send(String championName, String message);
}
