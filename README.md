# 🚀 OOP + SOLID 설계 원칙 실습 프로젝트

## 📖 프로젝트 소개

**"객체지향으로 설계했으니 끝 아닌가?"** 🤔

이 프로젝트는 단순히 객체지향 프로그래밍(OOP)을 사용하는 것과 **SOLID 원칙을 제대로 적용하는 것**의 차이를 명확하게 보여주는 실습 프로젝트입니다.

실제 개발 현장에서 자주 마주치는 문제들을 **Bad Case → Good Case → Practice Case** 순으로 개선해가며, OOP의 4가지 특성과 SOLID의 5가지 원칙이 어떻게 조화를 이루는지 학습할 수 있습니다.

## 🎯 학습 목표

- **OOP 4대 특성**과 **SOLID 5원칙**의 실제 적용 방법 이해
- 설계 원칙을 위반했을 때 발생하는 문제점과 해결 방법 체험
- Spring Framework의 DI 컨테이너를 활용한 의존성 주입 패턴 학습
- 실무에서 바로 적용 가능한 **확장 가능하고 유지보수하기 쉬운 코드** 작성법 습득

## 🛠 기술 스택

- **Java 17**
- **Spring Boot 3.5.5**
- **Gradle 8.14.3**
- **Lombok** (코드 간소화)
- **JUnit 5** (테스트)

## 📁 프로젝트 구조

```
src/main/java/com/kobe/oopplussolid/
├── OOP_AND_SOLID_RELATIONSHIP.md    # 📚 OOP와 SOLID 관계 설명
├── exampleCode/
│   ├── badCase/                     # ❌ SOLID 원칙 위반 사례
│   │   ├── service/OrderService     # 모든 책임이 한 클래스에 집중된 안티패턴
│   │   └── ...
│   └── goodCase/                    # ✅ OOP + SOLID 적용 모범 사례
│       ├── domain/                  # 🎯 도메인 계층 (핵심 비즈니스 규칙)
│       │   └── Notifier            # 추상화된 알림 발송 인터페이스
│       ├── infrastructure/          # 🔧 인프라 계층 (기술 구현)
│       │   ├── KakaoNotifier       # 카카오톡 알림 구현체
│       │   └── SmsNotifier         # SMS 알림 구현체
│       ├── application/             # 💼 애플리케이션 계층 (비즈니스 로직 조합)
│       │   └── NotificationService # 알림 발송 서비스
│       └── presentation/            # 🌐 표현 계층 (외부 인터페이스)
│           └── NotificationController # REST API 컨트롤러
└── practiceCode/                    # 🏋️ 실습 코드
    ├── myCase/                      # 개인 연습 버전
    └── aiCase/                      # AI 개선 버전 (게임 예시)
```

## 🔥 핵심 예시: 알림 시스템

### ❌ Bad Case - SOLID 원칙 위반

```java
@Service
public class OrderService {
    private ProductRepository productRepo;
    private UserRepository userRepo;
    private PaymentService paymentService;
    private EmailService emailService;
    private SmsService smsService;

    public void processOrder(OrderRequest request) {
        // 상품 조회, 결제, 이메일, SMS 등 모든 걸 한 번에...
        // 200줄의 복잡한 로직 💀
    }
}
```

**문제점:**
- **SRP 위반**: 하나의 클래스가 너무 많은 책임을 가짐
- **OCP 위반**: 새로운 알림 채널 추가 시 기존 코드 수정 필요
- **DIP 위반**: 구체적인 구현체에 직접 의존

### ✅ Good Case - OOP + SOLID 적용

#### 1️⃣ 도메인 계층 - 추상화 (OOP) + ISP/DIP (SOLID)

```java
public interface Notifier {
    void send(String recipient, String message);  // 단일 책임만 정의
}
```

#### 2️⃣ 인프라 계층 - 다형성 (OOP) + SRP (SOLID)

```java
@Component("kakaoNotifier")
public class KakaoNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("카카오톡 발송 성공! -> " + recipient + ": " + message);
        // 실제 카카오톡 API 연동 로직
    }
}

@Component("smsNotifier") 
public class SmsNotifier implements Notifier {
    @Override
    public void send(String recipient, String message) {
        System.out.println("SMS 발송 성공! -> " + recipient + ": " + message);
        // 실제 SMS API 연동 로직
    }
}
```

