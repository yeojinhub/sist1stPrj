-- '관리자' 테이블 가데이터

select * from ADMIN;
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass01','이철수','1990-05-15','010-1234-5678','서울특별시 강남구 역삼동 123-4');
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass02','박영희','1985-09-25','010-2345-6789','부산광역시 해운대구 좌동 56-7');
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass03','김민준','1998-12-11','010-3456-7890','대구광역시 수성구 범어동 89-10');
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass04','정다은','1993-03-30','010-4567-8901','인천광역시 남동구 간석동 11-12');
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass05','최성호','1995-07-19','010-5678-9012','광주광역시 서구 농성동 13-14');

-- '강사' 테이블 가데이터
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass01','김강사','1982-06-22','010-6789-0123','서울특별시 마포구 신촌동 15-16');
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass02','박강사','1979-11-10','010-7890-1234','대전광역시 유성구 봉명동 17-18');
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass03','이강사','1990-08-05','010-8901-2345','울산광역시 남구 삼산동 19-20');
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass04','최강사','1985-02-14','010-9012-3456','경기도 성남시 분당구 정자동 21-22');
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass05','정강사','1993-09-28','010-0123-4567','전라북도 전주시 덕진구 금암동 23-24');

-- '학생' 테이블 가데이터
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass01','강학생','2005-05-21','010-2345-6789','서울특별시 송파구 가락동 25-26','진행중');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass02','박학생','2004-09-15','010-3456-7890','경기도 수원시 팔달구 인계동 27-28','수료');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass03','이학생','2006-01-30','010-4567-8901','부산광역시 사상구 엄궁동 29-30','진행중');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass04','최학생','2003-07-11','010-5678-9012','대구광역시 달서구 본리동 31-32','수료');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass05','정학생','2005-12-02','010-6789-0123','광주광역시 북구 운암동 33-34','진행중');

-- '과정' 테이블 가데이터
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-1','[KDT] AI 데이터 분석과 머신러닝','모집중','2025-02-01','2025-08-15','2025_0001');
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-2','[KDT] 파이썬을 활용한 웹 개발','강의중','2025-03-10','2025-09-25','2025_0002');
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-3','[KDT] React & Node.js 풀스택 과정','모집중','2025-04-20','2025-10-30','2025_0003');
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-4','[KDT] 블록체인 기반 애플리케이션 개발','강의중','2025-05-15','2025-11-20','2025_0004');
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-5','[KDT] 클라우드 컴퓨팅과 DevOps','모집중','2025-06-01','2025-12-10','2025_0005');

-- '시험지' 테이블 가데이터
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Python', '2025-04-15', 1);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Oracle', '2025-04-10', 1);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Frontend', '2025-04-20', 1);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Backend', '2025-05-01', 2);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Security', '2025-05-15', 3);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Cloud', '2025-05-20', 3);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'AI', '2025-05-25', 4);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'DevOps', '2025-06-01', 4);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Big Data', '2025-06-10', 5);


