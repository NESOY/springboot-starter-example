## Spring boot Custom Starter
#### Goals
- Springboot Starter를 만들면서 어떻게 구성되어 있는지 이해해봅시다.

#### 멀티 모듈로 프로젝트를 구성해봅시다.
- 우리에게 필요한 모듈은 총 3가지입니다.
    - 자동 환경설정 모듈
    - 자동 환경설정을 포함한 모듈
    - Starter를 테스트 하려는 Web Application
- [모듈의 이름을 작성하기 전에 주의해야 할점들이 있습니다.](https://docs.spring.io/autorepo/docs/spring-boot/2.0.0.M3/reference/html/boot-features-developing-auto-configuration.html#boot-features-custom-starter-naming)
    - Spring에서는 모듈의 이름을 `spring-boot`로 시작하지 않을 것을 권하고 있습니다.
    - 아래와 같이 앞에 다른 이름을 붙이기를 권하고 있습니다.
        - `nesoy-spring-boot-autoconfigure`
        - `nesoy-spring-boot-starter`
- 멀티 모듈로 프로젝트 구성하기
    - [Maven으로 구성해보기](https://taetaetae.github.io/2020/01/19/spring-boot-maven-multi-module/)
    - [Gradle로 구성해보기](https://jojoldu.tistory.com/123)
    
- 구성하면 다음과 같은 모습을 볼 수 있습니다.
```shell script
.
├── build.gradle
├── nesoy-spring-boot-autoconfigure -> 자동 환경설정을 위한 모듈
│   ├── build.gradle
│   └── src
├── nesoy-spring-boot-starter-example -> 자동 환경설정을 포함한 모듈
│   └── build.gradle
├── nesoy-spring-boot-starter-web -> 실제로 우리가 사용하는 어플리케이션
│   ├── build.gradle
│   └── src
└── settings.gradle
```

## 자동 환경설정을 위한 모듈 셋팅
- 의존성 추가하기
```shell script
compile group: 'org.springframework.boot', name: 'spring-boot-autoconfigure', version: '2.3.0.RELEASE'
```

```java
@ConfigurationProperties(prefix = "nesoy")
public class NesoyProperties {

    private String log;

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
```

## 자동 환경설정을 포함한 모듈 셋팅

## 우리가 만든 Starter 사용해보기


## Reference
- <https://forward.nhn.com/2019/seoul/hands-on-labs/java.spring-boot-custom-starter/index.html>
- <https://supawer0728.github.io/2018/03/15/create-spring-boot-starter/>
- <http://blog.kingbbode.com/posts/spring-conditional>
