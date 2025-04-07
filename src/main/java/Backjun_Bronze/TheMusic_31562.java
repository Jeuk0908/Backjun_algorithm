package Backjun_Bronze;

import java.util.*;
import java.io.*;

public class TheMusic_31562 {

    // 음을 숫자로 매핑하는 딕셔너리(맵)
    // (C=0, D=2, E=4, F=5, G=7, A=9, B=11)
    static Map<String, Integer> noteToNum = new HashMap<>();
    static {
        noteToNum.put("C", 0);
        noteToNum.put("D", 2);
        noteToNum.put("E", 4);
        noteToNum.put("F", 5);
        noteToNum.put("G", 7);
        noteToNum.put("A", 9);
        noteToNum.put("B", 11);
    }

    // 인접 음 사이의 음정(interval)을 구하는 메서드
    // 예: ["C", "C", "G"] -> [0, 7] (C->C = 0, C->G = 7)
    private static List<Integer> getIntervals(String[] notes) {
        List<Integer> intervals = new ArrayList<>();
        if (notes.length < 2) {
            // 음이 1개 이하라면 인접 차이가 없으니 그냥 빈 리스트 반환
            return intervals;
        }
        // 음을 숫자로 변환
        int[] nums = new int[notes.length];
        for (int i = 0; i < notes.length; i++) {
            nums[i] = noteToNum.get(notes[i]);
        }

        // 인접 차이를 구해 intervals에 담기
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i+1] - nums[i];
            // 음정 차이가 음수이면 12를 더해 양수로 (모듈로 12)
            diff = (diff % 12 + 12) % 12;
            intervals.add(diff);
        }

        return intervals;
    }

    // 전체 패턴 fullPattern 안에 subPattern이 연속해서 존재하는지 확인하는 메서드
    // 가장 간단한 O(M*N) 방식의 나이브 탐색!
    private static boolean containsPattern(List<Integer> fullPattern, List<Integer> subPattern) {
        if (subPattern.isEmpty()) {
            // 찾을 패턴이 빈 리스트라면, 뭐… 그냥 존재한다고 볼 수도 있겠죠
            return true;
        }
        int fullSize = fullPattern.size();
        int subSize = subPattern.size();

        if (subSize > fullSize) {
            return false;
        }

        for (int start = 0; start <= fullSize - subSize; start++) {
            boolean match = true;
            for (int j = 0; j < subSize; j++) {
                if (!fullPattern.get(start + j).equals(subPattern.get(j))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // 스캐너로 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 곡의 개수
        int S = Integer.parseInt(st.nextToken()); // 찾을 패턴(질의) 개수

        // 곡 정보를 저장할 리스트 (곡 제목과 intervals)
        List<Song> songs = new ArrayList<>();

        // N개의 곡 정보 입력받아 처리
        for (int i = 0; i < N; i++) {
            // 한 줄을 통째로 읽고, 스플릿!
            String line = br.readLine().trim();
            String[] parts = line.split("\\s+");
            String title = parts[0];
            String[] notes = Arrays.copyOfRange(parts, 1, parts.length);

            // intervals 구하기
            List<Integer> intervals = getIntervals(notes);

            // 곡 리스트에 저장
            songs.add(new Song(title, intervals));
        }

        // S번의 질의(패턴) 처리
        for (int i = 0; i < S; i++) {
            String line = br.readLine().trim();
            String[] queryNotes = line.split("\\s+");

            // queryIntervals 구하기
            List<Integer> queryIntervals = getIntervals(queryNotes);

            // 해당 패턴을 포함하는 곡 찾기
            String foundTitle = null;
            for (Song song : songs) {
                if (containsPattern(song.intervals, queryIntervals)) {
                    foundTitle = song.title;
                    break;
                }
            }

            // 결과 출력
            if (foundTitle != null) {
                System.out.println(foundTitle);
            } else {
                System.out.println("?");
            }
        }
    }

    // 곡 정보를 저장하기 위한 간단한 클래스
    static class Song {
        String title;
        List<Integer> intervals;

        public Song(String title, List<Integer> intervals) {
            this.title = title;
            this.intervals = intervals;
        }
    }
}
