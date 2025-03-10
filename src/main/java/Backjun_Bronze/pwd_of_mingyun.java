package Backjun_Bronze;

import java.util.ArrayList;
import java.util.Scanner;

public class pwd_of_mingyun {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> wordList = new ArrayList<>();
    public static void main(String[] args) {
        //단어 개수 N 입력받기
        int N = sc.nextInt();
        //N 만큼 단어 입력받기
        for (int i = 0; i < N; i++) {
            wordList.add(sc.next());
        }
        sc.close();
        //반복문 (회문 확인)
        for (int i = 0; i < N; i++) {
            //조건문 (단어가, 뒤집은 단어와 같으면 단어길이, 가운데글자 출력)
            String word =  wordList.get(i);
            String reversed = new StringBuilder(word).reverse().toString(); //StringBuilder 로 역순으로 바꿈
            if (word.equals(reversed)) {
                char middle = word.charAt(word.length() / 2);
                System.out.println(word.length() + " " + middle);
                return;
            } else {
                //반복문 (역순 단어 확인)
                //단어를 뒤집어서 리스트 전부 순회
                for (String item : wordList) {
                    if (reversed.equals(item)) {
                        char middle = item.charAt(item.length() / 2);
                        System.out.println(item.length() + " " + middle);
                        return;
                    }
                }
            }
        }
    }
}
