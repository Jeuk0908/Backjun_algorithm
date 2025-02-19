package Backjun_Bronze;

import java.util.ArrayList;
import java.util.Scanner;

public class changeBalls_10813 {
    private static ArrayList<Integer> ballsNum = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // 바구니의 갯수N 과 바꿀횟수 M 정수로 입력 -> N 은 배열로 만들기
        Scanner sc = new Scanner(System.in);
        String[] NM = sc.nextLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        //N범위의 바구니(공) 배열 생성
        for (int i = 0; i < N+1; i++) {
            ballsNum.add(i);
        }

        // 공 바꿀 바구니의 번호 i 와 j 를 M 번 입력받음
        for (int i = 0; i < M; i++) {
            String[] IJ = sc.nextLine().split(" ");
             int I = Integer.parseInt(IJ[0]);
             int J = Integer.parseInt(IJ[1]);
             //set 함수 사용해서 값 교환
            int temp = ballsNum.get(I);
            ballsNum.set(I, ballsNum.get(J));
            ballsNum.set(J, temp);
        }
        sc.close();

        //첫번째 인덱스의 0 제거
        ballsNum.remove(0);

        //배열의 요소만 출력
        for (int num : ballsNum) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
