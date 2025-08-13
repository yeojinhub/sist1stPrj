# sist1stPjr
sist 쌍용교육센터 1차 프로젝트
<br>
학원 통합 관리 프로그램 사이트
<br>
베스트캠퍼스(3/17~4/14)

<p>
<img width="100%" src="https://github.com/user-attachments/assets/0bf34c8e-783b-4661-a3b9-045cf49825f6">
</p>

<a id="목차"></a>
## 📌 목차
1. [📝 개요](#-개요)
2. [🎯 프로젝트 목표](#-프로젝트-목표)
3. [📅 개발기간](#-개발-기간)
4. [🧑‍🤝‍🧑 멤버 구성](#-멤버-구성)
5. [🛠️ 기술 스택](#기술스택)
6. [🗂 아키텍처 구조](#-아키텍처-구조)
7. [🎬 사용자 시연 영상](#-사용자-시연-영상)
8. [🎬 강사 시연 영상](#-강사-시연-영상)
9. [🎬 관리자 시연 영상](#-관리자-시연-영상)
10. [🛢 ERD Diagram](#-Entity-Relationship-Diagra)

## 📝 개요
> 🔹 **프로젝트명** : 베스트캠퍼스
>
> 🔹 **유형** : Java Swing 기반 학원 통합 관리 교육 프로그램
> 
> 🔹 **설명** :
> 
> 학생, 강사, 관리자용 프로그램을 하나의 통합 시스템으로 구축
> 
> 단일 데이터베이스를 기반으로 권한에 따라 기능을 분리한 학원 운영 솔루션
> 

## 🎯 프로젝트 목표
> 🔹 사용자별(학생/강사/관리자) 역할 특화 기능 제공
> 
> 🔹 학원 운영 업무 효율성 향상 및 정확한 데이터 관리
> 
> 🔹 원활한 커뮤니케이션 지원과 정보 일관성 확보
> 
<p align="right">
  <a href="#목차">🔝 목차로 돌아가기</a>
</p>

## 📅 개발 기간
> 2025-3-17 ~ 2025-4-14 (4주)
> 

## 🧑‍🤝‍🧑 멤버 구성
> ### 👩‍💻 이여진(조장)\[[GitHub : @yeojinhub\]](https://github.com/yeojinhub)
> 🔹 **관리자 로그인**
> 
> 🔹 **관리자 계정 관리** : 학생/강사/관리자 계정 CRUD
> 
> 🔹 **관리자 과정 조회**
>
> ### 👨‍💻 강태일(부조장)\[[GitHub : @tgncosist2\]](https://github.com/tgncosist2)
> 🔹 **학생 로그인 및 마이페이지** : 정보 변경
>
> 🔹 **학생 시험** : 시험 응시, 성적표 조회
>
> 🔹 **학생 게시판** : 1:1문의글 CRUD
>
> 🔹 **관리자 성적 조회** : 전체 수강생 성적 조회
>
> ### 👩‍💻 김민경\[[GitHub : @min-7343\]](https://github.com/min-7343)
> 🔹 **학생 기능** : UI 구현
>
> ### 👨‍💻 장태규\[[GitHub : @taegu825\]](https://github.com/taegu825)
> 🔹 **관리자 시험 관리** : 시험 관리 CRUD
>
> ### 👨‍💻 유명규\[[GitHub : @RyuMG\]](https://github.com/RyuMG)
> 🔹 **관리자 시험 관리** : 시험 관리 CRUD
> 
> ### 👨‍💻 이대웅\[[GitHub : @bkj0517\]](https://github.com/bkj0517)
> 🔹 **강사 로그인**
>
> 🔹 **강사 과정 조회, 시험 관리** : 담당 과정 조회, 과정 시험 조회
>
> 🔹 **강사 학생 관리, 성적 조회** : 담당 학생 정보 조회, 성적 조회
> 
> 🔹 **강사 게시판 관리** : 해당 강사에게 1:1문의 답변 CRUD
> 
> 🔹 **관리자 게시판 관리** : 전체 1:1문의 답변 CRUD
> 
<p align="right">
  <a href="#목차">🔝 목차로 돌아가기</a>
</p>

<a id="기술스택"></a>
## 🛠️ 기술 스택
> ### 🌐 UI / Client
> 
> ![Java Swing](https://img.shields.io/badge/java%20swing-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
>  
> ### ⚙️ Backend
>
> ![Java 17](https://img.shields.io/badge/java%2017-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
> ![JDBC](https://img.shields.io/badge/jdbc-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
> 
> ### 🛢 Database
> 
> ![Oracle Database 19c](https://img.shields.io/badge/Oracle%20Database%2019c-F80000?style=for-the-badge&logo=data:image/svg+xml;base64,PHN2ZyBmaWxsPSIjZmZmIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI0OCIgaGVpZ2h0PSI0OCIgdmlld0JveD0iMCAwIDQ4IDQ4Ij48ZWxsaXBzZSBjeD0iMjQiIGN5PSIxMiIgcng9IjIwIiByeT0iNiIvPjxlbGxpcHNlIGN4PSIyNCIgY3k9IjI0IiByeD0iMjAiIHJ5PSI2Ii8+PGVsbGlwc2UgY3g9IjI0IiBjeT0iMzYiIHJ4PSIyMCIgcnk9IjYiLz48L3N2Zz4=)
>
> ### 🧰 Development Tools
> 
> #### IDE ![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
> #### Build tools ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
> #### Version control ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
>
> ### 🤝 Collaboration Tools
>
> ![Microsoft PowerPoint](https://img.shields.io/badge/Microsoft_PowerPoint-B7472A?style=for-the-badge&logo=microsoft-powerpoint&logoColor=white)
> ![ERDCloud](https://img.shields.io/badge/ERDCloud-000000?style=for-the-badge&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA2NCA2NCI%2BPHJlY3QgeD0iMiIgeT0iMTgiIHdpZHRoPSIxOCIgaGVpZ2h0PSIyOCIgcng9IjMiIHJ5PSIzIiBmaWxsPSJ3aGl0ZSIvPjxyZWN0IHg9IjQ0IiB5PSIxOCIgd2lkdGg9IjE4IiBoZWlnaHQ9IjI4IiByeD0iMyIgcnk9IjMiIGZpbGw9IndoaXRlIi8%2BPHBhdGggZD0iTTI0LDMyIEwzNCwyMiBMNDQsMzIgTDM0LDQyIFoiIGZpbGw9IndoaXRlIi8%2BPC9zdmc%2B)
> ![draw.io](https://img.shields.io/badge/draw.io-F08705?style=for-the-badge&logo=diagramsdotnet&logoColor=white)
> ![KakaoTalk](https://img.shields.io/badge/kakaotalk-ffcd00.svg?style=for-the-badge&logo=kakaotalk&logoColor=000000)
> ![Discord](https://img.shields.io/badge/Discord-%235865F2.svg?style=for-the-badge&logo=discord&logoColor=white)
> 
<p align="right">
  <a href="#목차">🔝 목차로 돌아가기</a>
</p>

## 🗂 아키텍처 구조
> 🔹 **Java Swing + JDBC 기반 MVC 구조**
>
> GUI 이벤트 발생 시 Event 클래스에서 사용자의 액션을 감지하고,
> 
> 해당 요청을 Service 계층으로 전달하여 비즈니스 로직을 처리합니다.
> 
> Service 계층은 DAO를 통해 Oracle Database와 연동하며,
> 
> 데이터는 **VO**를 통해 화면과 로직 간에 전달됩니다.
>
> 🔹 **전체 흐름**
>
> **View(Java Swing)** → **Event** → **Service** → **DAO(JDBC + SQL Query)** → **DB**
> 
<p align="right">
  <a href="#목차">🔝 목차로 돌아가기</a>
</p>

## 🎬 사용자 시연 영상

<p>
<img width="100%" src="https://github.com/user-attachments/assets/5c3c5bb6-9267-4c4b-8e09-3e5e6b0da3f3">
</p>
<p align="right">
  <a href="#목차">🔝 목차로 돌아가기</a>
</p>

## 🎬 강사 시연 영상
수정중..

## 🎬 관리자 시연 영상
수정중..

## 🛢 Entity Relationship Diagram
> 
<p align="center">
<img width="70%" src="https://github.com/user-attachments/assets/16c1268d-3dd8-447a-bd96-1cbfe45676b2">
</p>
<p align="right">
  <a href="#목차">🔝 목차로 돌아가기</a>
</p>

## Class Diagram
>
> ### 관리자 Class Diagram
> 
<p align="center">
<img width="70%" src="https://github.com/user-attachments/assets/a44be7e1-c4e5-48f9-890c-349b5f56ca3f">
</p>

> ### 강사 Class Diagram
>
<p align="center">
<img width="70%" src="https://github.com/user-attachments/assets/083de11d-d0ed-41d0-9820-b7997f5f0d6c">
</p>

> ### 수강생 Class Diagram
> 
<p align="center">
<img width="70%" src="https://github.com/user-attachments/assets/be919456-1dee-41a3-802d-6f99dd655be3">
</p>
<p align="right">
  <a href="#목차">🔝 목차로 돌아가기</a>
</p>
