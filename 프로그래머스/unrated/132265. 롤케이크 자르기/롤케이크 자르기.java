import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i=0; i<topping.length; i++) {
            set2.add(topping[i]);
        }
        
        boolean haveSameNumber;
        for(int i=0; i<topping.length-1; i++) { //자르는 기준인덱스 (이거 뒤로 자름)
            set1.add(topping[i]);
            
            haveSameNumber = false;
            for(int j=i+1; j<topping.length; j++) {
                if(topping[j] == topping[i]) {
                    haveSameNumber = true;
                    break;
                }
            }
            if(!haveSameNumber) {
                set2.remove(topping[i]);
            }
            if(set1.size() == set2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}