๐ฏ CS09 ํจ์ํ Set
=

# ํ์ต๋ชฉํ

- ๋ถ๋ณ์ฑ Immutable ๊ฐ์ด๋ ๋ณ์ ํ์ฉ
- ํจ์๊ฐ ์ฐธ์กฐ ํฌ๋ช์ฑ์ ์งํค๋ฉฐ ๋์๊ฐ ๋ถ์์ฉ์ ์ค์ผ ์ ์๋๋ก ๊ตฌํ
- ์์ํจ์(Pure Function)์ผ๋ก ๊ตฌํ
- ๊ฐ์ฒด ๋จ์๋ก ์ค๊ณํ๋๋ผ๋ ํจ์ ๋จ์ ์ฌ๊ณ ์ ํ์ ํ์ฅํ  ์ ์๋ค.
- ํ๋ ์ธ์ด๋ฅผ ์ดํดํ๊ธฐ ์ํด์ ํ์ตํด์ผํ๋ค.

---

# Mission 1. ํจ์ํ ์ฝ๋๋ก ๊ตฌํํ๊ธฐ

- ๋ ๊ฐ์ ํด๋์ค๋ฅผ ๊ฐ๋ณ ์์ฑ์ ์ฌ์ฉํ์ฌ 1์ฐจ์ ์ผ๋ก ๊ตฌํ
- ๋ฏธ์ 2์์ ์ค๋ณต์ฝ๋๋ฅผ ์ค์ด๊ณ  ๋ถ๋ณ์ฑ, ์ฐธ์กฐํฌ๋ช์ฑ, ์์ํจ์๋ก ๋์ํ๋ ํจ์ํ ํํ์ผ๋ก ๊ฐ์ 

## SquadSet ํด๋์ค

### sum(ํฉ์งํฉ) ๋ฉ์๋

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

- List A๋ฅผ sum์ ๋ฃ๋๋ค.
- List B๋ฅผ ํ์ํ๋ฉฐ sum์ ํฌํจ๋์ง ์์๋ค๋ฉด ์์๋ฅผ ์ถ๊ฐํ๋ค.

### complement(์ฐจ์งํฉ) ๋ฉ์๋
```java
List<Integer> getComplement(List<Integer> A, List<Integer> B) {
    List<Integer> complement = new ArrayList<>(A);
    complement.addAll(B);
    complement.removeAll(getIntersect(A, B));
    return complement;
}
```
- List A์ B๋ฅผ ๋ชจ๋ complement์ ๋ฃ๋๋ค.
- complement์์ A์ B์ ๊ต์งํฉ์ ๋ชจ๋ ์ ๊ฑฐํ๋ค.

### intersect(๊ต์งํฉ) ๋ฉ์๋
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
- List A๋ฅผ ๊ธฐ์ค์ผ๋ก B์ ์์๋ฅผ ๊ฐ์ง๊ณ  ์๋์ง ์ฌ๋ถ๋ฅผ ํ๋จ
- ๊ฐ์ง๊ณ  ์์ ๊ฒฝ์ฐ intersect์ ์ถ๊ฐํ๋ค.

### resultAll ๋ฉ์๋
```java
Object[] getResult(List<Integer> list) {
    return list.toArray();
}
```
- ๋ฆฌ์คํธ๋ฅผ ๋ฐ์ผ๋ฉด ๋ชจ๋  ์์๋ฅผ 1์ฐจ์ ๋ฐฐ์ด๋ก ๋ฆฌํดํ๋ค.

---

## CountSet ํด๋์ค
```java
final List<int[]> A = List.of(new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2});
final List<int[]> B = List.of(new int[]{1, 1}, new int[]{3, 3});
```
- List๊ฐ Array๋ฅผ ๋ค๊ณ ์๋ ํํ
- Array๋ ํฌ๊ธฐ๊ฐ 2์ด๋ฉฐ ์ธ๋ฑ์ค 0์๋ ์์, ์ธ๋ฑ์ค 1์๋ ๊ฐ์๋ฅผ ๊ฐ์ง๊ณ  ์๋ค.

