import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SquadSet {
    final List<Integer> A = Arrays.asList(1, 2, 3);
    final List<Integer> B = Arrays.asList(1, 3);

    List<Integer> getSum() {
        List<Integer> sum = new ArrayList<>(A);
        sum.addAll(B);
        sum.removeAll(getIntersect());
        sum.addAll(getIntersect());
        return sum;
    }

    List<Integer> getComplement() {
        List<Integer> complement = new ArrayList<>(A);
        complement.addAll(B);
        complement.removeAll(getIntersect());
        return complement;
    }

    List<Integer> getIntersect() {
        List<Integer> intersect = new LinkedList<>();
        for (int element : B) {
            if (A.contains(element)) {
                intersect.add(element);
            }
        }
        return intersect;
    }

    Integer[] getResult(List<Integer> input) {
        return input.toArray(new Integer[0]);
    }
}
