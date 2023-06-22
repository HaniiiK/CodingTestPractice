import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack;
        
        for(int j=0; j<s.length(); j++) {
            s = s.substring(1).concat(s.substring(0,1)); //한 칸씩 옆으로
            stack = new Stack<>();
            for(int i=0; i<s.length(); i++) {
                    if(!stack.isEmpty() && stack.peek()=='(' && s.charAt(i)==')') {
                        stack.pop();
                    }else if(!stack.isEmpty() && stack.peek()=='{' && s.charAt(i)=='}') {
                        stack.pop();
                    }else if(!stack.isEmpty() && stack.peek()=='[' && s.charAt(i)==']') {
                        stack.pop();

                }else {
                    stack.push(s.charAt(i));
                }
            }
            if(stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}