import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(arr[i]==stack.peek()) {
                continue;
            }else {
                stack.add(arr[i]);
            }
        }
        
        int len = stack.size();
        int[] answer = new int[len];
        for(int i=len-1; i>=0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}