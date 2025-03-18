package Backjun_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CD_4158 {
    public static void main(String[] args) throws IOException {
        //입력 속도 개선 위해 BufferReader, StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            //br로 받은 CD의 개수 값을 StringTokenizer 로 나눠 N과M 에 대입
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;  // 종료 조건 0 0

            //N 에 대한 입력갑 배열 생성
            int[] cdn = new int[N];
            for (int i = 0; i < N; i++) {
                cdn[i] = Integer.parseInt(br.readLine());
            }

            //M 에 대한 입력갑 배열 생성
            int[] cdm = new int[M];
            for (int i = 0; i < M; i++) {
                cdm[i] = Integer.parseInt(br.readLine());
            }

            // 두 배열은 이미 정렬되어 있다고 문제에서 보장함 (만약 아니라면 정렬해줘야 함)
            int i = 0, j = 0, count = 0;

            //두 포인터 알고리즘 적용 (한 요소가 모두 순회하지 않고, 한번만 순회하므로 시간, 자원 효율적)
            while(i < N && j < M) {
                //두 배열에 같은 값이 있으면 count변수 1증가
                if (cdn[i] == cdm[j]) {
                    count++;
                    //배열의 다음요소
                    i++;
                    j++;
                } else if (cdn[i] < cdm[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            //StringBuilder 에 count값 추가
            sb.append(count);
        }
        System.out.print(sb);
    }
}
