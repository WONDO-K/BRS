CREATE TABLE LIB_BOOK
(
   B_NUMBER   NUMBER       PRIMARY KEY
 , TITLE      VARCHAR2(40)
 , AUTHOR     VARCHAR2(30)
 , PUBLISHER  VARCHAR2(30)
 , BOOK_COUNT NUMBER
 , RENTAL     VARCHAR2(20)
 , IMG_URL    VARCHAR2(50)
);

CREATE TABLE LIB_MEMBER 
(
   ID     VARCHAR2(20) PRIMARY KEY
 , PW     VARCHAR2(20) 
 , NAME   VARCHAR2(20) 
 , GENDER VARCHAR2(10)
 , EMAIL  VARCHAR2(60)
 , TEL    VARCHAR2(20)
 , BIRTH  VARCHAR2(20) 
 , JOB    VARCHAR2(20) 

);

CREATE TABLE LIB_RENTAL 
(
   RENTAL_STATUS VARCHAR2(20)
 , MEMBER_ID     VARCHAR2(20)
 , BOOK_NUMBER   NUMBER 
 , RENTAL_DATE   VARCHAR2(30) 
 , RETURN_DATE   VARCHAR2(30) 
 , RETURN_PERIOD VARCHAR2(20) 
 , POINT         NUMBER 
 , FOREIGN KEY(BOOK_NUMBER) REFERENCES LIB_BOOK(B_NUMBER)
 , FOREIGN KEY(MEMBER_ID) REFERENCES LIB_MEMBER(ID)

);

----------------------------------------------------------
DROP TABLE LIB_MEMBER;
DROP TABLE LIB_BOOK;
DROP TABLE LIB_RENTAL;

----------------------------------------------------------
INSERT INTO LIB_BOOK VALUES (1, '갯마을 차차차 2', '신하은', '북로그컴퍼니', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (2, '갯마을 차차차 1', '신하은', '북로그컴퍼니', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (3, '트렌드 코리아 2022', '김난도', '미래의창', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (4, '일기', '황정은', '창비', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (5, '설민석의 한국사 대모험 18', '설민석', '북로그컴퍼니', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (6, '주술회전 공식 팬북', '아쿠타미 게게', '서울미디어코믹스', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (7, '작별하지 않는다', '한강', '문학동네', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (8, '달러구트 꿈 백화점 2', '이미예', '팩토리나인', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (9, '1차원이 되고 싶어', '박상영', '문학동네', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (10, '지금은 나만의 시간입니다', '김유진', '토네이도', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (11, '킹덤', '요 네스뵈', '비채', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (12, '그냥 하지 말라', '송길영', '북스톤', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (13, '달러구트 꿈 백화점', '이미예', '팩토리나인', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (14, '햇빛은 찬란하고 인생은 귀하니까요', '장명숙', '김영사', 5, '가능', null); --
INSERT INTO LIB_BOOK VALUES (15, '파리 마카롱 수수께끼', '요네자와 호노부', '엘릭시르', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (16, '그리스 로마 신화 25 : 파리스의 심판', '박시연', '아울북', 5, '가능', null); --
INSERT INTO LIB_BOOK VALUES (17, '어느 날 공주가 되어버렸다 6', '스푼', '캐롯툰', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (18, '지구 끝의 온실', '김초엽', '자이언트북스', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (19, '지박소년 하나코 군 0', '아이다이로', '서울미디어코믹스', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (20, '소크라테스 익스프레스', '에릭 와이너', '어크로스', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (21, 'EBS 당신의 문해력', '김윤정', 'EBS BOOKS', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (22, '밝은 밤', '최은영', '문학동네', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (23, '다정한 것이 살아남는다', '브라이언 헤어', '디플롯', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (24, '믿는 인간에 대하여', '한동일', '흐름출판', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (25, '설민석의 세계사 대모험 10', '설민석', '단꿈아이', 5, '가능');
INSERT INTO LIB_BOOK VALUES (26, '2021 큰별쌤 최태성의 별별한국사 기출 500제 한국사 능력검정시험 심화(1,2,3급)', '최태성', '이투스북', 5, '가능', null); --
INSERT INTO LIB_BOOK VALUES (27, '언바운드', '조용민', '인플루엔셜(주)', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (28, '불편한 편의점', '김호연', '나무옆의자', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (29, '거대한 가속', '스콧 갤러웨이', '리더스북', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (30, '부의 시그널', '박종훈', '베가북스', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (31, '다정소감', '김혼비', '(주)안온북스', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (32, '페미니즘 철학 입문', '김은주', '오월의봄', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (33, '럭키', '김도윤', '북로망스', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (34, '양순이네 떡집', '김리리', '비룡소', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (35, '오늘 밤, 세계에서 이 사랑이 사라진다 해도', '이치조 미사키', '모모', 5, '가능', null); --
INSERT INTO LIB_BOOK VALUES (36, '공부의 본질', '이운규', '빅피시', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (37, '외계인 인터뷰', '로렌스 R. 스펜서', '아이커넥', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (38, '해커스 토익 기출 보카 TOEIC VOCA 단어장', 'David Cho', '해커스어학연구소', 5, '가능', null); --
INSERT INTO LIB_BOOK VALUES (39, '2021 김승옥문학상 수상작품집', '문진영', '문학동네', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (40, '어린 왕자(회전목마 팝업북)', '앙투안 드 생텍쥐페리', '문예출판사', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (41, '기묘한 미술관', '진병관', '빅피시', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (42, '소문', '오기와라 히로시', '모모', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (43, '포인트 캐릭터 드로잉 - 전2권', '타코', '레진코믹스(레진엔터테인먼트)', 5, '가능', null); --
INSERT INTO LIB_BOOK VALUES (44, '신부이야기 13', '모리 카오루', '대원씨아이', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (45, '생각한다는 착각', '닉 채터', '웨일북', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (46, '오은영의 화해', '오은영', '코리아닷컴', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (47, '인생은 실전이다', '신영준', '상상스퀘어', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (48, '나는 강물처럼 말해요', '조던 스콧', '책읽는곰', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (49, '크리스마스 피그', 'J.K. 롤링', '문학수첩', 5, '가능', null);
INSERT INTO LIB_BOOK VALUES (50, '대한민국 재건축 재개발 지도', '정지영', '다산북스', 5, '가능', null);

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
COMMIT;

UPDATE LIB_BOOK
 SET   
