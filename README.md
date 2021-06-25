# 1) FSMManager
FSMManager
  
  
## 2) FSM 종류
### 1. Basic FSM
### 2. Squirrel FSM
### 3. Akka FSM
  
  
## 3) FSM 구성도
### 1. Basic FSM
#### 1] 상태 추가
![스크린샷 2021-06-18 오전 9 14 06](https://user-images.githubusercontent.com/37236920/122487505-665a8b80-d016-11eb-9e32-21edc122fa7d.png)
  
#### 2] 상태 삭제
![스크린샷 2021-06-18 오전 9 14 38](https://user-images.githubusercontent.com/37236920/122487536-796d5b80-d016-11eb-856f-caf3c86c6718.png)
  
#### 3] 상태 천이
![스크린샷 2021-06-18 오전 9 16 39](https://user-images.githubusercontent.com/37236920/122487670-c18c7e00-d016-11eb-9ee7-449bfa547fa0.png)
  
### 2. Squirrel 
#### 1] 상태 천이
![스크린샷 2021-06-25 오후 4 16 02](https://user-images.githubusercontent.com/37236920/123386348-87e8e380-d5d1-11eb-827f-47df382f319e.png)
  
  
## 4) API
### 1. addFsmContainer (String name, AbstractFsm abstractFsm, AbstractState abstractState, AbstractEvent abstractEvent)
@brief : 새로운 FSM 을 추가하는 함수 (FSM Container 클래스에 UntypedStateMachineBuilder 와 UntypedStateMachine 를 관리)
@param name : FSM 이름
@param abstractFsm : FSM 로직 클래스
@param abstractState : FSM 상태 정의
@param abstractEvent : FSM 이벤트 정의
  
### 2. removeFsmContainer (String name)
@brief : 지정한 이름의 FSM 을 삭제하는 함수
@param name : FSM 이름
  
### 3. getFsmContainer (String name)
@brief : 지정한 이름의 FSM Container 클래스의 객체를 반환하는 함수
@param name : FSM 이름
  
### 4. setFsmCondition (String name, String from, Strain to, String event)
@brief : 지정한 이름의 FSM 에 새로운 상태 천이 조건을 추가하는 함수
@param name : FSM 이름
@param from : 천이 전 상태 이름
@param to : 천이 후 상태 이름
@param event : 상태 천이를 트리거할 이벤트 이름
  
### 5. setFsmOnEntry (String name, String state, String funcName)
@brief : 지정한 상태 시작 시 실행할 FSM 의 함수를 지정하는 함수
@param name : FSM 이름
@param state : 상태 이름
@param funcName : FSM 함수 이름
  
### 6. setFsmOnExit (String name, String state, String funcName)
@brief : 지정한 상태 종료 시 실행할 FSM 의 함수를 지정하는 함수
@param name : FSM 이름
@param state : 상태 이름
@param funcName : FSM 함수 이름
  
### 7. getFsmCurState (String name)
@brief : 지정한 이름의 FSM 의 현재 상태를 반환하는 함수
@param name : FSM 이름
  
### 8. getFsmLastState (String name)
@brief : 지정한 이름의 FSM 의 바로 이전 상태를 반환하는 함수
@param name : FSM 이름
  
### 9. setFsmFinalState (String name, String state)
@brief : 지정한 이름의 FSM 의 마지막 상태를 지정하는 함수
@param name : FSM 이름
@param state : 마지막 상태 이름
  
### 10. buildFsm (String name, String initState, boolean isDebugMode)
@brief : 지정한 이름의 FSM 을 초기화하여 새로 생성하는 함수
@param name : FSM 이름
@param initState : FSM 초기 상태 이름
@param isDebugMode : FSM 내부 로그 출력 여부
  
### 11. fireFsm (String name, String event, FutureCallBack<Object> callback)
@brief : 지정한 이름의 FSM 에 이벤트를 발생시키는 함수
@param name : FSM 이름
@param event : 발생할 이벤트 이름
@param callback : 이벤트 발생 시 FSM 로직에서 실행할 callback 함수
  
  
