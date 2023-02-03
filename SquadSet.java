import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SquadSet {
    final List<Integer> A = Arrays.asList(1, 2, 3);
    final List<Integer> B = Arrays.asList(1, 3);

    List<Integer> getSum(List<Integer> A, List<Integer> B) {
        List<Integer> sum = new ArrayList<>(A);
        for (int element : B) {
            if (!sum.contains(element)) {
                sum.add(element);
            }
        }
        return sum;
    }

    List<Integer> getComplement(List<Integer> A, List<Integer> B) {
        List<Integer> complement = new ArrayList<>(A);
        complement.addAll(B);
        complement.removeAll(getIntersect(A, B));
        return complement;
    }

    List<Integer> getIntersect(List<Integer> A, List<Integer> B) {
        List<Integer> intersect = new LinkedList<>();
        for (int element : B) {
            if (A.contains(element)) {
                intersect.add(element);
            }
        }
        return intersect;
    }

    Object getResult(List<int[]> list) {
        return list.toArray();
    }
}
