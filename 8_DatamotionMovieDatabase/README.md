영화 데이터베이스에서 쿼리 작성

* 주어진 데이터베이스는 https://movie.datamotion.co.kr/ 웹 사이트의 데이터베이스입니다.
* 데이터베이스를 MYSQL 또는 Microsoft SQL Server에서 복원하고 주어진 질의에 대해 올바른 결과를 산출하는 쿼리를 작성하세요.

데이터베이스 복원

* MYSQL 및 Microsoft SQL Server에서 백업한 파일이 주어집니다.
* 해당 DBMS에서 데이터베이스를 복원하세요.

MYSQL

MySQL 백업 파일 link:https://onedrive.live.com/?id=AB9BD89F1554471A%211005933&resid=AB9BD89F1554471A%211005933&redeem=aHR0cHM6Ly8xZHJ2Lm1zL3UvcyFBaHBIVkJXZjJKdXJ2Ykp0cF9wSzNFTjJLLWUtS1E%5FZT14V1VlM0s&migratedtospo=true&cid=ab9bd89f1554471a&v=validatepermission[다운로드]

1. 터미널을 실행하고, MYSQL에 로그인합니다.
2. 아래 질의를 수행하여 DatamotionMovieDatabase 데이터베이스를 생성합니다.
+
[source, sql]
----
CREATE DATABASE DatamotionMovieDatabase;
----
+
3. 데이터베이스가 생성되면 아래 명령을 실행하여 MySQL 클라이언트를 종료합니다.
+
----
exit
----
+
4. 터미널에서 아래 명령을 수행하여 백업 받은 파일을 DatamotionMovieDatabase 데이터베이스에 복원합니다.
+
----
mysql -u root -p DatamotionMovieDatabase < DMMDB-20231012.sql
----
+
5. 복원이 완료되면, MySQL에 접근합니다.
+
----
mysql -u root -p
----
+
6. 아래 명령을 실행하여 복원된 데이터베이스를 확인합니다.
+
[source, sql]
----
show databases;
use datamotionmoviedatabase;
show tables;
----

Microsoft SQL Server

Microsoft SQL Server 백업 파일 link:./https://onedrive.live.com/?redeem=aHR0cHM6Ly8xZHJ2Lm1zL3UvcyFBaHBIVkJXZjJKdXJ2Ykp1aElKTmRtRzlqeU90Q2c%5FZT05UFRoVGw&cid=AB9BD89F1554471A&id=AB9BD89F1554471A%211005934&parId=AB9BD89F1554471A%21162&o=OneUp[다운로드]

==== 로컬에 Microsoft SQL Server가 설치된 경우

1. SQL Server Management Studio를 실행합니다.
2. 아래 명령을 실행하여 다운로드한 데이터베이스를 복원합니다.
+
[source, sql]
----
RESTORE DATABASE DatamotionMovieDatabase
FROM DISK='<드라이브 명><다운로드한 폴더>/DatamotionMovieDatabase_2021-07-16.bak'
----
+
예:
[source, sql]
----
RESTORE DATABASE DatamotionMovieDatabase FROM DISK='c:\backup\DatamotionMovieDatabase_2021-07-16.bak'
----

컨테이너에 설치된 경우

Microsoft SQL Server가 Docker에 설치된 경우 백업 파일을 container 내부로 복사해야 합니다. 

1. 아래 명령을 실행하여 Docker 컨테이너에 SQL Server backup 파일이 저장될 폴더 생성합니다.
+
----
$ docker exec -it sqlserver mkdir /var/opt/mssql/backup
----
+ 
2. 복사 후 아래 명령으로 생성한 폴더에 백업 파일을 복사합니다.
+
----
$ docker cp datamotion.bak sqlserver:/var/opt/mssql/backup
----
+
3. SQL Server Management Studio 또는 Azure Data Studio에서 아래 쿼리를 실행하여 복원합니다.
+
[source, sql]
----
RESTORE DATABASE DatamotionMovieDatabase
FROM DISK='/var/opt/mssql/backup/DatamotionMovieDatabase_2021-07-16.bak'
WITH
MOVE 'DatamotionMovieDatabase' TO '/var/opt/mssql/data/DatamotionMovieDatabase.mdf',
MOVE 'DatamotionMovieDatabase_log' TO '/var/opt/mssql/data/DatamotionMovieDatabase_log.ldf'
----

문제

