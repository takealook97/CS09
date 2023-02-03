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
Object[] getResult(List<Integer> list) {
    return list.toArray();
}
```
- 리스트를 받으면 모든 요소를 1차원 배열로 리턴한다.

## CountSet 클래스
```java
final List<int[]> A = List.of(new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2});
final List<int[]> B = List.of(new int[]{1, 1}, new int[]{3, 3});
```
- List가 Array를 들고있는 형태
- Array는 크기가 2이며 인덱스 0에는 원소, 인덱스 1에는 개수를 가지고 있다.

### append 메서드
```java
List<int[]> append(List<int[]> list, int input) {
    for (int[] element : list) {
        if (element[0] == input) {
            element[1]++;
            return list;
        }
    }
    list.add(new int[]{input, 1});
    return list;
}
```
- List와 더할 숫자를 받는다.
- 리스트에 있는 숫자이면 count값을 증가시켜주고 없는 숫자이면 새로 넣어주며 count에 1을 넣는다.

### remove 메서드
```java
List<int[]> remove(List<int[]> list, int input) {
    for (int[] element : list) {
        if (element[0] == input) {
            element[1]--;
            if (element[1] <= 0) {
                list.remove(element);
            }
            break;
        }
    }
    return list;
}
```
- append 메서드와 마찬가지로 List와 뺄 숫자를 받는다.
- 리스트에 있는 숫자이면 count값을 감소시켜주고 없는 숫자이면 무시한다.
- count값이 0이 되면 리스트에서 해당 원소 자체를 삭제한다.

### countFor 메서드
```java
int countFor(List<int[]> list, int input) {
    int count = 0;
    for (int[] element : list) {
        if (element[0] == input) {
            count = element[1];
            break;
        }
    }
    return count;
}
```
- List와 찾을 원소를 받는다.
- 리스트에서 배열의 0번째 인덱스의 값과 찾을 원소가 일치할 경우 카운트를 리턴한다.

### sum(합집합) 메서드
```java
List<int[]> getSum(List<int[]> B) {
    List<int[]> sum = new ArrayList<>(new CountSet().A);
    for (int[] element : B) {
        for (int i = 0; i < element[1]; i++) {
            append(sum, element[0]);
        }
    }
    return sum;
}
```
- sum에 List A를 넣어준다.
- List B를 기준으로 각각의 원소를 가진 갯수만큼 append 해준다.

### complement(차집합) 메서드
```java
List<int[]> getComplement(List<int[]> B) {
    List<int[]> complement = new ArrayList<>(new CountSet().A);
    for (int[] element : B) {
        for (int i = 0; i < element[1]; i++) {
            complement = remove(complement, element[0]);
        }
    }
    return complement;
}
```
- complement에 List A를 넣어준다.
- List B를 기준으로 각각의 원소를 가진 갯수만큼 remove 해준다.
- complement에 없는 원소일 경우 remove는 진행되지 않는다.

### intersect(교집합) 메서드
```java
List<int[]> getIntersect(List<int[]> B) {
    List<int[]> intersect = new ArrayList<>();
    for (int[] elementA : new CountSet().A) {
        for (int[] elementB : B) {
            if (elementA[0] == elementB[0]) {
                intersect.add(new int[]{elementB[0], 1});
            }
        }
    }
    return intersect;
}
```
- List A와 List B를 동시에 탐색하여 동일한 원소가 존재할 경우 intersect에 넣어준다.
- 여기서 미션의 조건에 따라 count값은 1로 지정한다.

### resultAll 메서드
```java
Object getResult(List<int[]> list) {
    StringBuilder sb = new StringBuilder();
    for (int[] element : list) {
        sb.append(Arrays.toString(element)).append(" ");
    }
    return sb.toString();
}
```
- 각각의 원소 배열([원소:갯수] 형태)을 StringBuilder에 넣어준다.
- String(Objet)형태로 리턴한다. 

---

# Mission 2. 고차함수 활용하기

- 