### append ๋ฉ์๋
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
- List์ ๋ํ  ์ซ์๋ฅผ ๋ฐ๋๋ค.
- ๋ฆฌ์คํธ์ ์๋ ์ซ์์ด๋ฉด count๊ฐ์ ์ฆ๊ฐ์์ผ์ฃผ๊ณ  ์๋ ์ซ์์ด๋ฉด ์๋ก ๋ฃ์ด์ฃผ๋ฉฐ count์ 1์ ๋ฃ๋๋ค.

### remove ๋ฉ์๋
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
- append ๋ฉ์๋์ ๋ง์ฐฌ๊ฐ์ง๋ก List์ ๋บ ์ซ์๋ฅผ ๋ฐ๋๋ค.
- ๋ฆฌ์คํธ์ ์๋ ์ซ์์ด๋ฉด count๊ฐ์ ๊ฐ์์์ผ์ฃผ๊ณ  ์๋ ์ซ์์ด๋ฉด ๋ฌด์ํ๋ค.
- count๊ฐ์ด 0์ด ๋๋ฉด ๋ฆฌ์คํธ์์ ํด๋น ์์ ์์ฒด๋ฅผ ์ญ์ ํ๋ค.

### countFor ๋ฉ์๋
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
- List์ ์ฐพ์ ์์๋ฅผ ๋ฐ๋๋ค.
- ๋ฆฌ์คํธ์์ ๋ฐฐ์ด์ 0๋ฒ์งธ ์ธ๋ฑ์ค์ ๊ฐ๊ณผ ์ฐพ์ ์์๊ฐ ์ผ์นํ  ๊ฒฝ์ฐ ์นด์ดํธ๋ฅผ ๋ฆฌํดํ๋ค.

### sum(ํฉ์งํฉ) ๋ฉ์๋
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
- sum์ List A๋ฅผ ๋ฃ์ด์ค๋ค.
- List B๋ฅผ ๊ธฐ์ค์ผ๋ก ๊ฐ๊ฐ์ ์์๋ฅผ ๊ฐ์ง ๊ฐฏ์๋งํผ append ํด์ค๋ค.

### complement(์ฐจ์งํฉ) ๋ฉ์๋
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
- complement์ List A๋ฅผ ๋ฃ์ด์ค๋ค.
- List B๋ฅผ ๊ธฐ์ค์ผ๋ก ๊ฐ๊ฐ์ ์์๋ฅผ ๊ฐ์ง ๊ฐฏ์๋งํผ remove ํด์ค๋ค.
- complement์ ์๋ ์์์ผ ๊ฒฝ์ฐ remove๋ ์งํ๋์ง ์๋๋ค.

### intersect(๊ต์งํฉ) ๋ฉ์๋
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
- List A์ List B๋ฅผ ๋์์ ํ์ํ์ฌ ๋์ผํ ์์๊ฐ ์กด์ฌํ  ๊ฒฝ์ฐ intersect์ ๋ฃ์ด์ค๋ค.
- ์ฌ๊ธฐ์ ๋ฏธ์์ ์กฐ๊ฑด์ ๋ฐ๋ผ count๊ฐ์ 1๋ก ์ง์ ํ๋ค.

### resultAll ๋ฉ์๋
```java
Object getResult(List<int[]> list) {
    StringBuilder sb = new StringBuilder();
    for (int[] element : list) {
        sb.append(Arrays.toString(element)).append(" ");
    }
    return sb.toString();
}
```
- ๊ฐ๊ฐ์ ์์ ๋ฐฐ์ด([์์:๊ฐฏ์] ํํ)์ StringBuilder์ ๋ฃ์ด์ค๋ค.
- String(Object)ํํ๋ก ๋ฆฌํดํ๋ค. 

---

# Mission 2. ๊ณ ์ฐจํจ์ ํ์ฉํ๊ธฐ

- 