import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> list = new ArrayList<>();
        int[] hall = new int[k];
        
        for(int i=0; i<score.length; i++) {
            list.add(score[i]);
            Collections.sort(list);
            if(i>=k) {
                answer[i] = list.get(list.size()-k);
            }else {
                answer[i] = list.get(0);
            }
        }
        
        return answer;
    }
}