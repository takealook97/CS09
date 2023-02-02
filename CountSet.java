import java.util.*;

public class CountSet {
    final List<Integer> A = Arrays.asList(1, 1, 2, 2, 3, 3);
    final List<Integer> B = Arrays.asList(1, 3, 3, 3);

    List<Integer> append(int input) {
        return null;
    }

    List<Integer> remove(int input) {
        return null;
    }

    int countFor(int input) {
        return 0;
    }

    List<Integer> getSum() {
        List<Integer> sum = new ArrayList<>(A);
        sum.addAll(B);
//        sum.removeAll(getIntersect());
//        sum.addAll(getIntersect());
        return sum;
    }

    List<Integer> getComplement() {
        List<Integer> complement = new ArrayList<>(A);
        for(int element : B){
            complement.remove(Integer.valueOf(element));
        }
        return complement;
    }

    List<Integer> getIntersect() {
        List<Integer> intersect = new LinkedList<>();
        for (int element : B) {
            if (A.contains(element) && !intersect.contains(element)) {
                intersect.add(element);
            }
        }
        return intersect;
    }

    Object getResult(List<Integer> input) {
        return input.toArray(new Integer[0]);
    }

    HashMap<Integer, Integer> count(List<Integer> input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index : input) {
            if (!map.containsKey(index)) {
                map.put(index, 1);
            } else {
                map.put(index, map.get(index) + 1);
            }
        }
        return map;
    }
}
