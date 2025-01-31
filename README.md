# best-practice-java-spring-boot

이 프로젝트는 Java 기반의 Spring Boot 오픈소스 템플릿 프로젝트이다.

## Summary

## 배경과 목적

이 템플릿 프로젝트의 목표는 간단한 Spring Boot 애플리케이션 아키텍처에 추가 구성 요소를 통합할 때 참조하거나, 직접 사용할 수 있는 모범 사례 예제를 제공하며 프로젝트 설정을 간소화한다. 체크된 체크박스는 현재까지 완료된 부분을 의미한다.

### Code

- [x] 글로벌 에러 핸들러를 이용한 예외 처리
- [x] Envelope-pattern
- [x] JPA와 Hibernate ORM 통합
- [x] Spring Security ACL

### Configuration For AWS Cloud Deployment (a.k.a. ECS)

- [ ] Dockerfile
- [ ] CloudFormation (SAM) YAML

이 템플릿을 사용하면 개발자는 클라우드 배포에 필요한 모든 구성 요소를 갖춘 견고한 Spring Boot 애플리케이션을 신속하게 설정할 수 있다.
