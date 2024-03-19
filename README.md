# 게시판(bulletin Table 구축)
![image](https://github.com/rlaaudgjs2/Travel_app/assets/68803644/54895f10-c724-4833-941d-1a70eb7d2cc7)

  ## bulletin테이블을 다음과 같이 만듬
  
  - user 테이블에서 userID primary키로 변경
  -for_ID는 외래키로 설정(1. bullet Table 클릭 2. 상단에 구조 누르기 3. 릴레이션 뷰 클릭 4. 제약 사항 기본으로 놓고 컬럼명은 for_ID, 데이터베이스 user 테이블 user 컬럼명 userID로 만들기 
  ![image](https://github.com/rlaaudgjs2/Travel_app/assets/68803644/4264cb79-32bd-4e4f-aac4-34e8ecee984d)


   - Kotlin 코드는 커밋한 것 확인. 
   - bulletin.php파일 htdocs에 넣기( 카카오톡 방에 올림)


  
![image](https://github.com/rlaaudgjs2/Travel_app/assets/68803644/66f6f73c-8f3b-42d0-a5a3-8e2f836c1157)

   이렇게 작성하고 등록한뒤, 다시 글쓰기를 들어가면 전에 작성한 내용이 그대로 있음


 # 상세 게시판(Day Table 구축)
 ![image](https://github.com/rlaaudgjs2/Travel_app/assets/68803644/cbe954b0-93b3-4128-a6da-f4277e2b0934)
  - 테이블 이름 : day
  - 깃허브에 올린 부분(상세 게시판 데이터베이스 구축) 확인
  - 위의 사진과 같이 키 설정
  - 이미지 파일 인코딩 하여 BLOB에 저장.
  - 추후 게시판 가져올 때 디코딩해야 사진 확인 가능
  - day.php는 톡방 공유 예정




# 규원 / 구글 플레이스 API를 이용해 장소 검색 후 장소 이름, id, 지역, 카테고리 가져오기

TestAPIFragment 코드 하단에 fetchPlaceDetails() 함수에 val place, val placeName, val placeAddress, val placeTypes로 내용들 가져옴

<img width="630" alt="스크린샷 2024-03-17 오후 4 07 44" src="https://github.com/rlaaudgjs2/Travel_app/assets/81517768/4dfc082f-4561-4ab5-aecd-f9b0cf1a8f99">

<img width="452" alt="image" src="https://github.com/rlaaudgjs2/Travel_app/assets/81517768/8ab6b42a-b11d-4648-bb00-54ebf4f8fd1e">

## 구글 api 프로젝트 매니저 추가, api 키 추가하는 방법 등은 모였을 때 알려줌

