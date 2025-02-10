# MSA 학습을 위한 프로젝트 세트 구성 
### 구성 
- 서버디스커버리 : Eureka
- 로드  밸런싱 : Ribbon
- 서킷  브이커 : resilience4j
- API GateWay

### 실행 환경 구성 방법 
- 인텔리제이 활용 
  - 하나의 인텔리제이 창에서 다수의 프로젝트 관리 
    1. 우측 그래들 진입 
    2. + 버튼을 클릭하여 다수의 프로젝트 추가 (order, project)
  - 다수의 프로젝트 동시 실행 
    - product 프로젝트는 여러개가 실행되어야한다. 
      - 실행 > 구성편집 or 우측상단 run 옆 화살표를 눌러 구성편집 진입 
      - 좌측 ProductApplication 을 복사하여 다수를 배치
        - 이름에 :portNum 을 추가하여 구분
      - 각각의 ProductApplication 에 대한 포트를 지정한다.
        - 포트 설정  
          1. (Input 창이 안보이는 경우만 진행) VM 옵션 추가 창 열기
             - 빌드 및 실행 > 옵션 수정 > Java > VM 옵션 추가 선택
          2. 아래 항목 입력 후 적용
          3. -Dserver.port={portNum} 
    - 우측 상단 실행 UI 를 통해 추가한 애플리케이션들을 각각 실행 

# 시나리오 

### 로드 밸런싱 
1. **Order 서비스 실행**: Order 서비스가 실행되면 Eureka 서버에서 Product 서비스 인스턴스 목록을 가져옵니다.
2. **Product 서비스 호출**: Order 서비스에서 Product 서비스의 정보를 가져오기 위해 FeignClient를 사용하여 호출합니다.
3. **Ribbon을 통한 로드 밸런싱**: FeignClient는 Ribbon을 통해 3개의 Product 인스턴스 중 하나를 선택하여 호출합니다. 이 과정에서 Round Robin 알고리즘을 사용하여 요청을 순차적으로 분배합니다.
4. **응답 처리**: 선택된 Product 인스턴스에서 응답을 받아 Order 서비스에 반환하고, 최종적으로 클라이언트에 응답을 전달합니다.

### 게이트웨이 추가 
