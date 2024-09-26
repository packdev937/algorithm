package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 방금그곡 {
    class Info {
        int minutes;
        String title;
        int index; // 음악이 들어온 순서를 기억하기 위해 추가

        public Info(int minutes, String title, int index) {
            this.minutes = minutes;
            this.title = title;
            this.index = index;
        }
    }

    class Solution {

        String cSharp = "X";
        String dSharp = "Y";
        String fSharp = "Z";
        String gSharp = "K";
        String aSharp = "L";

        public String solution(String m, String[] musicinfos) {
            List<Info> answers = new ArrayList<>();
            m = replaceNote(m);

            for (int i = 0; i < musicinfos.length; i++) {
                StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
                int minutes = calculate(st.nextToken(), st.nextToken());
                String title = st.nextToken();
                String note = replaceNote(st.nextToken());

                if (contain(m, minutes, note)) {
                    answers.add(new Info(minutes, title, i));
                }
            }

            // 재생 시간이 길고, 동일할 경우 먼저 입력된 순서로 정렬
            Collections.sort(answers, (a, b) -> {
                if (b.minutes == a.minutes) {
                    return a.index - b.index; // 재생 시간이 같으면 먼저 입력된 순서
                } else {
                    return b.minutes - a.minutes; // 재생 시간이 긴 순서
                }
            });

            if (answers.size() == 0) {
                return "(None)";
            }

            return answers.get(0).title;
        }

        public boolean contain(String note, int minutes, String song) {
            StringBuilder ori = new StringBuilder();
            for (int i = 0; i < minutes / song.length(); i++) {
                ori.append(song);
            }

            int remainLength = minutes % song.length();
            if (remainLength > 0) {
                ori.append(song.substring(0, remainLength));
            }

            return ori.toString().contains(note);
        }

        public int calculate(String start, String end) {
            int startMinutes = getMinutes(start);
            int endMinutes = getMinutes(end);

            // 끝나는 시간이 시작 시간보다 작을 경우, 다음 날로 넘어간다.
            return endMinutes >= startMinutes ? endMinutes - startMinutes : endMinutes + 1440 - startMinutes;
        }

        public int getMinutes(String time) {
            StringTokenizer st = new StringTokenizer(time, ":");
            int startHour = Integer.parseInt(st.nextToken());
            int startMinute = Integer.parseInt(st.nextToken());

            return startHour * 60 + startMinute;
        }

        public String replaceNote(String target) {
            target = target.replaceAll("C#", cSharp);
            target = target.replaceAll("D#", dSharp);
            target = target.replaceAll("F#", fSharp);
            target = target.replaceAll("G#", gSharp);
            target = target.replaceAll("A#", aSharp);
            target = target.replaceAll("B#", "M");

            return target;
        }
    }
}
