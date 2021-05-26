package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("índique N: ");
        int totalPrint = scan.nextInt();

        System.out.println("índique M: ");
        int subject = scan.nextInt();

        int a = 0;
        for(int i = 0; a < totalPrint; i++) {
            System.out.println(i*subject);
            a++;
        }
    }
}


