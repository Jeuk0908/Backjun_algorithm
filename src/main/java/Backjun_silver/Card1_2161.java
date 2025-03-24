package Backjun_silver;

import java.util.ArrayList;
import java.util.Scanner;

public class Card1_2161 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //카드 개수 N 입력
        int N = sc.nextInt();
        //카드 담을 배열 생성
        ArrayList<Integer> cardList = new ArrayList<>();
        //최종적으로 순서 결정된 카드 배열 생성
        ArrayList<Integer> abandonedCard = new ArrayList<>();
        sc.close();
        //1 부터 N 까지 배열(ArrayList) 에 추가
        for (int i = 1; i <= N; i++){
            cardList.add(i);
        }

        //카드가 1장만 남을때까지 지속
        while (cardList.size() > 1){
            //첫번째 카드 버리고, 버려진카드 배열에 추가
            abandonedCard.add(cardList.remove(0));
            //다음카드 뒤로 보내기
            cardList.add(cardList.remove(0));
        }
        //마지막 남은 카드 추가
        abandonedCard.add(cardList.get(0));
        for (Integer card : abandonedCard) {
            System.out.print(card + " ");
        }
    }
}

