# 참! 잘했어요
함께 봉사할 인원을 찾고 정보를 공유하는 비영리 안드로이드앱 '참! 잘했어요'의 백엔드서버입니다.


### 구글 플레이스토어 링크
https://play.google.com/store/apps/details?id=kr.co.jypark.greatjob&hl=ko
### API명세 
https://docs.google.com/spreadsheets/d/1HG6CrYYmG775vy4Ucj91HvoAOLzX6U2HQwYBDX4apBY/edit#gid=0


![images](https://github.com/mohyeonMan/GreatJob/assets/112916714/72ddc658-f874-493b-bb3f-30480edf6867)


## 개발동기
- 봉사활동에 관심은 있지만 스스로 찾고 신청할 정도는 아닌 사람들을 보며,

봉사활동에 대한 접근성과 인식의 개선이 필요함을 느꼈다.

- 실제로 사용가능한 프로그램의 협업개발경험을 통해 

백엔드 서버의 효율성과 구조에 대하여 고민해보고자 하였다.

## 개발형태
- 현직 안드로이드개발자와 협업하여 RestAPI 통신을 위한 백엔드서버의 단독 개발

![개발형태](https://github.com/mohyeonMan/GreatJob/assets/112916714/a78717ad-8386-480d-9b14-7e335190bfa0)


## 개발 환경
- Java 8
- SpringBoot 2.7.6
- Maven
- MyBatis
- MySQL
- STS 4, MySQL Workbench
- heroku, AWS S3
- Git, Github 


## 주요 개발사항
- 무한 대댓글 구현
- AWS S3 Bucket 생성하여 이미지 관리
- QueryOption 클래스를 생성하여 중첩조건 검색기능 구현
- 앱 내에서 우편번호API 사용을 위한 JSP 반환


## ERD
![ERD_CUT](https://github.com/mohyeonMan/GreatJob/assets/112916714/1ebb1a88-b5d6-4692-8030-e2bb8d1c948b)


## Sequence
### 봉사모집 생성

![봉사모집 시퀀스](https://github.com/mohyeonMan/GreatJob/assets/112916714/e24785d1-2d59-4dfa-b03a-f515d9c4a5fe)
 
### 댓글 작성

![대댓글 시퀀스](https://github.com/mohyeonMan/GreatJob/assets/112916714/88c39944-ac8c-44d5-bb84-34b35e82b5d8)


