import java.util.*;

class Solution {
    
    static String melody(String str){
        return str.replaceAll("C#", "c")
        .replaceAll("D#", "d")
        .replaceAll("F#", "f")
        .replaceAll("G#", "g")
        .replaceAll("A#", "a")
        .replaceAll("B#", "b");
        
    }
    
    public String solution(String m, String[] musicinfos) {        
        int time = 0;
        String title = null;
        
        m = melody(m);

        
        for(int i = 0; i < musicinfos.length; i++){
            String[] strs = musicinfos[i].split(",");
            
            strs[3] = melody(strs[3]);
            
            int newTime = cal(strs[0], strs[1]);
            StringBuilder playedMelody = new StringBuilder();
            
            while (playedMelody.length() < newTime) {
                playedMelody.append(strs[3]);
            }
            
            String played = playedMelody.substring(0, newTime);
            
            if (played.contains(m)) {
                if (newTime > time) {
                    title = strs[2];
                    time = newTime;
                }
            }
        }
        
        
        return title == null ? "(None)" : title;
    }
    
    static int cal(String s, String s2){
        String[] str = s.split(":");
        String[] str2 = s2.split(":");
        
        int minute = (Integer.parseInt(str2[0]) - Integer.parseInt(str[0])) * 60 + 
            (Integer.parseInt(str2[1]) - Integer.parseInt(str[1]));
        return minute;
    }
}