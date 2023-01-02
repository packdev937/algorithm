# String

---

## 개요

문자열로 분류된 알고리즘 문제들을 풀면서 관련된 알고리즘 기법이나 클래스, 매소드 등을 한 눈에 볼 수 있다면 조금 더 효율적인 공부가 될 수 있을 것 같다는 생각을 했습니다.

---

## 목차

1. <a>시간 초과</a>
5. 정렬
6. 변환
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
<br><br>
<strong> Scanner 보다 Buffered </strong>

        기존에 쓰던 Scanner, System.out.print() 보다 더 빠른 속도를 자랑하는 것이 있는데 바로 BufferedReader, BufferedWriter 이다.
        보다 많은 양의 데이터를 처리할 때 유리하며 두 객체 모두 java.io 패키지에 속해있다. 

#### 둘의 비교 
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Hello World);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("Hello World!");
        bw.flush(); 

#### 주의할 점 

- readLine() 으로 값을 입력받을 때 String이 default 값이기 때문에 이를 int 값으로 전환하고자 하면 Integer.parseInt()를 사용해야 함
- Exception Handling을 해주어야 함 (IOException)
- 라인 단위로 입력받으며 한 줄에 여러 값이 입력 된 경우 StringTokenizer 혹은 split을 이용하여 Parsing
  - StringTokenizer st = new StringTokenizer(br.readLine());
  - String [] str = br.readLine().split(" ");
  - String [] str = br.readLine().split("\n");
- BufferedWriter의 경우 따로 개행 처리를 해주어야 함 
- flush(), clear() 순으로 마지막에 반드시 호출해주어야 함 
- BufferedReader()의 응용
  - 만약 여러 개의 Integer를 받아 사용해야 할 때는 어떡해야 할까?

        String [] S = br.readLine().split("");
        Integer.parseInt(s[0...n]);

### 변환

#### Lowercase and Uppercase

      대소문자 구분 없이 해당 문자가 문자열에 몇 개 포함되어 있는지 출력하는 문제가 있다고 가정하자.
      막연하게는 C가 입력되었다면 아스키 코드를 이용하여 c도 구하고 계산하면 되는거 아니야? 라고 생각할 수 있겠지만 복잡하다.
      
      이를 단순히 하기 위해서 우리는 String 클래스에 내장되어 있는 toLowerCase(), toUpperCase() 를 사용한다. 
      형을 하나로 통일한 후 비교를 하면 조금 더 쉽게 값을 구할 수 있다

예시 문제

- Inflearn - 자바 알고리즘 문제풀이 입문 1-1번
- Inflearn - 자바 알고리즘 문제풀이 입문 1-2번 

### 문자열 뒤집기

lt와 rt

