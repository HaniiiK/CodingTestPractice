import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int sum;
        for(int i=1; i<=elements.length; i++) { //길이가 1부터 5까지
            for(int j=0; j<elements.length; j++) { //경우의 수 다섯번
                sum = 0;
                for(int k=j; k<j+i; k++) { //길이 개수만큼 더함
                    sum += elements[k%elements.length];
                }
                set.add(sum);
            }
        }

        int answer = set.size();
        
        return answer;
    }
}