-- '시험문제' 테이블 가데이터
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Python은 무엇에 사용되나요?', 'A) 웹 개발, B) 데이터 과학, C) 인공지능, D) 위의 모든 것', 4, 1);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'SQL은 무엇의 약자인가요?', 'A) 구조화 질의 언어, B) 단순 질의 논리, C) 순차 질의 언어, D) 표준화 질의 논리', 1, 1);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'React는 무엇인가요?', 'A) 라이브러리, B) 프레임워크, C) 데이터베이스, D) 서버', 1, 1);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'REST는 무엇의 약자인가요?', 'A) 표현 상태 전달, B) 원격 서버 테스트, C) 재귀 실행 시스템 전송, D) 신뢰할 수 있는 암호화 전송', 1, 1);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '다음 중 클라우드 제공자가 아닌 것은?', 'A) AWS, B) Azure, C) Docker, D) Google Cloud', 3, 1);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Oracle의 패키지는 무엇인가요?', 'A) 트리거의 일종, B) 스키마 수준 객체, C) 백업 파일, D) 시스템 테이블', 2, 2);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Oracle에서 권한을 부여할 때 사용하는 명령어는?', 'A) GIVE, B) PERMIT, C) GRANT, D) ALLOW', 3, 2);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Oracle Database의 기본 포트 번호는?', 'A) 1433, B) 1521, C) 3306, D) 8080', 2, 2);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'PL/SQL 블록을 작성할 때 주로 사용하는 언어는?', 'A) Java, B) Python, C) SQL, D) PL/SQL', 4, 2);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Oracle에서 Synonym은 무엇인가요?', 'A) 백업 스키마, B) 테이블 또는 뷰의 별칭, C) 프로시저의 일종, D) 예약어', 2, 2);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '데이터베이스에서 정규화란?', 'A) 데이터 축소, B) 중복 제거, C) 데이터 암호화, D) 테이블 압축', 2, 3);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '다음 중 NoSQL 데이터베이스는?', 'A) MySQL, B) PostgreSQL, C) MongoDB, D) Oracle', 3, 3);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '데이터베이스에서 ACID는 무엇의 약자인가요?', 'A) 원자성, 일관성, 고립성, 지속성, B) 접근, 제어, 무결성, 데이터, C) 자동, 커밋, 고립성, 지속성, D) 배열, 열, 인덱스, 데이터', 1, 3);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '중복된 값을 제거하는 SQL 절은?', 'A) UNIQUE, B) DISTINCT, C) DELETE, D) FILTER', 2, 3);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '외래 키(Foreign Key)는 무엇인가요?', 'A) 항상 기본 키를 참조하는 키, B) 암호화를 위한 키, C) 동일 테이블의 기본 키, D) NULL만 허용하는 키', 1, 3);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '암호화의 주된 목적은?', 'A) 데이터 압축, B) UI 난독화, C) 데이터 보안, D) 속도 향상', 3, 4);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '다음 중 강력한 비밀번호는?', 'A) 123456, B) password, C) Ab!9#Xy3, D) qwerty', 3, 4);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'HTTPS가 HTTP보다 제공하는 것은?', 'A) 더 나은 디자인, B) 성능 향상, C) 보안 통신, D) 서버리스 실행', 3, 4);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '다음 중 일반적인 웹 보안 취약점은?', 'A) XSS, B) CSS, C) JSON, D) HTML', 1, 4);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '보안 원격 접속에 사용되는 프로토콜은?', 'A) FTP, B) SSH, C) SMTP, D) HTTP', 2, 4);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '대표적인 클라우드 서비스 제공업체는?', 'A) Azure, B) Linux, C) Ubuntu, D) Android', 1, 5);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'IaaS는 무엇의 약자인가요?', 'A) 인터페이스 서비스, B) 인프라 서비스, C) 인스턴스 시스템, D) 내부 API 서비스', 2, 5);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '전체 소프트웨어를 인터넷을 통해 제공하는 모델은?', 'A) SaaS, B) PaaS, C) IaaS, D) OSaaS', 1, 5);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '클라우드 확장성(Scalability)이란?', 'A) 고정 자원 사용, B) 자원의 자동 확장, C) 로컬 자원 처리, D) 클라우드 이전', 2, 5);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '한 조직에만 속한 클라우드 배포 방식은?', 'A) 공용 클라우드, B) 하이브리드 클라우드, C) 전용 클라우드, D) 오픈 클라우드', 3, 5);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '대표적인 클라우드 서비스 제공자는?', 'A) Azure, B) 리눅스, C) 우분투, D) 안드로이드', 1, 6);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'IaaS는 무엇의 약자인가요?', 'A) 인터페이스 서비스, B) 인프라 서비스, C) 인스턴스 시스템, D) 내부 API 서비스', 2, 6);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '전체 소프트웨어를 인터넷으로 제공하는 모델은?', 'A) SaaS, B) PaaS, C) IaaS, D) OSaaS', 1, 6);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '클라우드 확장성(Scalability)이란?', 'A) 고정된 자원 사용, B) 자동 확장 자원, C) 로컬 자원 처리, D) 클라우드 이전', 2, 6);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '하나의 조직에만 사용하는 클라우드 배포 모델은?', 'A) 퍼블릭 클라우드, B) 하이브리드 클라우드, C) 프라이빗 클라우드, D) 오픈 클라우드', 3, 6);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'AI는 무엇의 약자인가요?', 'A) 인공지능, B) 자동 통합, C) 고급 입력, D) 아날로그 인터페이스', 1, 7);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '다음 중 AI 응용 프로그램은?', 'A) ChatGPT, B) Google Docs, C) MS Paint, D) 메모장', 1, 7);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'AI에서 ML은 무엇의 약자인가요?', 'A) 머신러닝, B) 메인 로직, C) 메타 언어, D) 최신 학습', 1, 7);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'AI 개발에 널리 사용되는 언어는?', 'A) HTML, B) C++, C) Python, D) CSS', 3, 7);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '신경망(Neural Network)은 무엇에서 영감을 받았나요?', 'A) CPU 스레드, B) 인간의 뇌, C) 컴퓨터 논리 게이트, D) 이진 트리', 2, 7);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'DevOps에서 CI/CD는 무엇의 약자인가요?', 'A) 코드 점화 / 코드 디버그, B) 지속적 통합 / 지속적 배포, C) 사용자 정의 통합 / 사용자 정의 개발, D) 컴파일 인터페이스 / 컴파일 전달', 2, 8);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'CI/CD에 일반적으로 사용되는 도구는?', 'A) Jenkins, B) 포토샵, C) 파워포인트, D) 메모장++', 1, 8);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Docker의 주요 역할은?', 'A) 텍스트 편집, B) 이미지 처리, C) 컨테이너화, D) 컴파일', 3, 8);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '버전 관리를 위한 시스템은?', 'A) Git, B) Zoom, C) Discord, D) MS 워드', 1, 8);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Kubernetes의 목적은?', 'A) UI 설계, B) 컨테이너 관리, C) SQL 쿼리 작성, D) 전기 모니터링', 2, 8);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '빅데이터란 무엇인가요?', 'A) 작은 데이터셋, B) 대용량·고속·다양한 데이터, C) 구조화된 데이터만, D) 오디오 데이터만', 2, 9);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '빅데이터 처리를 위한 도구는?', 'A) Hadoop, B) Excel, C) 메모장, D) 그림판', 1, 9);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'MapReduce는 무엇인가요?', 'A) 정렬 도구, B) 데이터 저장 모델, C) 대용량 데이터 처리용 프로그래밍 모델, D) 암호화 기법', 3, 9);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '다음 중 빅데이터용 데이터베이스는?', 'A) Oracle, B) MongoDB, C) MySQL, D) Access', 2, 9);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Spark는 무엇에 사용되나요?', 'A) 영화 스트리밍, B) 실시간 빅데이터 처리, C) 영상 편집, D) 모바일 개발', 2, 9);


