package speicherKlassen;

import personenKlassen.Boxer;
import personenKlassen.Student;

public class PufferPaar {
    public static void main(String[] args){
        Puffer<Paar<Student, String>> servicePoint = new SchlangeMitArray<>(4);
        Puffer<Paar<Boxer, Boxer>> boxEvent = new StapelMitArray<>(3);

        Student student1 = new Student("Name1", "Vorname1", 1111111);
        Student student2 = new Student("Name2", "Vorname2", 1111112);
        Student student3 = new Student("Name3", "Vorname3", 1111113);
        Student student4 = new Student("Name4", "Vorname4", 1111114);
        Paar<Student, String> sP1 = new Paar<>(student1, "Frage1");
        Paar<Student, String> sP2 = new Paar<>(student2, "Frage2");
        Paar<Student, String> sP3 = new Paar<>(student3, "Frage3");
        Paar<Student, String> sP4 = new Paar<>(student4, "Frage4");
        servicePoint.insert(sP1);
        servicePoint.insert(sP2);
        servicePoint.insert(sP3);
        servicePoint.insert(sP4);

        Boxer boxer1 = new Boxer("Name1", "Vorname1", 81);
        Boxer boxer2 = new Boxer("Name2", "Vorname2", 82);
        Boxer boxer3 = new Boxer("Name3", "Vorname3", 83);
        Paar<Boxer, Boxer> bE1 = new Paar<>(boxer1, boxer2);
        Paar<Boxer, Boxer> bE2 = new Paar<>(boxer1, boxer3);
        Paar<Boxer, Boxer> bE3 = new Paar<>(boxer2, boxer3);
        boxEvent.insert(bE1);
        boxEvent.insert(bE2);
        boxEvent.insert(bE3);

        System.out.println("ServicePoint: ");
        int l = servicePoint.size();
        SchlangeMitArray<Paar<Student, String>> tmpservicePoint = (SchlangeMitArray<Paar<Student, String>>) servicePoint;
        for (int i = 0; i < l; i++){
            String tmp = "";
            tmp += (tmpservicePoint.front()).toString();
            System.out.println(tmp);
            tmpservicePoint.remove();
        }
        System.out.println();

        System.out.println("Box Event: ");
        l = boxEvent.size();
        StapelMitArray<Paar<Boxer, Boxer>> tmpboxEvent = (StapelMitArray<Paar<Boxer, Boxer>>) boxEvent;
        for (int i = 0; i < l; i++){
            String tmp = "";
            tmp += (tmpboxEvent.top()).toString();
            System.out.println(tmp);
            tmpboxEvent.remove();
        }
    }
}
