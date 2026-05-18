class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");

        int maxPlayTime = 0;
        for (String music : musicinfos) {
            String[] musicinfo = music.split(",");
            String musicName = musicinfo[2];
            String musicLyrics = musicinfo[3];
            musicLyrics = musicLyrics.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");

            String fullLyrics = "";
            int playTime = transformTime(musicinfo[1]) - transformTime(musicinfo[0]);
            for (int i = 0; i < playTime; i++) {
                char c = musicLyrics.charAt(i % musicLyrics.length());
                fullLyrics += c;
            }

            if (playTime > maxPlayTime && fullLyrics.contains(m)) {
                maxPlayTime = playTime;
                answer = musicName;
            }
        }

        return answer;
    }

    int transformTime(String time) {
        String[] timeinfo = time.split(":");
        return Integer.parseInt(timeinfo[0]) * 60 + Integer.parseInt(timeinfo[1]);
    }
}