public class Output {
    void printA(){
        SquadSet squadset = new SquadSet();
        System.out.println("A 집합 = " + squadset.A);
    }
    void printB(){
        SquadSet squadset = new SquadSet();
        System.out.println("B 집합 = " + squadset.B);
    }
    void printSum(){
        SquadSet squadset = new SquadSet();
        System.out.println("합집합 = " + squadset.getSum());
    }
    void printComplement(){
        SquadSet squadset = new SquadSet();
        System.out.println("차집합 = " + squadset.getComplement());
    }
    void printIntersect(){
        SquadSet squadset = new SquadSet();
        System.out.println("교집합 = " + squadset.getIntersect());
    }
}
