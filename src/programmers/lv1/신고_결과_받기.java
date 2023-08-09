package programmers.lv1;

import java.util.*;

public class 신고_결과_받기 {

    static HashMap<String, Integer> map = new HashMap<>();

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 중복 제거
        HashSet<String> set = new HashSet<>(Arrays.asList(report));
        report = set.toArray(new String[0]);
        // 아이디별 신고 횟수 저장
        HashMap<String, Integer> reportCounts = new HashMap<>();
        for (String r : report) {
            String reported = r.split(" ")[1];
            reportCounts.put(reported, reportCounts.getOrDefault(reported, 0) + 1);
        }

        // 아이디별 신고된 아이디 그룹화
        HashMap<String, Set<String>> reportGroups = new HashMap<>();
        for (String r : report) {
            String reporter = r.split(" ")[0];
            String reported = r.split(" ")[1];
            if (!reportGroups.containsKey(reporter)) {
                reportGroups.put(reporter, new HashSet<>());
            }
            reportGroups.get(reporter).add(reported);
        }

        // 아이디별 처리
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            Set<String> reportedByThisId = reportGroups.getOrDefault(id, Collections.emptySet());
            for (String reported : reportedByThisId) {
                if (reportCounts.get(reported) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"muzi", "frodo", "apeach", "neo"},
            new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }
    }
}