package Backjun_silver;

import java.util.Scanner;
//거스름돈 12916번
public class change_14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //거스름돈 액수 N 입력
        int N = sc.nextInt();
        int count = 0;

        while(true){
            //금액을 5원으로 나눠서 0이면 금액을 5로 나눈 값(=5원 동전 갯수) 출력
            if(N%5 == 0){
                count += N/5;
                System.out.println(count);
                break;
            }else{
                //5로 나눠도 금액이 남으면 2로 계속 빼면서 동전개수(count) 를 계속 하나씩 늘린다.
                N -= 2;
                count++;
            }
            //입력받은 금액이 거슬러줄 수 없으면 -1 출력
            if(N < 0){
                System.out.println(-1);
                break;
            }
        }
    }
}