package org.example;

import java.util.Scanner;

class Base {
    public Base(String s) {
        System.out.println("B");
    }

    Base() {
    }
}

public class Main {

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a + b;
        String d = new String("ab");
        String e = new String("a");
        System.out.println(e);
        System.out.println(a + b == c);
        System.out.println(c.equals(d));
        System.out.println((a+b).equals(c));
        System.out.println(c == d);
    }
}
