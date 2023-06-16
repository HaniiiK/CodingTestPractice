import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] tmp = new int[keymap.length]; //keymap 각각 몇 번째에 targets 문자가 있는지
        int cnt = 0;
        for(int i=0; i<targets.length; i++) { //target 개수만큼 정답 출력해야 하니까
            cnt = 0;
            for(int j=0; j<targets[i].length(); j++) {
                for(int k=0; k<keymap.length; k++) {
                    tmp[k] = 1;
                    for(int l=0; l<keymap[k].length(); l++) {
                        if(targets[i].charAt(j)==keymap[k].charAt(l)) {
                            break;
                        }else {
                            tmp[k]++;
                        }
                    }
                    if(tmp[k]==keymap[k].length()+1) {
                        tmp[k] = 200;
                    }
                }
                Arrays.sort(tmp);
                if(tmp[0]==200) {
                    cnt = -1;
                    break; //한 글자라도 안되면 끝내야 하니까
                }else {
                    cnt += tmp[0];                
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}