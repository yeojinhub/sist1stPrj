-- '������' ���̺� ��������

select * from ADMIN;
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass01','��ö��','1990-05-15','010-1234-5678','����Ư���� ������ ���ﵿ 123-4');
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass02','�ڿ���','1985-09-25','010-2345-6789','�λ걤���� �ؿ�뱸 �µ� 56-7');
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass03','�����','1998-12-11','010-3456-7890','�뱸������ ������ ��� 89-10');
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass04','������','1993-03-30','010-4567-8901','��õ������ ������ ������ 11-12');
INSERT INTO ADMIN VALUES('admin' || LPAD(SEQ_ADM_ID.NEXTVAL, 2, '0'),'pass05','�ּ�ȣ','1995-07-19','010-5678-9012','���ֱ����� ���� �󼺵� 13-14');

-- '����' ���̺� ��������
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass01','�谭��','1982-06-22','010-6789-0123','����Ư���� ������ ���̵� 15-16');
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass02','�ڰ���','1979-11-10','010-7890-1234','���������� ������ ���� 17-18');
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass03','�̰���','1990-08-05','010-8901-2345','��걤���� ���� ��굿 19-20');
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass04','�ְ���','1985-02-14','010-9012-3456','��⵵ ������ �д籸 ���ڵ� 21-22');
INSERT INTO INSTRUCTOR VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_INST_NUM.NEXTVAL,'0000')),'pass05','������','1993-09-28','010-0123-4567','����ϵ� ���ֽ� ������ �ݾϵ� 23-24');

-- '�л�' ���̺� ��������
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass01','���л�','2005-05-21','010-2345-6789','����Ư���� ���ı� ������ 25-26','������');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass02','���л�','2004-09-15','010-3456-7890','��⵵ ������ �ȴޱ� �ΰ赿 27-28','����');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass03','���л�','2006-01-30','010-4567-8901','�λ걤���� ��� ���õ� 29-30','������');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass04','���л�','2003-07-11','010-5678-9012','�뱸������ �޼��� ������ 31-32','����');
INSERT INTO STUDENT VALUES(TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),'pass05','���л�','2005-12-02','010-6789-0123','���ֱ����� �ϱ� ��ϵ� 33-34','������');

-- '����' ���̺� ��������
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-1','[KDT] AI ������ �м��� �ӽŷ���','������','2025-02-01','2025-08-15','2025_0001');
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-2','[KDT] ���̽��� Ȱ���� �� ����','������','2025-03-10','2025-09-25','2025_0002');
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-3','[KDT] React & Node.js Ǯ���� ����','������','2025-04-20','2025-10-30','2025_0003');
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-4','[KDT] ���ü�� ��� ���ø����̼� ����','������','2025-05-15','2025-11-20','2025_0004');
INSERT INTO COURSE VALUES(SEQ_COUR_NUM.NEXTVAL,'25-5','[KDT] Ŭ���� ��ǻ�ð� DevOps','������','2025-06-01','2025-12-10','2025_0005');

-- '������' ���̺� ��������
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Python', '2025-04-15', 1);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Oracle', '2025-04-10', 1);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Frontend', '2025-04-20', 1);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Backend', '2025-05-01', 2);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Security', '2025-05-15', 3);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Cloud', '2025-05-20', 3);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'AI', '2025-05-25', 4);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'DevOps', '2025-06-01', 4);
INSERT INTO EXAM VALUES(SEQ_EXAM_NUM.NEXTVAL, 'Big Data', '2025-06-10', 5);


