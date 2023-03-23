class Solution {
    public int[] solution(int n) {
        int index=0;        
        for(int i=1; i<=n; i++) {
            if(n%i==0) {
                index++;
            }
        }
        
        int[] answer = new int[index];
        index=0;
        for(int i=1; i<=n; i++) {
            if(n%i==0) {
                answer[index] = i;
                index++;
            }
        }
        return answer;
    }
}