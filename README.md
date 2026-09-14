# Java Programming Coursework

> University Java Programming Course: Core Concepts, Practice Problems, and Assignments

이 저장소는 대학교 자바 프로그래밍 수업에서 다룬 실습 예제, 과제 및 프로젝트 코드를 기록하고 아카이빙하는 레포지토리입니다.

---

## 📌 Features & Topics Covered

- **Java Basics**: 변수, 데이터 타입, 조건문, 반복문, 배열
- **Object-Oriented Programming (OOP)**
    - 캡슐화(Encapsulation), 상속(Inheritance), 다형성(Polymorphism), 추상화(Abstraction)
    - 인터페이스(Interface) 및 추상 클래스(Abstract Class)
- **Data Structures & Collections Framework**: `List`, `Set`, `Map`, `Queue`
- **Exception Handling**: 예외 처리 메커니즘 (`try-catch-finally`, 사용자 정의 예외)
- **I/O & Streams**: 입출력 스트림, 파일 I/O
- **GUI Programming (선택)**: Java Swing / JavaFX

---

## 🛠 Tech Stack & Environment

- **Language**: Java (JDK 25)
- **IDE**: IntelliJ IDEA
- **Build Tool**: None (IntelliJ IDEA Built-in)
- **VCS**: Git, GitHub

---

## 📂 Repository Structure


```text
|---Main.java
|   
+---week01
|   |   TestMain.java
|   |   
|   +---sanguk
|           Errors.java
|           TestMain.java
|           
+---week02
|   +---example01
|   |       TestMain.java
|   |       
|   +---lab
|           TestMain.java  
+---week03
    +---sanguk
        +---example
        |         TestMain.java
        |
        +---Lab
                   lab01
```
---
## How to make Data Structure
```
# 터미널에서 src 폴더에서 폴더 구조 쉽게 뽑기
tree /f /a | clip
```

---

## 🚀 How to Run

### 터미널에서 직접 실행할 경우

```bash
# 1. 자바 소스 파일 컴파일
javac src/Main.java

# 2. 실행 (-cp => src안에 클래스 찾아서 실행)
java -cp src Main
```

---

## how to push to github
```bash
# 1. 변경된 모든 파일 스테이지 영역에 추가
git add .

# 2. 커밋 생성
git commit -m "변경된 사항"

# 3-1. 원격에 처음 psuh 하기
git push -u origin master

# 3-2. -u로 하고 그뒤로 같은 브랜치에 push 하기
git push
```
---


## 📝 License

This repository is for educational and study purposes.