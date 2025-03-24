package Backjun_silver;

import java.util.*;

public class A_Man_in_company_7785 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //테스트케이스 횟수 N 입력
        int N = sc.nextInt();
        sc.nextLine();
        Set<String> employees = new HashSet<>();
        //회사 내에 있는 직원 목록

        //N 만큼 직원 입력
        for (int i = 0; i < N; i++){
            String[] log = sc.nextLine().split(" ");
            String employeeName = log[0];
            String status = log[1];


            //enter 이면 sb 에 추가
            if (status.equals("enter")) {
                employees.add(employeeName);
                //leave 이면 제거
            } else if (status.equals("leave")) {
                employees.remove(employeeName);
            }
        }
        //남아있는 직원들을 역알파벳 순으로 정렬
        //set 자료형은 순서가 보장되지 않기때문에 List자료형으로 타입캐스팅
        List<String> sortedEmployee = new ArrayList<>(employees);
        //Collection 의 정렬함수 사용.
        //파라미터로 .reverseOrder() 메소드를 추가해서 역순으로 정렬방법 지정
        Collections.sort(sortedEmployee, Collections.reverseOrder());

        System.out.println(String.join("\n", sortedEmployee));
    }
}
