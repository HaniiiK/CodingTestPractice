import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> queueAsc = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> queueDes = new PriorityQueue<>();
        
        int cntI = 0;
        int cntD = 0;
        for(int i=0; i<operations.length; i++) {
            if(operations[i].charAt(0)=='I') {
                queueAsc.offer(Integer.parseInt(operations[i].substring(2)));
                queueDes.offer(Integer.parseInt(operations[i].substring(2)));
                cntI++;
            }else if(operations[i].charAt(0)=='D') {
                cntD++;
                if(operations[i].charAt(2)=='-') {
                    queueDes.poll();
                }else if(operations[i].charAt(2)=='1') {
                    queueAsc.poll();                    
                }
                if(cntI<=cntD) {
                    queueDes.clear();
                    queueAsc.clear();
                    cntI = 0;
                    cntD = 0;
                    continue;
                }
            } 
        }
        
        if(cntI==cntD) {
            answer[0] = 0;
            answer[1] = 0;
        }else {
            try {
                answer[0] = queueAsc.poll();
            }catch(NullPointerException e) {
                answer[0] = 0;
            }

            try {
                answer[1] = queueDes.poll();    
            }catch(NullPointerException e) {
                answer[1] = 0;
            }
        }
        
        return answer;
    }
}