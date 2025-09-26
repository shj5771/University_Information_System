<img width="609" height="517" alt="image" src="https://github.com/user-attachments/assets/b7e783fa-feb5-4f88-a59a-a9e0b34d886e" />##  프로젝트 개요
본 프로젝트는 **대학 학사정보시스템(UIS)** 을 구현한 것으로,  
교수·학생·직원 등 대학 구성원의 학사 관리와 수강신청 업무를 효율화하기 위해 설계되었다.

- **개발 목적**: 수기 행정 처리 과정을 소프트웨어화하여 효율성 및 편의성 향상  
- **개발 방식**: V-Model 개발 프로세스와 테스트 절차 준수  
- **UI**: Java Swing 기반 GUI 제공  

---

##  주요 기능

###  사용자 관리
- 초기 ID/PW 기반 로그인 (교수·학생·학사 담당자·수업 담당자 구분)  
- 사용자 등록, 수정, 삭제 및 조회  
- 비밀번호 변경 (7자리 영문+숫자 조합)  

###  수업 및 수강 관리
- 학생: 수강신청, 조회, 취소, 수강료 확인  
- 교수: 성적 입력, 출석부 조회, 수강생 정보 확인  
- 수업 담당자: 강좌 등록, 학기별 강의 개설, 수강 가능 인원 지정, 수강료 청구서 발급  

###  시스템 제약
- 최대 18학점 제한  
- 수강 가능 인원 초과 시 신청 불가  

##  개발 환경
- **언어**: Java (JDK 8+)  
- **GUI**: Java Swing  
- **IDE**: NetBeans / Eclipse  
- **버전관리**: Git (형상 관리 적용)  

---


## 시스템 화면 예시

### 학생 사용자UI

#### 로그인 화면
<img width="483" height="323" alt="image" src="https://github.com/user-attachments/assets/026ad548-6909-4de3-b1ab-57da16922052" />


#### 수강신청 화면
<img width="432" height="375" alt="image" src="https://github.com/user-attachments/assets/17a76baf-e809-49cd-b7bd-1728ed6bb639" />


### 교수 사용자UI

#### 출석부 관리
<img width="439" height="370" alt="image" src="https://github.com/user-attachments/assets/6ec0a157-d947-4658-9305-679c52f1aea2" />

#### 성적 부여
<img width="450" height="341" alt="image" src="https://github.com/user-attachments/assets/d0e69ec0-482a-43fb-bd53-0a8be1957ffa" />


### 수업 담당자UI

#### 강좌 등록
<img width="609" height="517" alt="image" src="https://github.com/user-attachments/assets/55da9228-c586-4f53-8b31-907f646f3b7a" />


#### 강좌 개설
<img width="910" height="342" alt="image" src="https://github.com/user-attachments/assets/cc71725c-c101-40fb-ad8f-eb21fcd994d1" />

#### 수강료 청구
<img width="544" height="497" alt="image" src="https://github.com/user-attachments/assets/f1577deb-7dbb-4bf8-b6f4-5e3b181ed5ae" />



### 학사 담당자UI

#### 학생/교수 정보조회,수정,삭제
<img width="906" height="301" alt="image" src="https://github.com/user-attachments/assets/8e3b60c8-4c89-4fd7-8a9f-6c68be22e243" />

##  프로젝트 평가

- **완성도**: 요구사항 100% 충족  
- **일정 관리**: 후반 집중 개발로 어려움 존재  
- **설계 요소**: 클라이언트-서버 구조 설계, UML 클래스 다이어그램 활용  
- **제한 조건**: IDE·형상관리·테스팅 적용, Java SE 기반 구현
  
- ##  배운 점 & 소감

- 자바 스윙을 통한 GUI 제작 경험  
- 요구사항 정의의 중요성 체감 (요구사항 → 설계 → 구현 단계의 연계성 확인)  
- 객체지향적 설계와 실제 구현 간의 차이를 경험하며 유지보수성의 중요성 학습
