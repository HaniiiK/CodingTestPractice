import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> queueAsc = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> queueDes = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        
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
//                    System.out.println(queueDes.peek());
                    queueDes.poll();
                }else if(operations[i].charAt(2)=='1') {
  //                  System.out.println(queueAsc.peek());
                    queueAsc.poll();                    
                }
                if(cntI<=cntD) {
                    queueDes.clear();
                    queueAsc.clear();
                    cntI = 0;
                    cntD = 0;
                    continue; //큐가 비어있을 때 일단 임시로
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