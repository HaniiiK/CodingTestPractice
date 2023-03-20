class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int len = numbers.length;
        
        int cnt=1;
        for(int i=0; i<=len+1; i+=2) {
            if(i == len) {
                i=0;
            } else if(i == len+1) {
                i=1;
            }
            if(cnt==k) {
                answer = numbers[i];
                break;
            } else {
                cnt++;                
            }
        }
        
        return answer;
    }
}