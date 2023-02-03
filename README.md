🎯 CS09 함수형 Set
=

# 학습목표

- 불변성 Immutable 값이나 변수 활용
- 함수가 참조 투명성을 지키며 나아가 부작용을 줄일 수 있도록 구현
- 순수함수(Pure Function)으로 구현
- 객체 단위로 설계하더라도 함수 단위 사고의 틀을 확장할 수 있다.
- 현대 언어를 이해하기 위해서 학습해야한다.

---

# Mission 1. 함수형 코드로 구현하기

- 두 개의 클래스를 가변 속성을 사용하여 1차적으로 구현
- 미션 2에서 중복코드를 줄이고 불변성, 참조투명성, 순수함수로 동작하는 함수형 표현으로 개선

## SquadSet 클래스

### sum(합집합) 메서드

```java
List<Integer> getSum(List<Integer> A,List<Integer> B){
    List<Integer> sum=new ArrayList<>(A);
    for(int element:B){
        if(!sum.contains(element)){
        sum.add(element);
        }
    }
    return sum;
}
```

- List A를 sum에 넣는다.
- List B를 탐색하며 sum에 포함되지 않았다면 원소를 추가한다.

### complement(차집합) 메서드
```java
List<Integer> getComplement(List<Integer> A, List<Integer> B) {
    List<Integer> complement = new ArrayList<>(A);
    complement.addAll(B);
    complement.removeAll(getIntersect(A, B));
    return complement;
}
```
- List A와 B를 모두 complement에 넣는다.
- complement에서 A와 B의 교집합을 모두 제거한다.

### intersect(교집합) 메서드
```java
List<Integer> getIntersect(List<Integer> A, List<Integer> B) {
    List<Integer> intersect = new LinkedList<>();
    for (int element : B) {
        if (A.contains(element)) {
            intersect.add(element);
        }
    }
    return intersect;
}
```
- List A를 기준으로 B의 원소를 가지고 있는지 여부를 판단
- 가지고 있을 경우 intersect에 추가한다.

### resultAll 메서드
```java
Integer[] getResult(List<Integer> list) {
    return list.toArray(new Integer[0]);
}
```
- 리스트를 받으면 모든 요소를 1차원 배열로 리턴한다.

## CountSet 클래스
- List가 Array를 들고있는 형태
- Array는 크기가 2이며 인덱스 0에는 원소, 인덱스 1에는 개수를 가지고 있다.

### 


---

# Mission 2. 고차함수 활용하기

- 