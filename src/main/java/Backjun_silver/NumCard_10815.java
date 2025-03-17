package Backjun_silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumCard_10815 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //카드개수 N 입력받기
        int N = sc.nextInt();
        sc.nextLine();
        //N개의 정수값 받기 (배열)
        int[] Nnumbers = new int[N];
        for (int i = 0; i < N; i++) {
            Nnumbers[i] = sc.nextInt();
        }

        //배열 정렬 (이진탐색 알고리즘 사용 하기 위해)
        Arrays.sort(Nnumbers);

        //주어질 숫자 개수 M 받기
        int M = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        //M개의 정수값 받기 (배열)
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            // 이진 탐색 사용. 값이 있으면 index가 0 이상, 없으면 음수 반환
            if (Arrays.binarySearch(Nnumbers, num) >= 0) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }
}
