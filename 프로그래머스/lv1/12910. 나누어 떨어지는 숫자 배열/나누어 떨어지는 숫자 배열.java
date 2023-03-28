import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int idx=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor==0) {
                idx++;
            }
        }
        int[] answer = {};
        if(idx==0) {
            answer= new int[1];
            answer[0] = -1;
        } else {
            answer = new int[idx];
            idx=0;
            for(int i=0; i<arr.length; i++) {
                if(arr[i]%divisor==0) {
                    answer[idx] = arr[i];
                    idx++;
                }
            }
            Arrays.sort(answer);
        }
        return answer;            
    }
}