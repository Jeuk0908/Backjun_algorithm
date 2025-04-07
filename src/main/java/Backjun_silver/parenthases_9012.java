package Backjun_silver;

import java.util.Scanner;
import java.util.Stack;

public class parenthases_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트케이스 수 입력
        int testCase = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testCase; i++) {
            //괄호 문자열 입력(split 으로 분할)
            String[] brackets = sc.nextLine().split("");
            //스택 생성
            Stack<String> stack = new Stack<>();
            boolean isValid = true;

            for (String bracket : brackets) {
                //만약 왼쪽괄호면 스택에 푸시
                if (bracket.equals("(")) {
                    stack.push(bracket);
                    //오른쪽 괄호면 스택에 있는 왼쪽괄호 팝
                } else if (bracket.equals(")")) {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            //모두 VPN일 경우, 남아있는 왼쪽괄호는 없을것이기 때문에, 비어있으면 YES, 아니면 NO
            System.out.println(!stack.isEmpty() || !isValid ? "NO" : "YES");
        }
        //스캐너 닫기
        sc.close();
    }
}