# 1. 영화 '퍼스트 맨’의 제작 연도, 영문 제목, 러닝 타임, 플롯을 출력하세요
SELECT ReleaseYear, Title, RunningTime, Plot FROM movie WHERE KoreanTitle = '퍼스트 맨';

# 2. 2003년에 개봉한 영화의 한글 제목과 영문 제목을 출력하세요
SELECT KoreanTitle, Title FROM movie WHERE ReleaseYear = 2003;

# 3. 영화 '글래디에이터’의 작곡가(Composer)의 한글 이름을 출력하세요
SELECT KoreanName
FROM role R 
JOIN appear A ON R.RoleID = A.RoleID 
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID 
WHERE R.RoleID = 27 and M.KoreanTitle = '글래디에이터';

# 4. 영화 '매트릭스' 의 감독이 몇 명인지 출력하세요
SELECT COUNT(*)
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN movie M ON A.MovieID = M.MovieID
WHERE R.RoleID = 2 and M.Title = 'The Matrix';

# 5. 감독이 2명 이상인 영화의 정보를 다음 형식으로 출력하세요(하나의 컬럼) 한글영화제목(영문 영화제목) - 개봉연도
SELECT CONCAT(M.KoreanTitle, '(', M.Title, ') - ', M.ReleaseYear) AS 결과값
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN movie M ON A.MovieID = M.MovieID
WHERE R.RoleID = 2
GROUP BY M.KoreanTitle, M.Title, M.ReleaseYear
HAVING COUNT(*) >= 2;

# 6. '한스 짐머’가 참여한 영화 중 아카데미를 수상한 영화의 한글 제목을 출력하세요
SELECT M.KoreanTitle
FROM role R 
JOIN appear A ON R.RoleID = A.RoleID 
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID 
JOIN awardinvolve AI ON AI.AppearID = A.AppearID
JOIN awardyear AY ON AI.AwardYearID = AY.AwardYearID
JOIN award AW ON AW.AwardID = AY.AwardID
WHERE R.RoleID = 27 and KoreanName = '한스 짐머';

# 7. 감독이 '제임스 카메론’이고 '아놀드 슈워제네거’가 출연한 영화를 다음 형식으로 출력하세요(하나의 컬럼).
SELECT CONCAT('(', T1.Title, ')') AS 결과값
FROM (SELECT M.Title
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
WHERE P.KoreanName = '제임스 카메론' and R.RoleID = 2) AS T1
JOIN (SELECT M.Title
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
WHERE P.KoreanName = '아놀드 슈워제네거' and R.RoleID = 6) AS T2
ON T1.Title = T2.Title;

# 8. 상영시간이 100분 이상인 영화 중 레오나르도 디카프리오가 출연한 한글 제목과 개봉 연도를 출력하세요. 개봉 연도를 기준으로 내림차순 정렬되어야 합니다.
SELECT M.KoreanTitle, M.ReleaseYear
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
WHERE RunningTime >= 100 and P.KoreanName = '레오나르도 디카프리오' and R.RoleID = 6
ORDER BY M.ReleaseYear DESC;

# 9. 청소년 관람불가 등급의 영화 중 가장 많은 수익을 얻은 영화의 한글 제목, 원제(영어제목), 개봉연도, 세계흥행 금액을 출력하세요
SELECT M.KoreanTitle, M.Title, M.ReleaseYear, M.BoxOfficeWWGross
FROM movie M
JOIN gradeInKorea G ON M.GradeInKoreaID = G.GradeInKoreaID
WHERE G.GradeInKoreaID = 4
ORDER BY M.BoxOfficeWWGross DESC
LIMIT 1;

# 10. 1999년 이전에 제작된 영화의 수익 평균을 고르시오. 출력 형식은 달러 통화 형식이어야 합니다.
SELECT CONCAT('$', AVG(M.BoxOfficeWWGross)) AS 결과값
FROM movie M
WHERE M.ReleaseYear <= 1999;

# 11. 가장 많은 제작비가 투입된 영화를 다음 형식으로 출력하세요. 한글영화제목(영문 영화제목) - 개봉연도
SELECT CONCAT(M.KoreanTitle, '(', M.Title, ') - ', M.ReleaseYear) AS 결과값
FROM movie M
ORDER BY Budget DESC
LIMIT 1;

