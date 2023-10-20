class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int answerLen = 0;
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
        
        for(int i=0; i<musicinfos.length; i++) {
            String[] strs = musicinfos[i].split(",");
            strs[3] = strs[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
            
            //반복되는 시간 계산
            int[] time = new int[2];
            for(int j=0; j<2; j++) {
                String[] tmp = strs[j].split(":");
                time[j] = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
            }
            
            //재생된 시간만큼 나온 음악으로 길이 갱신
            int repeat = time[1] - time[0];
            String s = "";
            for(int j=0; j<repeat; j++) {
                char c = strs[3].charAt(j%strs[3].length());
                s += c;
                // if(strs[3].charAt((j+1)%strs[3].length())=='#') {
                //     s += strs[3].charAt((j+1)%strs[3].length());
                //     j++;
                //     repeat++;
                // }
            }
            strs[3] = s;
            System.out.println(strs[3]);
            
            //똑같은지 찾기
            if(strs[3].contains(m)) {
                int idx = strs[3].indexOf(m)+m.length();
                // if(idx<strs[3].length() && strs[3].charAt(idx)=='#') {
                //     continue;
                // }
                
                if(answer.equals("(None)")) {
                    answer = strs[2];        
                    answerLen = strs[3].length();
                }else {
                    if(strs[3].length() > answerLen) {
                        answer = strs[2];
                        answerLen = strs[3].length();
                    }
                }
            }
        }
        
        return answer;
    }
}