package main_classes;

import speicher.MyFloat;

public class Main {
    public static void main(String[] args) {
        MyFloat m1 = new MyFloat(1, 50);
        MyFloat m2 = new MyFloat(1, 50);
        m1.add(m2);
        System.out.println(m1);
        m1 = new MyFloat(1, 50);
        m1.sub(m2);
        System.out.println(m1);
        m1 = new MyFloat(1, 50);
        m1.mul(m2);
        System.out.println(m1);
        m1 = new MyFloat(1, 50);
        m1.div(m2);
        System.out.println(m1);
    }
}
