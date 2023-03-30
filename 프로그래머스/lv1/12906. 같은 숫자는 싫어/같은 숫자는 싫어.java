import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int cnt=0;        
        for(int i=0; i<arr.length; i++) {
            if(i!=arr.length-1 && arr[i]==arr[i+1]) {
                continue;
            } else {
                cnt++;
            }
        }
        int[] answer = new int[cnt];
        cnt=0;
        for(int i=0; i<arr.length; i++) {
            if(i!=arr.length-1 && arr[i]==arr[i+1]) {
                continue;
            } else {
                answer[cnt] = arr[i];
                cnt++;
            }
        }
        return answer;
    }
}