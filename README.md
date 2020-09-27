# ibwa-android

# 화면의 전체적 구조
MainActivity: 상단에는 프래그먼트, 하단에는 메뉴바(맞춤추천, 커튼, 타이머) 
-> 상단 프래그먼트화면이 메뉴바의 선택에 맞게 변함.

프래그먼트
  - Recommended (맞춤추천)
  - Curtain (커튼)
  - Timer (타이머)


# HY
### 맞춤 추천 화면


# MK
### 타이머 화면
타이머가 존재할 경우

타이머가 존재하지 않을 경우
(타이머는 RecyclerView를 통해 화면에 띄움.)
// 아직 구현 안함.

### 타이머 추가 화면
TimerAddActivity의 화면은 시간 설정을 위한 타임피커(원래는 넘버피커로 사용하였으나 그 부분보다 화면 설계가 더 급해서
사용을 미룸.)와 요일반복을 위한 토글버튼들, 프래그먼트를 위한 탭, 프래그먼트를 띄우는 레이아웃으로 구성.
Timer.java: 타이머 클래스

- 타이머들이 생성되면 일종의 리스트처럼 처리해주는 부분 (즉, 생성된 타이머들을 예쁘게 나열해주는 부분)
  - TimerRecyclerViewAdapter.java: 각 타이머 뷰들 생성하는 기능을 함.
  - TimerViewHolder.java: 화면에 표시될 타이머 아이템들을 저장해줌
  - timer_item.xml: 각 타이머 아이템들이 보여지는 형태 지정.
    -> 현재는 fragment_timer_list.xml에 타이머의 리사이클러뷰가 보여짐. (fragment_timer.xml에 보여주고 싶은것임.)
    -> 일단은 fragment_timer_list.xml을 보이도록 해놓았음. (수정필요.)
  - OnToggleTimerListener.java: (?)
    -> 공부 후 추가

- 타이머 DB관련 (Room이라는 구글 공식 ORM 라이브러리를 통해 사용.) 
  - TimerDao.java
  - TimerDatabase.java
  - TimerRepository.java
  - TimerListViewModel.java
  - CreateTimerViewModel.java
    -> 공부 후 추가

- 서비스 제공
  - RecheduleTimersService.java
  - TimerService.java
    -> 공부 후 추가

- 부가적인 파일
  - TimerPickerUtil.java: 타임피커에서 값을 받아오는 메서드가 안드로이드 버전에 따라서 다르기때문에 추가로 만들어준 클래스
  - DayUtil.java: 예제를 보고 만들어두었던 파일로 필요없을것이라고 생각됨. (삭제 요말)


[참고자료 - 알람 앱 예제](https://papago.naver.net/website?locale=ko&source=en&target=ko&url=https%3A%2F%2Flearntodroid.com%2Fhow-to-create-a-simple-alarm-clock-app-in-android%2F)

- 할 일
  - RecyclerView 공부
  - Room 공부
