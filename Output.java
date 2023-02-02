public class Output {
    void printSquadSet() {
        SquadSet squadset = new SquadSet();
        System.out.println("---SquadSet---");
        System.out.println("A 집합 = " + squadset.A);
        System.out.println("B 집합 = " + squadset.B);
        System.out.println("합집합(sum) = " + squadset.getSum(squadset.A, squadset.B));
        System.out.println("차집합(complement) = " + squadset.getComplement(squadset.A, squadset.B));
        System.out.println("교집합(intersect) = " + squadset.getIntersect(squadset.A, squadset.B));
        System.out.println();
    }

    void printCountSet() {
        CountSet countset = new CountSet();
        System.out.println("---CountSet---");
        System.out.println("A Count집합 = " + countset.count(countset.A));
        System.out.println("B Count집합 = " + countset.count(countset.B));
        System.out.println("합집합(sum) = " + countset.count(countset.getSum(countset.A, countset.B)));
        System.out.println("차집합(complement) = " + countset.count(countset.getComplement(countset.A, countset.B)));
        System.out.println("교집합(intersect) = " + countset.count(countset.getIntersect(countset.A, countset.B)));
    }
}
