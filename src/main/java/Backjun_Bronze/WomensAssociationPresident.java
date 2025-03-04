package Backjun_Bronze;

import java.util.Scanner;

public class WomensAssociationPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int k = sc.nextInt();  // 층
            int n = sc.nextInt();  // 호

            // DP 배열 생성 (0~14층, 1~14호)
            int[][] dp = new int[15][15];

            // 0층 초기화: 0층 i호에는 i명이 산다.
            for (int i = 1; i <= 14; i++) {
                dp[0][i] = i;
            }

            // DP 테이블 채우기
            for (int floor = 1; floor <= k; floor++) {
                for (int room = 1; room <= n; room++) {
                    dp[floor][room] = dp[floor][room - 1] + dp[floor - 1][room];
                }
            }
            // 결과 출력
            System.out.println(dp[k][n]);
        }
        sc.close();
    }
}
