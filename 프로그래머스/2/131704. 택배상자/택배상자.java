import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        boolean isDone = false;
        int idx = 1;
        for(int i=0; i<order.length; i++) {
            if(!stack.contains(order[i])) { //stack에 지금 넣으려는 수가 없으면
                while(true) { //지금 넣으려는 수가 나올 때까지 나머지를 stack에 넣어줌
                    if(order[i]==idx) {
                        answer++;
                        idx++;
                        break;
                    }
                    stack.push(idx++);
                }
            }else {
                int pop = stack.pop();
                if(pop==order[i]) {
                    answer++;
                }else {
                    break;
                }
            }
        }
        
        
        return answer;
    }
}