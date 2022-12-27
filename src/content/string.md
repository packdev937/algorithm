# String

---
## 개요
문자열로 분류된 알고리즘 문제들을 풀면서 관련된 알고리즘 기법이나 클래스, 매소드 등을 한 눈에 볼 수 있다면 조금 더 효율적인 공부가 될 수 있을 것 같다는 생각을 했습니다. 

---

## 목차
1. <a>시간 초과</a>
   2. StringBuilder
   3. BufferedReader
   4. KMP Algorithm
5. 정렬
6. 변환
   7. Integer to String
   8. Integer to Character
   9. Char [] to String
   10. Character to Integer
   11. String to Integer
   12. String to char []
   13. Array to ArrayList
   14. UTF-8
   15. Lowercase and Uppercase
7. NULL
8. 문자열 수정하기
9. 반복문 탈출
10. 문자열 뒤집기
11. 문자열에서 특정 문자 제거 하기 
12. String
13. StringBuilder 
14. StringTokenizer
15. ArrayList
16. Queue & Deque
17. HashMap
18. BufferedReader
19. BufferedWriter

---
## 내용

### 시간 초과
      알고리즘 문제를 푸는 것은 어렵지 않다. 하지만 제한된 시간 안에 제한된 공간을 이용하여 문제를 푸는 것은 어려울 수 있다. 
      문자열과 관련된 문제를 풀다보면 시간 초과가 종종 발생하는데 이를 여러 기법으로 통해 해결해보자. 

<strong>문자열을 계속해서 변경해주는 경우 String을 사용하면 시간 초과로 이어질 가능성이 있다</strong>

      String은 작은 변화에도 객체를 계속해서 생성한다. 
      만약 하나의 문자열에 많은 변경이 적용된다면 String 대신 StringBuilder를 사용하자.

<a> StringBuilder 알아보기 </a>

### 변환

#### Lowercase and Uppercase 

      대소문자 구분 없이 해당 문자가 문자열에 몇 개 포함되어 있는지 출력하는 문제가 있다고 가정하자.
      막연하게는 C가 입력되었다면 아스키 코드를 이용하여 c도 구하고 계산하면 되는거 아니야? 라고 생각할 수 있겠지만 복잡하다.
      
      이를 단순히 하기 위해서 우리는 String 클래스에 내장되어 있는 toLowerCase(), toUpperCase() 를 사용한다. 
      형을 하나로 통일한 후 비교를 하면 조금 더 쉽게 값을 구할 수 있다

예시 문제 
- Inflearn - 자바 알고리즘 문제풀이 입문 1-1번 
- Inflearn - 자바 알고리즘 문제풀이 입문 1-2번 



