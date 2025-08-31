package com.kobe.oopplussolid.exampleCode.badCase.service;

import com.kobe.oopplussolid.exampleCode.badCase.dto.request.OrderRequest;
import com.kobe.oopplussolid.exampleCode.badCase.repository.ProductRepository;
import com.kobe.oopplussolid.exampleCode.badCase.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.kobe.oopplussolid.exampleCode.badCase.service
 * fileName       : OrderService
 * author         : kobe
 * date           : 2025. 8. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 8. 29.        kobe       최초 생성
 */
// 자주 하는 착각
// "객체지향으로 설계했으니 끝 아닌가?" ❌
@Service
public class OrderService {
	private ProductRepository productRepo;
	private UserRepository userRepo;
	private PaymentService paymentService;
	private EmailService emailService;
	private SmsService smsService;

	public void processOrder(OrderRequest request) {
		// 상품 조회, 결제, 이메일, SMS 등 모든 걸 한 번에...
		// 200줄의 복잡한 로직
	}
}
