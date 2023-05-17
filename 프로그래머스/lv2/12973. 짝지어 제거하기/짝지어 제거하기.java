import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        stack.push(s.charAt(idx++));
        while(true) {
            if(idx>=s.length()) {
                break;
            }
            
            if(!stack.empty() && s.charAt(idx)==stack.peek()) {
                stack.pop();
            } else {
                stack.push(s.charAt(idx));
            }
            idx++;
        }
        // for(int i=1; i<s.length(); i++) {
        //     if(s.charAt(i-1)==s.charAt(i)) {
        //         s = (s.substring(0,i-1)).concat(s.substring(i+1));
        //         i=0;
        //     }
        // }
        if(stack.empty()) {
            answer = 1;
        }
        return answer;
    }
}