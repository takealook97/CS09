import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SquadSet {
    private final List<Integer> A = Arrays.asList(1, 2, 3);
    private final List<Integer> B = Arrays.asList(1, 3);

    public static void main(String[] args) {
//        SquadSet squadset = new SquadSet();
//        System.out.println(squadset.getIntersect());
//        System.out.println(squadset.getComplement());
//        System.out.println(squadset.getSum());
//        System.out.println(Arrays.toString(squadset.getResult(squadset.A)));
    }

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
