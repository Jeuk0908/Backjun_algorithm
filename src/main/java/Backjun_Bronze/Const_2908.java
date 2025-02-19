package Backjun_Bronze;

import java.util.Scanner;

public class Const_2908 {
    private static Scanner sc = new Scanner(System.in);

    static int reverseNum(String num) {
        //StringBuilder 로 문자열을 뒤집음
        StringBuilder sb = new StringBuilder(num);
        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) {
        //문자열로 숫자 두개 배열에 입력받음
        String[] numArray = sc.nextLine().split(" ");

        //반전 후 정수로 바꿔주는 함수에 파라미터로 입력
        int firstNum = reverseNum(numArray[0]);
        int secondNum = reverseNum(numArray[1]);

        //더 큰 수 출력
        if (firstNum > secondNum) {
            System.out.println(firstNum);
        } else {
            System.out.println(secondNum);
        }
    }
}
