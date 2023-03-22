class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n];
        int[] cnt = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
            cnt[i] = 0;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=1; j<=arr[i]; j++) {
                if(arr[i]%j==0) {
                    cnt[i]++;
                }
            }
        }        
        
        for(int i=0; i<n; i++) {
            if(cnt[i]>=3) {
                answer++;
            }
        }
        return answer;
    }
}