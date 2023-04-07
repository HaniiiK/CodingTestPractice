class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] cnt = new int[right-left+1];
        
        for(int i=0; i<cnt.length; i++) {
            for(int j=1; j<=left+i; j++) {
                if((left+i)%j==0) {
                    cnt[i]++;
                }
            }
        }
        
        for(int i=0; i<cnt.length; i++) {
            if(cnt[i]%2==0) {
                answer += left+i;
            }else {
                answer -= left+i;
            }
        }
        return answer;
    }
}