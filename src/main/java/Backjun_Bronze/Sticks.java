package Backjun_Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sticks {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 막대기 개수 N 입력
        int N = Integer.parseInt(bf.readLine());
        Stack <Integer> stack = new Stack <Integer>();

        //N개만큼 입력 받은 후
        for (int i = 0; i<N; i++) {
            int h = Integer.parseInt(bf.readLine());
            //스택형태의 stack 에서 peek 으로 최상단의 값이 앞에서 입력받은 값보다 작은걸 pop
            while (!stack.isEmpty()&&h>=stack.peek()) stack.pop(); // 현재 값보다 작은 peek() 값 pop()
            stack.push(h);
        }

        // 출력
        System.out.println(stack.size());
    }
}