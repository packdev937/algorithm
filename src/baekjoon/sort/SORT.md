정렬
    Java는 수 많은 자료구조를 지원하고 있으며, 각 자료구조 마다 각기 다른 방법으로 요소들을 정렬할 수 있다. 
    정렬은 크게 오름차순 정렬과 내림차순 정렬 두 가지로 나누어진다. 

오름차순 정렬
(1) Arrays.baekjoon.sort()
    만약 정렬하고자 하는 요소의 타입이 Primitive Type 이라면 Arrays.baekjoon.sort()를 사용하자. 
    새로운 배열을 생성하는 것이 아닌 저장되어 있는 요소들을 그대로 사용하여 내부적으로 정렬한다. 

예제 문제) 백준 2752번 

(2) Comparable 인터페이스 상속
    객체 값을 정렬해야 할 때 사용한다. 우선 클래스에 Comparable<Object> 을 상속 한 뒤 compareTo 메소드를 오버라이드 한다.
    예를 들어, 좌표 (x,y) 값을 정렬하려고 하는데 x값을 우선적으로 정렬한다고 해보자.

예제 코드)
    class Point implements Comparable<Point> {
        int x, y;
        @Override
        public int compareTo(Point o){
            return this.x - o.x;
        }
    }

예제 문제) 백준 11650번 

내림차순 정렬
(1) Arrays.baekjoon.sort(), Collections.reverseOrder()
    거꾸로 정렬하고 싶다면 Collection 클래스의 reverseOrder() 메소드를 사용하자. 
    주의할 점은 Collections 내에 있기 때문에 Primitive Type 대신 Wrapper 클래스를 사용해야 한다.

예제 코드)
    Integer [] array = {1, 2, 3, 4, 5};
    Arrays.baekjoon.sort(array, Collections.reverseOrder());

(2) TreeSet, Collections.reverseOrder()

정렬의 응용
(1) 길이에 따라 정렬
    Arrays.baekjoon.sort(array, (String s1, String s2) -> s1.length() - s2.length());
(2) HashMap 에서 key, value를 통해 정렬
(3) ArrayList 정렬
(4) 입력한 숫자가 Data Set에 있는지 없는지 확인하기 
    HashMap과 getOrDefault를 사용하자

예시 문제) 1920번 