package Backjun_Bronze;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HalliGalli_27160 {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Integer> fruits = new HashMap<>();
    public static void main(String[] args) {
        //카드개수 N 입력
        int N = sc.nextInt();
        sc.nextLine();
        //과일, 갯수 를 한줄에, N번 입력받음
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            String fruit = parts[0];
            int count = Integer.parseInt(parts[1]);

            if (fruits.containsKey(fruit)) {
                fruits.put(fruit, fruits.get(fruit) + count);
            } else {
                fruits.put(fruit, count);
            }
        }

        boolean five = false;
        for(String entry : fruits.keySet()){
            //전체 순회하고, 있는지 없는지만 확인하면 되는데...
            if (fruits.get(entry) == 5) {
                five = true;
            }
        }
        if (five) {
            System.out.println("YES");
        } else if (five == false){
            System.out.println("NO");
        }
    }
}