-- '신청과정' 테이블 가데이터
INSERT INTO APPLY_STEPS VALUES('2025_0001', 1);
INSERT INTO APPLY_STEPS VALUES('2025_0002', 2);
INSERT INTO APPLY_STEPS VALUES('2025_0003', 3);
INSERT INTO APPLY_STEPS VALUES('2025_0004', 4);
INSERT INTO APPLY_STEPS VALUES('2025_0005', 5);




select * from BOARD;
-- '게시판' 테이블 가데이터
INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'시험 일정 문의',
'시험 날짜가 변경되었나요?',
'답변완료',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'강사',
'그건 제가 한번 찾아보고 말씀드리겠습니다. 예? 급한거 아니시잖아요 안그래요?',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0001',
'2025_0001',
'');

INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'강의 내용 질문',
'3주차 강의 내용 중 이해가 안 가는 부분이 있습니다.',
'답변완료',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'관리자',
'질문 내용을 자세히 남겨주시면 도와드리겠습니다.',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0001',
'',
'admin01');

INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'수업 자료 요청',
'지난 강의 자료를 받을 수 있을까요?',
'답변완료',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'관리자',
'이메일로 보내드렸습니다.',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0003',
'',
'admin01');

INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'시험 결과 확인 요청',
'제 점수가 맞는지 확인 부탁드립니다.',
'답변완료',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'강사',
'마음을 놓아 이곳에서 날 불러 눈물을 닦고 달려온 나의 저 길을 바라봐',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0004',
'2025_0004',
'');

INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'과제 제출 관련 문의',
'과제 제출 기한이 언제까지인가요?',
'답변완료',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'강사',
'여러분 무슨 일이 생겨도 얼음 제 말을 믿으셔야 합니다. 긴장 말아요 긴장 말아요 입 가리라니까 얼음',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0005',
'2025_0005',
'');

COMMIT;
