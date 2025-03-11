package Backjun_Bronze;

import java.util.Scanner;

public class Compare_1330 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int A = sc.nextInt();
        int B = sc.nextInt();

        if (A > B) {
            System.out.println(">");
        } else if (A < B) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}
