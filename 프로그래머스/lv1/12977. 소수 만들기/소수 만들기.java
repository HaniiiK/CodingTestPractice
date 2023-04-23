import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum=0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    list.add(sum);
                }
            }
        }
        
        for(int i=0; i<list.size(); i++) {
            for(int j=2; j<list.get(i); j++) {
                if(list.get(i)%j==0) {
                    answer--;
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}