# 12. 감독한 영화의 제작비 총합이 가장 높은 감독을 다음 형식으로 출력하세요. 한글영화제목(영문 영화제목) - 개봉연도
SELECT CONCAT(P.KoreanName, '(', P.Name, ') - ', TIMESTAMPDIFF(YEAR, P.BirthDATE, CURDATE())) AS 결과값
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
WHERE R.RoleID = 2
GROUP BY P.name, P.KoreanName, P.BirthDATE
HAVING SUM(M.Budget)
ORDER BY SUM(M.Budget) DESC 
LIMIT 1;

# 13. 출연한 영화의 모든 수익을 합하여, 총 수입이 가장 많은 배우의 이름과 출생 연도를 출력하세요.(두 개의 컬럼)
SELECT P.KoreanName, P.Name, YEAR(P.BirthDate) AS 출생연도
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
WHERE R.RoleKorName = '배우'
GROUP BY P.KoreanName, P.Name, P.BirthDate
ORDER BY SUM(M.BoxOfficeWWGross) DESC
LIMIT 1;

# 14. 제작비가 가장 적게 투입된 영화의 한글 제목과 수익을 출력하세요. 제작비가 0인 영화는 제외하며,
SELECT CONCAT(M.KoreanTitle, ' $', M.Budget) AS 결과값
FROM movie M
WHERE M.Budget != 0
ORDER BY M.Budget ASC
LIMIT 1;

# 15. 제작비가 5000만 달러 이하인 영화의 미국내 평균 수익을 출력하세요. 출력 형식은 통화 형식이어야 합니다.
SELECT CONCAT('$', AVG(M.BoxOfficeWWGross))
FROM movie M
WHERE M.Budget <= 50000000;

# 16. 액션 장르 영화의 평균 수익을 출력하세요. 출력 형식은 통화 형식이어야 합니다.
SELECT CONCAT('$', AVG(M.BoxOfficeWWGross))
FROM movie M
JOIN moviegenre MG ON M.movieID = MG.movieID
JOIN genre G ON G.genreID = MG.genreID
WHERE GenreKorName = '액션';

# 17. 장르가 드라마, 전쟁인 영화의 제목을 아래 형식으로 출력하세요. 한글영화제목(영문 영화제목) - 개봉연도
SELECT CONCAT(M.KoreanTitle, '(', M.Title, ') - ', M.ReleaseYear)
FROM movie M
JOIN moviegenre MG ON M.movieID = MG.movieID
JOIN genre G ON G.genreID = MG.genreID
WHERE GenreKorName = '드라마' or GenreKorName = '전쟁';

# 18. 톰 행크스가 출연한 영화 중 상영 시간이 가장 긴 영화의 제목, 한글제목, 개봉연도를 출력하세요.(세 개의 컬럼)
SELECT M.Title, M.KoreanTitle, M.ReleaseYear
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
WHERE R.RoleID = 6 and P.KoreanName = '톰 행크스'
ORDER BY M.RunningTime DESC
LIMIT 1;

# 19. 아카데미 남우주연상을 가장 많이 수상한 배우의 한글 이름과 영문 이름을 출력하세요.(두 개의 컬럼))
SELECT P.KoreanName, P.Name
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN awardinvolve AIV ON A.AppearID = AIV.AppearID
JOIN sector S ON S.SectorID = AIV.SectorID
WHERE R.RoleKorName = '배우' and S.SectorKorName = '남우주연상'
GROUP BY P.KoreanName, P.Name
ORDER BY COUNT(*) DESC
LIMIT 1;

# 20. 아카데미상을 가장 많이 수상한 배우의 한글 이름과 영문 이름을 출력하세요.('수상자 없음’이 이름인 영화인은 제외합니다)
SELECT P.KoreanName, P.Name
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN awardinvolve AIV ON A.AppearID = AIV.AppearID
JOIN awardyear AY ON AY.AwardYearID = AIV.AwardYearID
JOIN award AW ON AW.AwardID = AY.AwardID
JOIN person P ON A.PersonID = P.PersonID
JOIN sector S ON S.SectorID = AIV.SectorID
WHERE R.RoleKorName = '배우' and AW.AwardID = 1 and P.KoreanName != '수상자 없음'
GROUP BY P.KoreanName, P.Name
ORDER BY COUNT(*) DESC
LIMIT 1;

