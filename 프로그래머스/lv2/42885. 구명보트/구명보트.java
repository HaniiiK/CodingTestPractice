import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<people.length; i++) {
            list.add(people[i]);
        }
        
        int ava = 0; //남은 무게
        while(true) {
            ava = limit-list.get(list.size()-1); //마지막꺼
            list.remove(list.size()-1); //태웠으니까 지움

            if(list.size()>0 && ava>=list.get(0)) {
                ava = limit-list.get(0);
                list.remove(0);                
            }
            answer++;
            if(list.size()<=0) {
            	break;
            }
        }
        return answer;
    }
}