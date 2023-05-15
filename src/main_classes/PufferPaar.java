package main_classes;

import personen.Boxer;
import personen.Student;
import speicher.Paar;
import speicher.SchlangeMitArray;
import speicher.StapelMitArray;

public class PufferPaar {
    public static void main(String[] args){
        SchlangeMitArray<Paar<Student, String>> servicePoint = new SchlangeMitArray<>(4);
        StapelMitArray<Paar<Boxer, Boxer>> boxEvent = new StapelMitArray<>(3);

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
        for (int i = 0; i < l; i++){
            String tmp = "";
            tmp += (servicePoint.front()).toString();
            System.out.println(tmp);
            servicePoint.remove();
        }
        System.out.println();

        System.out.println("Box Event: ");
        l = boxEvent.size();
        for (int i = 0; i < l; i++){
            String tmp = "";
            tmp += (boxEvent.top()).toString();
            System.out.println(tmp);
            boxEvent.remove();
        }
    }
}
