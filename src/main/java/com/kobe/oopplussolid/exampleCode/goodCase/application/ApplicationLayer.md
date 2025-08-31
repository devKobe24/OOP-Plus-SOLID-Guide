## 3. 애플리케이션 계층 (Application Layer) - 기능 실행

사용자의 요청을 받아 도메인 객체들을 사용하여 실제 비즈니스 로직을 실행하는 서비스 계층입니다.

---

## 💻 코드 예시에서 보는 OOP + SOLID

### ✅ SOLID - OCP (개방-폐쇄 원칙)
* 나중에 '앱 추시 알림' 기능이 새로 생겨도, 우리는 `AppPushNotifier`라는 클래스를 새로 만들기만 하면 됩니다.
* `NotificationService`의 코드는 **단 한 줄도 수정할 필요가 없습니다.**
  * 이것이 바로 **"확장에는 열려 있고, 변경에는 닫혀 있다"** 는 OCP의 핵심입니다.

### ✅ SOLID - DIP (의존관계 역전 원칙)
* `NotificationService`는 `KakaoNotifier` 같은 하위 수준의 구체적인 모듈에 의존하지 않고, `Notifier`라는 **"추상화"** 에만 의존하고 있습니다.

### ✅ SOLID - LSP (리스코프 치환 원칙)
* `notifiers.get(channel)`을 통해 얻은 객체가 `KakaoNotifier`이든 `SmsNotifier`이든, `Notifier`의 역할을 완벽하게 수행(치환)할 수 있으므로, `notifier.send()` 코드는 문제없이 항상 동일하게 동작합니다.

#### 1️⃣ NotificationService.java
* **1. SOLID - DIP :**
  * 구체적인 Notifier 클래스들이 아닌, Notifier 인터페이스에만 의존합니다.
  * Spring이 @Component로 등록된 모든 Notifier 구현체들을 이 Map에 자동으로 주입해줍니다.
  * Key: Bean 이름("kakaoNotifier", "smsNotifier"), Value: 해당 Bean 객체
* **2. SOLID - OCP :**
  * `sendNotification(String channel, String recipient, String message)` 메서드는 어떤 알림 채널이든 동일한 방식으로 처리합니다.
  * 나중에 `AppPushNotifier`가 추가되더라도, 이 메서드의 코드는 단 한 줄도 수정할 필요가 없습니다.
    * **이것이 바로 "확장에는 열려 있고, 변경에는 닫혀 있다"는 OCP의 힘입니다.**
* **3. SOLID - LSP :**
  * `notifiers.get(channel)`을 통해 얻은 객체가 `KakaoNotifier`이든 `SmsNotifier`이든, `Notifier`의 역할을 완벽하게 수행하므로, 클라이언트 코드는 문제없이 동작합니다.

