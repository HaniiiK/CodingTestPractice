import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++) {
            queue.offer(works[i]);
        }

        while(true) {
            if(queue.isEmpty()) {
                break;
            }
            
            int num = queue.poll()-1;
            if(num>0) {
                queue.offer(num);
            }

            if(--n==0) {
                break;
            }
        }
        
        while(true) {
            if(queue.isEmpty()) {
                break;
            }
            
            int num = queue.poll();
            answer += num*num;
        }
        
        return answer;
    }
}