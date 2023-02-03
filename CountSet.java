import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSet {
    final List<int[]> A = List.of(new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2});
    final List<int[]> B = List.of(new int[]{1, 1}, new int[]{3, 3});

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

    List<int[]> getSum(List<int[]> B) {
        List<int[]> sum = new ArrayList<>(new CountSet().A);
        for (int[] element : B) {
            for (int i = 0; i < element[1]; i++) {
                append(sum, element[0]);
            }
        }
        return sum;
    }

    List<int[]> getComplement(List<int[]> B) {
        List<int[]> complement = new ArrayList<>(new CountSet().A);
        for (int[] element : B) {
            for (int i = 0; i < element[1]; i++) {
                complement = remove(complement, element[0]);
            }
        }
        return complement;
    }

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

    Object getResult(List<int[]> list) {
        StringBuilder sb = new StringBuilder();
        for (int[] element : list) {
            sb.append(Arrays.toString(element)).append(" ");
        }
        return sb.toString();
    }
}