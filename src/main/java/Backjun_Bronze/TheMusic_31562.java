package Backjun_Bronze;

import java.util.*;

public class TheMusic_31562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        //아는 노래의 수 N과 시도할 노래 갯수 M 을 정수로 입력받음
        int N = sc.nextInt();
        int M = sc.nextInt();

        //
        sc.nextLine();

        //N번만큼 아는 노래 정보 입력받기
        Map<String, String> songs = new HashMap<>();
        for(int i=0; i < N; i++){
            //제목 길이 T 입력
            int T = sc.nextInt();
            //노래 제목 S 입력
            String S = sc.next();
            //음계 7개 받기 (공백 포함됨)
            String pitch = sc.nextLine();
            //answer와 비교 위해 pitch의 앞뒤 공백 제거 후 저장
            String pitches = pitch.trim();
            //입력받은 노래제목과 음계를 Map 에 입력
            songs.put(S, pitches);
        }

        //맞출 음 입력
        for(int ii=0; ii < M; ii++){
            int count = 0;
            String title = " ";
            String answer = sc.nextLine();

            //저장된 노래 음계와 입력받은 음계 순회, 비교
            for (String S : songs.keySet()) {
                //만약 입력된 음계와 저장된 음계의 첫 3개가 같으면
                if (songs.get(S).startsWith(answer)){
                    //순회 결과, 같은 음계의 노래가 몇개인지 count에 저장
                    count++;
                    //일치하는 음계의 노래제목 저장
                    title = S;
                }
            }

            //만약 일치하는 노래갯수가 1개 이면 노래제목 출력
            if (count == 1) {
                sb.append(title + '\n');
            } else if (count >= 2) {
                //2개 이상이면 '?' 출력
                sb.append("?\n");
            } else {
                //0개이면 '!' 출력
                sb.append("!\n");
            }
        }
        System.out.print(sb);
            }
        }