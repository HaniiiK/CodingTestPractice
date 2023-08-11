import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        for(int i=numbers.length-1; i>=0; i--) {
            stack.add(numbers[i]);
            
            if(stack.isEmpty()) {
                answer[i] = -1;
                continue;
            }else {
                while(true) {
                    if(stack.peek()>numbers[i]) {
                        answer[i] = stack.peek();
                        stack.add(numbers[i]);
                        break;
                    }
                    stack.pop();
                    if(stack.isEmpty()) {
                        answer[i] = -1;
                        stack.add(numbers[i]);
                        break;
                    }
                }
            }
        }
        
        
        return answer;
    }
}