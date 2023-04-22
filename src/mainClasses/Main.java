package mainClasses;

public class Main {
    public static void main(String[] args) {
        Josephus j = new Josephus();
        int i = j.loese(5, 2);
        System.out.println(i);

        int tmp = ProjektEuler.sumMultiples(10);
        System.out.println(tmp);

        tmp = ProjektEuler.differenzQsSq(10);
        System.out.println(tmp);
    }
}
