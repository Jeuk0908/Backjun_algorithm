package Backjun_Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reverse_words {
    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //입력받은 n개의 케이스 만큼 문장 입력받음
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            //split() 으로 공백기준으로 나누고
            String strArr[] = str.split(" ");

            System.out.print("Case #" + (i + 1) + ": ");
            //인덱스를 1씩 뺴며 반대로 순회하며 출력
            for (int j = strArr.length - 1; j >= 0; j--) {
                System.out.print(strArr[j] + " ");
            }

            System.out.println();
        }
    }
}
