import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Long> stack = new Stack<>();
        Long num = 0L;
        int cntExcludedNums = 0;

        for(int i=0; i<number.length(); i++) {
            num = Long.parseLong(number.charAt(i)+"");
        
            if(k==cntExcludedNums && stack.size()<number.length()-k) {
                stack.add(num);
                continue;
            }
            
            if(stack.isEmpty()) {
                stack.add(num);
            }else {
                if(stack.peek() >= num) {
                    if(stack.size()<number.length()-k) {
                        stack.add(num);    
                    }
                }else if(stack.peek() < num) {
                    stack.pop();
                    cntExcludedNums++;
                    i--;
                }                
            }
        }

        StringBuilder sb = new StringBuilder();        
        for(int i=0; i<number.length()-k; i++) {
            sb.append(stack.pop()+"");
        }
        answer = sb.reverse().toString();
        
        return answer;
    }
}