import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            queue.offer(scoville[i]);
        }
        
        while(true) {
            if(queue.peek()>=K) {
                break;
            }
            if(queue.size()>=2) {
                queue.offer(queue.poll() + queue.poll()*2);
                answer++;                
            }else {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}