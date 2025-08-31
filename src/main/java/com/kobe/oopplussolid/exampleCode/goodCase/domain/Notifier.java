package com.kobe.oopplussolid.exampleCode.goodCase.domain;

/**
 * packageName    : com.kobe.oopplussolid.exampleCode.goodCase.domain
 * fileName       : Notifier
 * author         : kobe
 * date           : 2025. 8. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 29.        kobe       최초 생성
 */
public interface Notifier {
	void send(String recipient, String message);
}