#### 3️⃣ 애플리케이션 계층 - OCP/LSP/DIP (SOLID)

```java
@Service
public class NotificationService {
    private final Map<String, Notifier> notifiers;
    
    public NotificationService(List<Notifier> notifierList) {
        // Spring이 모든 Notifier 구현체를 자동 주입
        this.notifiers = notifierList.stream()
            .collect(Collectors.toMap(/* ... */));
    }
    
    public void sendNotification(String channel, String recipient, String message) {
        Notifier notifier = notifiers.get(channel);
        notifier.send(recipient, message);  // 다형성 활용
    }
}
```

## 🎮 실습: 게임 챔피언 처치 시스템

알림 시스템을 이해했다면, 이제 **게임 도메인**으로 연습해보세요!

```java
// 도메인 - 보상 정책 추상화
public interface KillRewardPolicy {
    void apply(String championName, String killedChampionName);
}

// 인프라 - 구체적인 보상 구현
@Component("gold")
public class GoldReward implements KillRewardPolicy { /* ... */ }

@Component("experience") 
public class ExperienceReward implements KillRewardPolicy { /* ... */ }

// API 호출 예시
// POST /kill-event?rewardType=gold&killer=야스오&killed=티모
```

## 🚀 실행 방법

### 1. 프로젝트 클론 및 실행

```bash
# 프로젝트 클론
git clone <repository-url>
cd oopPlusSOLID

# 애플리케이션 실행
./gradlew bootRun
```

### 2. API 테스트

```bash
# 카카오톡 알림 발송
curl -X POST "http://localhost:8080/send-notification" \
  -d "channel=kakao&to=010-1234-5678&message=쿠폰이 발급되었습니다!"

# SMS 알림 발송  
curl -X POST "http://localhost:8080/send-notification" \
  -d "channel=sms&to=010-1234-5678&message=주문이 완료되었습니다!"

# 게임 처치 보상 (골드)
curl -X POST "http://localhost:8080/kill-event" \
  -d "rewardType=gold&killer=야스오&killed=티모"
```

## 📚 학습 포인트

### 🔍 OOP 4대 특성 적용 사례

| 특성 | 적용 예시 | 코드 위치 |
|------|----------|-----------|
| **추상화** | `Notifier` 인터페이스로 알림 발송 개념 추상화 | `domain/Notifier.java` |
| **상속** | `Notifier` 인터페이스 구현 (`implements`) | `infrastructure/*.java` |
| **다형성** | 동일한 `send()` 호출로 다양한 방식 실행 | `NotificationService.java` |
| **캡슐화** | 각 구현체가 내부 로직을 숨김 | 모든 구현 클래스 |

### 🎯 SOLID 5원칙 적용 사례

| 원칙 | 적용 예시 | 효과 |
|------|----------|------|
| **SRP** | `KakaoNotifier`는 카카오톡 발송만 담당 | 수정 이유가 명확함 |
| **OCP** | 새 알림 채널 추가 시 기존 코드 수정 불필요 | 확장성 확보 |
| **LSP** | 모든 Notifier 구현체가 동일하게 동작 | 신뢰성 보장 |
| **ISP** | `Notifier`는 `send()` 메서드만 정의 | 불필요한 의존성 제거 |
| **DIP** | 상위 계층이 인터페이스에만 의존 | 결합도 감소 |

## 💡 확장 실습 과제

1. **새로운 알림 채널 추가**
   - `AppPushNotifier` 구현하고 기존 코드 수정 없이 동작 확인

2. **비동기 알림 처리**
   - `@Async` 적용하여 성능 개선

3. **알림 전송 로그**
   - AOP를 활용한 횡단 관심사 분리

4. **테스트 코드 작성**
   - Mock을 활용한 단위 테스트 작성

## 🤝 기여하기

이 프로젝트는 학습 목적으로 만들어졌습니다. 더 좋은 예시나 설명이 있다면 언제든 PR을 보내주세요!

---

**"객체지향으로 설계했으니 끝?"** ❌  
**"OOP + SOLID로 설계했으니 진짜 끝!"** ✅

---

**BMC CREW / WAN TEAM**