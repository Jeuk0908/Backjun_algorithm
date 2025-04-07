package Backjun_silver;

import java.util.Scanner;

public class stars_10994 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //숫자 n 입력
        int size = 4 * (n - 1) + 1; //n 에 따른 상하단 별 갯수 수식
        char[][] arr = new char[size][size]; //이차원 배열

        // 배열을 공백으로 초기화
        for (int i = 0; i < size; i++) {
            //n 을 계산한 크기만큼, 이차원 배열 가로세로 사이즈 생성 (n계산값 X n계산값)
            for (int j = 0; j < size; j++) {
                arr[i][j] = ' ';
            }
        }

        // 각 레이어마다 별 채우기
        for (int layer = 0; layer < n; layer++) {
            //start 와 layer 은 이차원배열의 인덱스값으로 사용
            int start = layer * 2; //n=3 일때 0,2,4
            int end = size - layer * 2 - 1; //n=3 일때 8,6,4

            // 상단, 하단 줄 채우기
            for (int i = start; i <= end; i++) {  //0행과 8행 별로 채우기(처음 for 순회할때)
                arr[start][i] = '*';
                arr[end][i] = '*';
            }

            // 왼쪽과 오른쪽 열 채우기
            for (int i = start; i <= end; i++) { //0열과 8열 별로 채우기(처음 for 순회할때)
                arr[i][start] = '*';
                arr[i][end] = '*';
            }
        }

        // 결과 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
