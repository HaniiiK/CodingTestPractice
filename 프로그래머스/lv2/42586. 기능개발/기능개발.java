import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        int sub = 0;
        int[] day = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
            sub = 100;
            while(true) {
                sub -= speeds[i];
                day[i]++;
                if(sub<=progresses[i]) {
                    break;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int tmp = 1;
        int max = day[0];
        for(int i=1; i<day.length; i++) {
            if(max>=day[i]) {
                tmp++;
            }else {
                list.add(tmp);
                tmp = 1;
                max = day[i];
            }
        }
        list.add(tmp);        

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }        
        
        return answer;
    }
}