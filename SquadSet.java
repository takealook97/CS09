import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SquadSet {
    private final List<Integer> A = Arrays.asList(1, 2, 3);
    private final List<Integer> B = Arrays.asList(1, 3);

    public static void main(String[] args) {
        System.out.println(new SquadSet().getIntersect());
        System.out.println(new SquadSet().getComplement());
    }

    int[] getSum(int[] A, int[] B) {
        return null;
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

    int[] getResult() {
        return null;
    }
}
