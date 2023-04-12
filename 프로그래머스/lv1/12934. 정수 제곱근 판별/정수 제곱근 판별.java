class Solution {
    public long solution(long n) {
        long answer = 0;
        long ans = 0;
        for(long i=1; i*i<=n; i++) {
            if(i*i==n) {
                ans=i;
                break;
            }
        }
        if(ans==0) {
            answer = -1;
        }else {
            answer = (ans+1)*(ans+1);
        }
        return answer;
    }
}