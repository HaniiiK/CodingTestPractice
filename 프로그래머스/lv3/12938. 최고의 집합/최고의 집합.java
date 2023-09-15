class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        if(n>s) {
            answer = new int[]{-1};
        }else {
            answer = new int[n];
            
            for(int i=0; i<n; i++) {
                answer[i] = s/(n-i);
                s = s - s/(n-i);
            }
        }
        
        return answer;
    }
}