01. 영화 '퍼스트 맨'의 제작 연도, 영문 제목, 러닝 타임, 플롯을 출력하세요
02. 2003년에 개봉한 영화의 한글 제목과 영문 제목을 출력하세요
03. 영화 '글래디에이터'의 작곡가(Composer)의 한글 이름을 출력하세요 
04. 영화 '매트릭스' 의 감독이 몇 명인지 출력하세요 
05. 감독이 2명 이상인 영화의 정보를 다음 형식으로 출력하세요(하나의 컬럼)
* 한글영화제목(영문 영화제목) - 개봉연도 
06. '한스 짐머'가 참여한 영화 중 아카데미를 수상한 영화의 한글 제목을 출력하세요
07. 감독이 '제임스 카메론'이고 '아놀드 슈워제네거'가 출연한 영화를 다음 형식으로 출력하세요(하나의 컬럼).
* 한글영화제목(영문 영화제목) - 개봉연도 
08. 상영시간이 100분 이상인 영화 중 레오나르도 디카프리오가 출연한 한글 제목과 개봉 연도를 출력하세요. 
* 개봉 연도를 기준으로 내림차순 정렬되어야 합니다.
09. 청소년 관람불가 등급의 영화 중 가장 많은 수익을 얻은 영화의 한글 제목, 원제(영어제목), 개봉연도, 세계흥행 금액을 출력하세요
10. 1999년 이전에 제작된 영화의 수익 평균을 고르시오. 출력 형식은 달러 통화 형식이어야 합니다.
11. 가장 많은 제작비가 투입된 영화를 다음 형식으로 출력하세요.
* 한글영화제목(영문 영화제목) - 개봉연도 
12. 감독한 영화의 제작비 총합이 가장 높은 감독을 다음 형식으로 출력하세요. 
* 한글 이름(영문 이름) - 나이
13. 출연한 영화의 모든 수익을 합하여, 총 수입이 가장 많은 배우의 이름과 출생 연도를 출력하세요.(두 개의 컬럼)
14. 제작비가 가장 적게 투입된 영화의 한글 제목과 수익을 출력하세요. 제작비가 0인 영화는 제외하며, 
15. 제작비가 5000만 달러 이하인 영화의 미국내 평균 수익을 출력하세요. 출력 형식은 통화 형식이어야 합니다.
16. 액션 장르 영화의 평균 수익을 출력하세요. 출력 형식은 통화 형식이어야 합니다.
17. 장르가 드라마, 전쟁인 영화의 제목을 아래 형식으로 출력하세요. 
* 한글영화제목(영문 영화제목) - 개봉연도 
18. 톰 행크스가 출연한 영화 중 상영 시간이 가장 긴 영화의 제목, 한글제목, 개봉연도를 출력하세요.(세 개의 컬럼)
19. 아카데미 남우주연상을 가장 많이 수상한 배우의 한글 이름과 영문 이름을 출력하세요.(두 개의 컬럼))
20. 아카데미상을 가장 많이 수상한 배우의 한글 이름과 영문 이름을 출력하세요.('수상자 없음'이 이름인 영화인은 제외합니다)
21. 아카데미 남우주연상을 2번 이상 수상한 배우의 한글 이름과 영문 이름을 출력하세요.
22. 아카데미상을 가장 많이 수상한 사람의 한글 이름과 영문 이름을 출력하세요.
23. 아카데미상에 가장 많이 노미네이트 된 영화의 한글 제목, 영문 제목, 개봉 연도를 출력하세요. (세 개의 컬럼)
24. 가장 많은 영화에 출연한 여배우의 한글 이름과 영문 이름을 출력하세요.
25. 아카데미상을 가장 많이 수상한 영화를 아래 형식으로 출력하세요.
* <한글영화제목>(<영문 영화제목>) - <개봉연도>
26. 수익이 가장 높은 영화 TOP 10을 아래 형식으로 출력하세요. 수익으로 내림차순 정렬되어야 합니다.
* <한글영화제목>(<영문 영화제목>) - <개봉연도>
27. 수익이 10억불 이상인 영화중 제작비가 1억불 이하인 영화를 아래 형식으로 출력하세요. 제작비로 오름차순 정렬 되어야 합니다.
* <한글영화제목>(<영문 영화제목>) - <개봉연도>
28. 전쟁 영화를 가장 많이 감독한 사람의 한글 이름과 영문 이름을 출력하세요. (두 개의 컬럼)
29. 드라마 장르의 영화에 가장 많이 출연한 사람의 한글 이름과 영문 이름을 출력하세요. (두 개의 컬럼)
30. 드라마 장르에 출연했지만 호러 영화에 한번도 출연하지 않은 남배우의 한글 이름과 영문 이름을 출력하세요.(두 개의 컬럼)
31. 아카데미 영화제가 가장 많이 열린 장소는 어디인가요?
32. 첫 번째 아카데미 영화제가 열린지 올해 기준으로 몇년이 지났나요?
33. SF 장르의 영화 중 아카데미 영화제 후보에 가장 많이 오른 영화의 한글 제목을 구하세요.
34. 드라마 장르의 영화의 아카데미 영화제 작품상 수상 비율을 구하세요.
35. '휴 잭맨'이 출연한 영화의 제작비 대비 수익율을 출력하세요.