# 21. 아카데미 남우주연상을 2번 이상 수상한 배우의 한글 이름과 영문 이름을 출력하세요.
SELECT P.KoreanName, P.Name
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN awardinvolve AIV ON A.AppearID = AIV.AppearID
JOIN sector S ON S.SectorID = AIV.SectorID
WHERE R.RoleKorName = '배우' and S.SectorKorName = '남우주연상'
GROUP BY P.KoreanName, P.Name
HAVING COUNT(*) >= 2;

# 22. 아카데미상을 가장 많이 수상한 사람의 한글 이름과 영문 이름을 출력하세요.
SELECT P.KoreanName, P.Name
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN awardinvolve AIV ON A.AppearID = AIV.AppearID
JOIN awardyear AY ON AY.AwardYearID = AIV.AwardYearID
JOIN award AW ON AW.AwardID = AY.AwardID
JOIN person P ON A.PersonID = P.PersonID
JOIN sector S ON S.SectorID = AIV.SectorID
WHERE AW.AwardID = 1
GROUP BY P.KoreanName, P.Name
ORDER BY COUNT(*) DESC
LIMIT 1;

# 23. 아카데미상에 가장 많이 노미네이트 된 영화의 한글 제목, 영문 제목, 개봉 연도를 출력하세요. (세 개의 컬럼)
SELECT M.KoreanTitle, M.Title, M.ReleaseYear
FROM appear A
JOIN movie M ON M.MovieID = A.MovieID
JOIN awardinvolve AIV ON AIV.AppearID = A.AppearID
JOIN awardyear AY ON AY.AwardYearID = AIV.AwardYearID
JOIN award AW ON AW.AwardID = AY.AwardID
JOIN sector S ON S.SectorID = AIV.SectorID
WHERE AW.AwardID = 1
GROUP BY M.KoreanTitle, M.Title, M.ReleaseYear
ORDER BY COUNT(*) DESC
LIMIT 1;

# 24. 가장 많은 영화에 출연한 여배우의 한글 이름과 영문 이름을 출력하세요.
SELECT P.KoreanName, P.Name
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
WHERE R.RoleName = 'Actress'
GROUP BY P.KoreanName, P.Name
ORDER BY COUNT(*) DESC
LIMIT 1;

# 25. 아카데미상을 가장 많이 수상한 영화를 아래 형식으로 출력하세요. <한글영화제목>(<영문 영화제목>) - <개봉연도>
SELECT CONCAT('<', M.KoreanTitle, '>(<', M.Title, '>) - <', M.ReleaseYear, '>') AS 결과값
FROM appear A
JOIN movie M ON M.MovieID = A.MovieID
JOIN awardinvolve AIV ON AIV.AppearID = A.AppearID
JOIN awardyear AY ON AY.AwardYearID = AIV.AwardYearID
JOIN award AW ON AW.AwardID = AY.AwardID
JOIN sector S ON S.SectorID = AIV.SectorID
WHERE AW.AwardID = 1
GROUP BY M.KoreanTitle, M.Title, M.ReleaseYear
ORDER BY COUNT(*) DESC
LIMIT 1;

# 26. 수익이 가장 높은 영화 TOP 10을 아래 형식으로 출력하세요. 수익으로 내림차순 정렬되어야 합니다. <한글영화제목>(<영문 영화제목>) - <개봉연도>
SELECT M.KoreanTitle, M.Title, M.ReleaseYear
FROM Movie M
ORDER BY M.BoxOfficeWWGross DESC
LIMIT 10;

# 27. 수익이 10억불 이상인 영화중 제작비가 1억불 이하인 영화를 아래 형식으로 출력하세요. 제작비로 오름차순 정렬 되어야 합니다. <한글영화제목>(<영문 영화제목>) - <개봉연도>
SELECT CONCAT('<', M.KoreanTitle, '>(<', M.Title, '>) - ', M.ReleaseYear, '>') AS 결과값
FROM movie M
WHERE M.BoxOfficeWWGross >= 1000000000 and M.Budget <= 100000000
ORDER BY M.Budget ASC;

# 28. 전쟁 영화를 가장 많이 감독한 사람의 한글 이름과 영문 이름을 출력하세요. (두 개의 컬럼)
SELECT P.KoreanName, P.Name
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
JOIN moviegenre MG ON M.movieID = MG.movieID
JOIN genre G ON G.genreID = MG.genreID
WHERE G.GenreKorName = '전쟁' and R.RoleID = 2
GROUP BY P.KoreanName, P.Name
ORDER BY COUNT(*) DESC
LIMIT 1;

