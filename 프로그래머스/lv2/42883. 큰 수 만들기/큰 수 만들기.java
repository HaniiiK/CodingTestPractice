import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Long> stack = new Stack<>();
        Long num = 0L;
        int cntExcludedNums = 0;

        for(int i=0; i<number.length(); i++) {
            num = Long.parseLong(number.charAt(i)+"");
        
            if(k==cntExcludedNums) { //이미 k개 제거됐으면 나머지 전부 add
                stack.add(num);
                continue;
            }
            
            if(stack.isEmpty()) {
                stack.add(num);
            }else {
                if(stack.peek() >= num && stack.size()<number.length()-k) {
                    stack.add(num);    
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
        return sb.reverse().toString();
    }
}