import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
                int answer = 0;
        int[] price = new int[score.length/m+1];
        int idx = 0;
        Arrays.sort(score);
        
        for(int i=score.length-1; i>=0; i=i-m) {
        	if(i-m+1>=0) {
            	price[idx] = score[i-m+1]*m;
            	idx++;
        	}else {
        		break;
        	}
        }
        
        for(int i=0; i<idx; i++) {
        	answer += price[i];
        }
        
        
        return answer;
    }
}