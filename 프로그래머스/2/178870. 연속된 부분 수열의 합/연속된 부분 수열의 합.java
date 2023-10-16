import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        Queue<Integer> queue = new LinkedList<>();
        
        int idx = 0;
        int sum = 0, cnt = 1000001;
        int first = 0, last = 0;

        while(true) {
            sum += sequence[idx];
            last = idx;
            queue.offer(sequence[idx++]);
            
            if(sum==k) {
                if(queue.size() < cnt) {
                    answer[0] = first;
                    answer[1] = last;
                    cnt = queue.size();
                }
            }else if(sum>k) {
                while(true) {
                    int poll = queue.poll();
                    sum -= poll;
                    first++;
                    
                    if(sum<k) {
                        break;
                    }else if(sum==k) {
                        if(queue.size() < cnt) {
                            answer[0] = first;
                            answer[1] = last;
                            cnt = queue.size();
                        }
                    }
                }
            }
            
            if(idx==sequence.length) {
                break;
            }
        }
        
        return answer;
    }
}