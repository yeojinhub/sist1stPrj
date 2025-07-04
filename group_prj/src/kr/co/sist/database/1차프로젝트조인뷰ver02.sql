DROP VIEW COURSEWITHINSTNAME;

DROP VIEW TOTAL_COURSE;

DROP VIEW TOTAL_BOARD;

DROP VIEW TOTAL_BOARD_WITH_INST;

DROP VIEW ADMIN_SEARCH_GRADE;

/*
학생 프로그램 Join View
*/

-- 메인화면에 Panel에 들어갈 것들 조인 쿼리문.

-- StudentMainVO 1차 = 담당강사 위한 조인
SELECT COUR_NUM, COUR_CARDINAL, COUR_NAME, COUR_STATUS, COUR_STARTDATE, COUR_ENDDATE, I.INST_NUM, INST_NAME
FROM COURSE C, INSTRUCTOR I
WHERE C.INST_NUM = I.INST_NUM;

-- 다음 조인을 위해 위 조인문 뷰 생성
CREATE VIEW COURSEWITHINSTNAME(COUR_NUM, COUR_CARDINAL, COUR_NAME, COUR_STATUS, COUR_STARTDATE, COUR_ENDDATE, INST_NUM, INST_NAME)
AS (SELECT COUR_NUM, COUR_CARDINAL, COUR_NAME, COUR_STATUS, COUR_STARTDATE, COUR_ENDDATE, I.INST_NUM, INST_NAME
FROM COURSE C, INSTRUCTOR I
WHERE C.INST_NUM = I.INST_NUM);

SELECT * FROM COURSEWITHINSTNAME;

-- StudentMainVO 2차 = 과목명을 위한 조인
SELECT C.COUR_NUM, COUR_CARDINAL, COUR_NAME, COUR_STATUS, COUR_STARTDATE, COUR_ENDDATE, INST_NUM, INST_NAME, EXAM_NAME
FROM EXAM E, COURSEWITHINSTNAME C
WHERE E.COUR_NUM = C.COUR_NUM;

-- 2차 완료 뷰 생성
CREATE VIEW TOTAL_COURSE(COUR_NUM, COUR_CARDINAL, COUR_NAME, COUR_STATUS, COUR_STARTDATE, COUR_ENDDATE, INST_NUM, INST_NAME, EXAM_NAME)
AS (SELECT C.COUR_NUM, COUR_CARDINAL, COUR_NAME, COUR_STATUS, COUR_STARTDATE, COUR_ENDDATE, INST_NUM, INST_NAME, EXAM_NAME
FROM EXAM E, COURSEWITHINSTNAME C
WHERE E.COUR_NUM = C.COUR_NUM);

-- StudentBoardVO 1차 학생이름 추가를 위한 조인문
SELECT BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_STATUS, BOARD_DATE, BOARD_TYPE, BOARD_COMM_CONTENT, BOARD_COMM_DATE, B.STU_NUM, INST_NUM, ADM_ID, STU_NAME
FROM BOARD B, STUDENT S
WHERE B.STU_NUM = S.STU_NUM;

-- 1차 완료 뷰 생성
CREATE VIEW TOTAL_BOARD(BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_STATUS, BOARD_DATE, BOARD_TYPE, BOARD_COMM_CONTENT, BOARD_COMM_DATE, STU_NUM, INST_NUM, ADM_ID, STU_NAME)
AS (SELECT BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_STATUS, BOARD_DATE, BOARD_TYPE, BOARD_COMM_CONTENT, BOARD_COMM_DATE, B.STU_NUM, INST_NUM, ADM_ID, STU_NAME
FROM BOARD B, STUDENT S
WHERE B.STU_NUM = S.STU_NUM);

-- 2차 선생이름 추가를 위한 조인문
SELECT BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_STATUS, BOARD_DATE, BOARD_TYPE, BOARD_COMM_CONTENT, BOARD_COMM_DATE, STU_NUM, B.INST_NUM, ADM_ID, STU_NAME, INST_NAME
FROM TOTAL_BOARD B LEFT OUTER JOIN INSTRUCTOR I
ON B.INST_NUM = I.INST_NUM;

-- 2차 완료 뷰 생성
CREATE VIEW TOTAL_BOARD_WITH_INST(BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_STATUS, BOARD_DATE, BOARD_TYPE, BOARD_COMM_CONTENT, BOARD_COMM_DATE, STU_NUM, INST_NUM, ADM_ID, STU_NAME, INST_NAME)
AS (SELECT BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_STATUS, BOARD_DATE, BOARD_TYPE, BOARD_COMM_CONTENT, BOARD_COMM_DATE, STU_NUM, B.INST_NUM, ADM_ID, STU_NAME, INST_NAME
FROM TOTAL_BOARD B LEFT OUTER JOIN INSTRUCTOR I
ON B.INST_NUM = I.INST_NUM);

/*
관리자 프로그램 Join View
*/
-- "성적조회" 뷰
CREATE VIEW ADMIN_SEARCH_GRADE(EXAM_ANSW_COUNT, STU_NUM, EXAM_NUM, COUR_NUM, COUR_CARDINAL, EXAM_NAME, EXAM_DATE, STU_NAME)
AS (SELECT EXAM_ANSW_COUNT, S.STU_NUM, EXAM_NUM, COUR_NUM, COUR_CARDINAL, EXAM_NAME, TO_CHAR(EXAM_DATE,'YYYY-MM-DD') EXAM_DATE, STU_NAME
FROM STUDENT S, (SELECT EXAM_ANSW_COUNT, STU_NUM, G.EXAM_NUM, COUR_NUM, COUR_CARDINAL, EXAM_NAME, EXAM_DATE
FROM GRADE G, (SELECT C.COUR_NUM, COUR_CARDINAL, EXAM_NUM, EXAM_NAME, EXAM_DATE
FROM COURSE C, EXAM E
WHERE C.COUR_NUM = E.COUR_NUM) A
WHERE G.EXAM_NUM = A.EXAM_NUM) A
WHERE S.STU_NUM = A.STU_NUM);

commit;
