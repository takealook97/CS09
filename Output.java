public class Output {
    void printSquadSet() {
        SquadSet squadset = new SquadSet();
        System.out.println("---SquadSet---");
        System.out.println("A 집합 = " + squadset.A);
        System.out.println("B 집합 = " + squadset.B);
        System.out.println("합집합 = " + squadset.getSum());
        System.out.println("차집합 = " + squadset.getComplement());
        System.out.println("교집합 = " + squadset.getIntersect());
    }

    void printCountSet() {
        CountSet countset = new CountSet();

    }
}
