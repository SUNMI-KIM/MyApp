# 모바일 프로그래밍 개인과제

## 고양이 게시판

### 1. 첫번째 페이지 (login) - login.xml
- 사용 layout : RealtiveLayout
- login 버튼을 눌렀을 때 id 와 passWord 정보가 일치하는지 확인 후 일치하면 세번쨰 페이지 일치하지 않으면 로그인 실패 문구 출력
- register 버튼을 누를 시 회원가입 창으로 이동
- lookAround 버튼을 누르면 로그인 하지 않은 상태로 세번째 페이지로 이동
- lookAround 버튼을 로그인 된 상태로 누르면 로그아웃 되고 세번째 페이지로 이동

### 2. 두번째 페이지 (register) - register.xml
- 사용 layout : linearLayout
- id, passWord는 빈칸이여서는 안됨
- 비밀번호는 5자리 이상, 10자 이하 / 숫자와 영어의 조합
- ridio 동의 버튼에 눌러야만 회원가입 가능
- 기존 정보를 불러와 id 중복 검사 기능

### 3. 세번째 페이지 (main) - activity_main.xml
- 사용 layout :   ConstructLayout, linearLayout
- 게시판 사진 6개가 한줄에 2개씩 3줄로 나열
- 회원정보 버튼
* 로그인이 되어있을때 네번째 페이지로 이동
  - 로그인이 안 되어있을때 alertDialog를 통해 회원가입 창으로 이동(yes) 혹은 세번째 페이지에서 머무를 것인지 물어봄(no)
  
### 4. 네번째 페이지 (profile_screen) - profile.xml
- 내정보와 현재 로그인 되어있는 사람의 id를 보여줌

### 5. profile.java
- 전역변수로 로그인한 사람의 정보 저장
- 네번째 페이지 내정보 textView를 바꿔주기 위함
- 회원의 정보저장을 위한 전역변수 HashMap도 있음
