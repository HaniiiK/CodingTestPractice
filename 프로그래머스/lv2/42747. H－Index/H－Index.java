import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int cnt = 0;
        for(int i=0; i<citations.length; i++) {
            cnt = 0;
            for(int j=0; j<citations.length; j++) {
                if(citations[j]>=i+1) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            if(cnt >= i+1 && i<=citations[i]) {
                answer = i+1;
            }else {
                break;
            }
        }
        
        return answer;
    }
}