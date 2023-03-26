import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        
        char[] bef_arr = before.toCharArray();
        char[] aft_arr = after.toCharArray();
        Arrays.sort(bef_arr);
        Arrays.sort(aft_arr);
        
        for(int i=0; i<bef_arr.length; i++) {
            if(bef_arr[i] != aft_arr[i]) {
                answer = 0;
                break;
            }
        }
        return answer;
    }
}