-- '���蹮��' ���̺� ��������
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Python�� ������ ���ǳ���?', 'A) �� ����, B) ������ ����, C) �ΰ�����, D) ���� ��� ��', 4, 1);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'SQL�� ������ �����ΰ���?', 'A) ����ȭ ���� ���, B) �ܼ� ���� ��, C) ���� ���� ���, D) ǥ��ȭ ���� ��', 1, 1);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'React�� �����ΰ���?', 'A) ���̺귯��, B) �����ӿ�ũ, C) �����ͺ��̽�, D) ����', 1, 1);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'REST�� ������ �����ΰ���?', 'A) ǥ�� ���� ����, B) ���� ���� �׽�Ʈ, C) ��� ���� �ý��� ����, D) �ŷ��� �� �ִ� ��ȣȭ ����', 1, 1);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '���� �� Ŭ���� �����ڰ� �ƴ� ����?', 'A) AWS, B) Azure, C) Docker, D) Google Cloud', 3, 1);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Oracle�� ��Ű���� �����ΰ���?', 'A) Ʈ������ ����, B) ��Ű�� ���� ��ü, C) ��� ����, D) �ý��� ���̺�', 2, 2);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Oracle���� ������ �ο��� �� ����ϴ� ��ɾ��?', 'A) GIVE, B) PERMIT, C) GRANT, D) ALLOW', 3, 2);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Oracle Database�� �⺻ ��Ʈ ��ȣ��?', 'A) 1433, B) 1521, C) 3306, D) 8080', 2, 2);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'PL/SQL ����� �ۼ��� �� �ַ� ����ϴ� ����?', 'A) Java, B) Python, C) SQL, D) PL/SQL', 4, 2);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Oracle���� Synonym�� �����ΰ���?', 'A) ��� ��Ű��, B) ���̺� �Ǵ� ���� ��Ī, C) ���ν����� ����, D) �����', 2, 2);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '�����ͺ��̽����� ����ȭ��?', 'A) ������ ���, B) �ߺ� ����, C) ������ ��ȣȭ, D) ���̺� ����', 2, 3);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '���� �� NoSQL �����ͺ��̽���?', 'A) MySQL, B) PostgreSQL, C) MongoDB, D) Oracle', 3, 3);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '�����ͺ��̽����� ACID�� ������ �����ΰ���?', 'A) ���ڼ�, �ϰ���, ����, ���Ӽ�, B) ����, ����, ���Ἲ, ������, C) �ڵ�, Ŀ��, ����, ���Ӽ�, D) �迭, ��, �ε���, ������', 1, 3);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '�ߺ��� ���� �����ϴ� SQL ����?', 'A) UNIQUE, B) DISTINCT, C) DELETE, D) FILTER', 2, 3);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '�ܷ� Ű(Foreign Key)�� �����ΰ���?', 'A) �׻� �⺻ Ű�� �����ϴ� Ű, B) ��ȣȭ�� ���� Ű, C) ���� ���̺��� �⺻ Ű, D) NULL�� ����ϴ� Ű', 1, 3);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '��ȣȭ�� �ֵ� ������?', 'A) ������ ����, B) UI ����ȭ, C) ������ ����, D) �ӵ� ���', 3, 4);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '���� �� ������ ��й�ȣ��?', 'A) 123456, B) password, C) Ab!9#Xy3, D) qwerty', 3, 4);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'HTTPS�� HTTP���� �����ϴ� ����?', 'A) �� ���� ������, B) ���� ���, C) ���� ���, D) �������� ����', 3, 4);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '���� �� �Ϲ����� �� ���� �������?', 'A) XSS, B) CSS, C) JSON, D) HTML', 1, 4);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '���� ���� ���ӿ� ���Ǵ� ����������?', 'A) FTP, B) SSH, C) SMTP, D) HTTP', 2, 4);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '��ǥ���� Ŭ���� ���� ������ü��?', 'A) Azure, B) Linux, C) Ubuntu, D) Android', 1, 5);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'IaaS�� ������ �����ΰ���?', 'A) �������̽� ����, B) ������ ����, C) �ν��Ͻ� �ý���, D) ���� API ����', 2, 5);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '��ü ����Ʈ��� ���ͳ��� ���� �����ϴ� ����?', 'A) SaaS, B) PaaS, C) IaaS, D) OSaaS', 1, 5);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Ŭ���� Ȯ�强(Scalability)�̶�?', 'A) ���� �ڿ� ���, B) �ڿ��� �ڵ� Ȯ��, C) ���� �ڿ� ó��, D) Ŭ���� ����', 2, 5);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '�� �������� ���� Ŭ���� ���� �����?', 'A) ���� Ŭ����, B) ���̺긮�� Ŭ����, C) ���� Ŭ����, D) ���� Ŭ����', 3, 5);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '��ǥ���� Ŭ���� ���� �����ڴ�?', 'A) Azure, B) ������, C) �����, D) �ȵ���̵�', 1, 6);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'IaaS�� ������ �����ΰ���?', 'A) �������̽� ����, B) ������ ����, C) �ν��Ͻ� �ý���, D) ���� API ����', 2, 6);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '��ü ����Ʈ��� ���ͳ����� �����ϴ� ����?', 'A) SaaS, B) PaaS, C) IaaS, D) OSaaS', 1, 6);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Ŭ���� Ȯ�强(Scalability)�̶�?', 'A) ������ �ڿ� ���, B) �ڵ� Ȯ�� �ڿ�, C) ���� �ڿ� ó��, D) Ŭ���� ����', 2, 6);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '�ϳ��� �������� ����ϴ� Ŭ���� ���� ����?', 'A) �ۺ� Ŭ����, B) ���̺긮�� Ŭ����, C) �����̺� Ŭ����, D) ���� Ŭ����', 3, 6);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'AI�� ������ �����ΰ���?', 'A) �ΰ�����, B) �ڵ� ����, C) ��� �Է�, D) �Ƴ��α� �������̽�', 1, 7);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '���� �� AI ���� ���α׷���?', 'A) ChatGPT, B) Google Docs, C) MS Paint, D) �޸���', 1, 7);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'AI���� ML�� ������ �����ΰ���?', 'A) �ӽŷ���, B) ���� ����, C) ��Ÿ ���, D) �ֽ� �н�', 1, 7);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'AI ���߿� �θ� ���Ǵ� ����?', 'A) HTML, B) C++, C) Python, D) CSS', 3, 7);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '�Ű��(Neural Network)�� �������� ������ �޾ҳ���?', 'A) CPU ������, B) �ΰ��� ��, C) ��ǻ�� �� ����Ʈ, D) ���� Ʈ��', 2, 7);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'DevOps���� CI/CD�� ������ �����ΰ���?', 'A) �ڵ� ��ȭ / �ڵ� �����, B) ������ ���� / ������ ����, C) ����� ���� ���� / ����� ���� ����, D) ������ �������̽� / ������ ����', 2, 8);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'CI/CD�� �Ϲ������� ���Ǵ� ������?', 'A) Jenkins, B) ���伥, C) �Ŀ�����Ʈ, D) �޸���++', 1, 8);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Docker�� �ֿ� ������?', 'A) �ؽ�Ʈ ����, B) �̹��� ó��, C) �����̳�ȭ, D) ������', 3, 8);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '���� ������ ���� �ý�����?', 'A) Git, B) Zoom, C) Discord, D) MS ����', 1, 8);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Kubernetes�� ������?', 'A) UI ����, B) �����̳� ����, C) SQL ���� �ۼ�, D) ���� ����͸�', 2, 8);

INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '�����Ͷ� �����ΰ���?', 'A) ���� �����ͼ�, B) ��뷮����ӡ��پ��� ������, C) ����ȭ�� �����͸�, D) ����� �����͸�', 2, 9);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '������ ó���� ���� ������?', 'A) Hadoop, B) Excel, C) �޸���, D) �׸���', 1, 9);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'MapReduce�� �����ΰ���?', 'A) ���� ����, B) ������ ���� ��, C) ��뷮 ������ ó���� ���α׷��� ��, D) ��ȣȭ ���', 3, 9);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, '���� �� �����Ϳ� �����ͺ��̽���?', 'A) Oracle, B) MongoDB, C) MySQL, D) Access', 2, 9);
INSERT INTO EXAM_QUESTION VALUES(SEQ_QUES_NUM.NEXTVAL, 'Spark�� ������ ���ǳ���?', 'A) ��ȭ ��Ʈ����, B) �ǽð� ������ ó��, C) ���� ����, D) ����� ����', 2, 9);


-- '��û����' ���̺� ��������
INSERT INTO APPLY_STEPS VALUES('2025_0001', 1);
INSERT INTO APPLY_STEPS VALUES('2025_0002', 2);
INSERT INTO APPLY_STEPS VALUES('2025_0003', 3);
INSERT INTO APPLY_STEPS VALUES('2025_0004', 4);
INSERT INTO APPLY_STEPS VALUES('2025_0005', 5);




select * from BOARD;
-- '�Խ���' ���̺� ��������
INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'���� ���� ����',
'���� ��¥�� ����Ǿ�����?',
'�亯�Ϸ�',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'����',
'�װ� ���� �ѹ� ã�ƺ��� �����帮�ڽ��ϴ�. ��? ���Ѱ� �ƴϽ��ݾƿ� �ȱ׷���?',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0001',
'2025_0001',
'');

INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'���� ���� ����',
'3���� ���� ���� �� ���ذ� �� ���� �κ��� �ֽ��ϴ�.',
'�亯�Ϸ�',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'������',
'���� ������ �ڼ��� �����ֽø� ���͵帮�ڽ��ϴ�.',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0001',
'',
'admin01');

INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'���� �ڷ� ��û',
'���� ���� �ڷḦ ���� �� �������?',
'�亯�Ϸ�',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'������',
'�̸��Ϸ� ������Ƚ��ϴ�.',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0003',
'',
'admin01');

INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'���� ��� Ȯ�� ��û',
'�� ������ �´��� Ȯ�� ��Ź�帳�ϴ�.',
'�亯�Ϸ�',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'����',
'������ ���� �̰����� �� �ҷ� ������ �۰� �޷��� ���� �� ���� �ٶ��',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0004',
'2025_0004',
'');

INSERT INTO BOARD VALUES(
SEQ_BOARD_NUM.NEXTVAL,
'���� ���� ���� ����',
'���� ���� ������ ���������ΰ���?',
'�亯�Ϸ�',
TO_CHAR(SYSDATE,'YYYY-MM-DD'),
'����',
'������ ���� ���� ���ܵ� ���� �� ���� �����ž� �մϴ�. ���� ���ƿ� ���� ���ƿ� �� ������ϱ� ����',
TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
'2025_0005',
'2025_0005',
'');

COMMIT;
