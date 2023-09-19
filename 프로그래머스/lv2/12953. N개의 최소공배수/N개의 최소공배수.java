import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        int gcd = 0;
        Arrays.sort(arr);

        for(int i=1; i<arr.length; i++) {
            if(i==1) {
                gcd = gcd(arr[i-1], arr[i]);
                answer = arr[i-1]*arr[i]/gcd;
            }else {
                gcd = gcd(answer, arr[i]);
                answer *= arr[i]/gcd;
            }
        }

        return answer;
    }
    
    private int gcd(int a, int b) {
        if(b==0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }
    
}