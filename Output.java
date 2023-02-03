import java.util.Arrays;

public class Output {
    void printSquadSet() {
        SquadSet squadset = new SquadSet();
        System.out.println("---SquadSet---");
        System.out.println("A 집합 = " + Arrays.toString(squadset.getResult(squadset.A)));
        System.out.println("B 집합 = " + Arrays.toString(squadset.getResult(squadset.B)));
        System.out.println("합집합(sum) = " + Arrays.toString(squadset.getResult(squadset.getSum(squadset.A, squadset.B))));
        System.out.println("차집합(complement) = " + Arrays.toString(squadset.getResult(squadset.getComplement(squadset.A, squadset.B))));
        System.out.println("교집합(intersect) = " + Arrays.toString(squadset.getResult(squadset.getIntersect(squadset.A, squadset.B))));
        System.out.println();
    }

    void printCountSet() {
        CountSet countset = new CountSet();
        System.out.println("---CountSet---");
        System.out.println("A Count집합 = " + countset.getResult(countset.A));
        System.out.println("B Count집합 = " + countset.getResult(countset.B));
        System.out.println("합집합(sum) = " + countset.getResult(countset.getSum(countset.B)));
        System.out.println("차집합(complement) = " + countset.getResult(countset.getComplement(countset.B)));
        System.out.println("교집합(intersect) = " + countset.getResult(countset.getIntersect(countset.B)));
    }
}
