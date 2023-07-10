import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        boolean notmax = false;
        int i=0;
        while(true) {
//        for(i=0; i<priorities.length; i++) {
            notmax = false;
            for(int j=0; j<priorities.length; j++) {
                if(i!=j && (priorities[i%priorities.length] < priorities[j%priorities.length])) {
//                    System.out.println(i+","+priorities[i]+" 야호! "+priorities[j%priorities.length]);
                    notmax = true;
                    break;
                }
            }
            if(!notmax) {
                priorities[i%priorities.length] = -1;   
                answer++;
                if(i%priorities.length==location) {
                    break;
                }
            }
            i++;
        }
        
        
        
        
        
        
//         Stack<Integer> stack = new Stack<>();
        
//         stack.push(1);
//         stack.push(2);
//         stack.push(3);
//         stack.push(4);
//         stack.push(5);
//         stack.push(6);
        
//         System.out.println(stack.search(5));
        return answer;
    }
}