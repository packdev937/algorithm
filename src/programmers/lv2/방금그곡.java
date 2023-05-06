package programmers.lv2;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

class Music implements Comparable<Music> {
    int time;
    String title;
    String code;
    int index;

    public Music(int time, String title, String code, int index) {
        this.time = time;
        this.title = title;
        this.code = code;
        this.index = index;
    }

    @Override
    public int compareTo(Music o) {
        if (this.time - o.time != 0)
            return o.time - this.time;
        return this.index - o.index;
    }
}

public class 방금그곡 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        List<Music> musicList = new ArrayList<>();
        int idx;
        m = replaceShap(m);

        for (int i = 0; i < musicinfos.length; i++) {
            int index = 0;
            String[] sArr = musicinfos[i].split(",");
            int playedTime = (int) ChronoUnit.MINUTES.between(LocalTime.parse(sArr[0]), LocalTime.parse(sArr[1]));
            String title = sArr[2];
            String code = sArr[3];
            code = replaceShap(code);

            String playedCode = "";
            for (int j = 0; j < playedTime; j++) {
                idx = j % code.length();
                playedCode += code.charAt(idx);
            }

            if (playedCode.contains(m)) {
                musicList.add(new Music(playedTime, title, code, index++));
            }
        }
        Collections.sort(musicList);

        if (!musicList.isEmpty())
            return musicList.get(0).title;
        else return "(NONE)";
    }

    public static String replaceShap(String code) {
        code = code.replaceAll("C#", "c");
        code = code.replaceAll("D#", "d");
        code = code.replaceAll("F#", "f");
        code = code.replaceAll("G#", "g");
        code = code.replaceAll("A#", "a");

        return code;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCEFG", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));

    }
}
