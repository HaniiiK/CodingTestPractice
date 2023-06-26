import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int idx = -1;
        boolean flag = false;

        for(int i=0; i<ingredient.length; i++) {
            stack.push(ingredient[i]);
            idx++;
            
            if(idx>=3 && stack.peek()==1 && stack.search(3)==2 && stack.search(2)==3) {
                stack.pop();
                if(stack.search(1)==3) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                    idx-=4;
                }else {
                    stack.push(1);
                }
            }
        }
        return answer;
    }
}