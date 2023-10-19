import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(true) {
            int k = storey%10;
            storey /= 10;
            
            if(k<5) {
                answer += k;                
            }else if(k>5) {
                answer += 10-k;
                storey++;
            }else if(k==5) {
                if(storey%10>=5) {
                    answer += 10-k;
                    storey++;
                }else {
                    answer += k;
                }
            }
            
            if(storey==0) {
                break;
            }
        }
        
        return answer;
    }    
}