# 29. 드라마 장르의 영화에 가장 많이 출연한 사람의 한글 이름과 영문 이름을 출력하세요. (두 개의 컬럼)
SELECT P.KoreanName, P.Name
FROM appear A
JOIN movie M ON A.MovieID = M.MovieID
JOIN moviegenre MG ON M.movieID = MG.movieID
JOIN genre G ON G.genreID = MG.genreID
JOIN person P ON P.PersonID = A.PersonID
WHERE G.GenreKorName = '드라마'
GROUP BY P.KoreanName, P.Name
ORDER BY COUNT(*) DESC
LIMIT 1;

# 30. 드라마 장르에 출연했지만 호러 영화에 한번도 출연하지 않은 남배우의 한글 이름과 영문 이름을 출력하세요.(두 개의 컬럼)
SELECT DISTINCT P.KoreanName, P.Name
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
JOIN moviegenre MG ON M.movieID = MG.movieID
JOIN genre G ON G.genreID = MG.genreID
WHERE A.RoleID = 6
AND P.PersonID IN (
    SELECT A.PersonID
    FROM appear A
    JOIN moviegenre MG ON A.MovieID = MG.MovieID
    JOIN genre G ON MG.GenreID = G.GenreID
    WHERE G.GenreKorName = '드라마'
)
AND P.PersonID NOT IN (
    SELECT A.PersonID
    FROM appear A
    JOIN moviegenre MG ON A.MovieID = MG.MovieID
    JOIN genre G ON MG.GenreID = G.GenreID
    WHERE G.GenreKorName = '호러'
);

# 31. 아카데미 영화제가 가장 많이 열린 장소는 어디인가요?
SELECT AY.Location
FROM awardyear AY
JOIN award A ON A.AwardID = AY.AwardID
WHERE A.AwardID = 1
GROUP BY AY.Location
ORDER BY COUNT(*) DESC
LIMIT 1;

# 32. 첫 번째 아카데미 영화제가 열린지 올해 기준으로 몇년이 지났나요?
SELECT YEAR(CURDATE()) - YEAR(AY.Date) AS 결과값
FROM awardyear AY
JOIN award A ON A.AwardID = AY.AwardID
WHERE A.AwardID = 1
ORDER BY AY.Date ASC
LIMIT 1;

# 33. SF 장르의 영화 중 아카데미 영화제 후보에 가장 많이 오른 영화의 한글 제목을 구하세요.
SELECT M.KoreanTitle
FROM appear A
JOIN movie M ON M.MovieID = A.MovieID
JOIN awardinvolve AIV ON AIV.AppearID = A.AppearID
JOIN awardyear AY ON AY.AwardYearID = AIV.AwardYearID
JOIN award AW ON AW.AwardID = AY.AwardID
JOIN moviegenre MG ON A.MovieID = MG.MovieID
JOIN genre G ON MG.GenreID = G.GenreID
WHERE G.GenreKorName = '공상과학' and AW.AwardID = 1
GROUP BY M.KoreanTitle
ORDER BY COUNT(*) DESC
LIMIT 1;

# 34. 드라마 장르의 영화의 아카데미 영화제 작품상 수상 비율을 구하세요.
SELECT (COUNT(DISTINCT CASE WHEN G.GenreKorName = '드라마' THEN M.MovieID END) / COUNT(DISTINCT M.MovieID)) * 100 AS 결과값
FROM movie M
JOIN appear A ON M.MovieID = A.MovieID
JOIN moviegenre MG ON A.MovieID = MG.MovieID
JOIN awardinvolve AIV ON AIV.AppearID = A.AppearID
JOIN awardyear AY ON AY.AwardYearID = AIV.AwardYearID
JOIN award AW ON AW.AwardID = AY.AwardID
JOIN genre G ON MG.GenreID = G.GenreID
JOIN sector S ON S.SectorID = AIV.SectorID
WHERE AW.AwardID = 1 and S.SectorKorName = '작품상';

# 35. '휴 잭맨’이 출연한 영화의 제작비 대비 수익율을 출력하세요.
SELECT M.KoreanTitle, M.Title, (M.BoxOfficeWWGross / NULLIF(M.Budget, 1)) * 100 AS 결과값
FROM role R
JOIN appear A ON R.RoleID = A.RoleID
JOIN person P ON A.PersonID = P.PersonID
JOIN movie M ON A.MovieID = M.MovieID
WHERE R.RoleID = 6 and P.KoreanName = '휴 잭맨';








