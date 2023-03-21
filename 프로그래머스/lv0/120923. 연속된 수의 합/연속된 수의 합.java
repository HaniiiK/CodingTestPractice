class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int ans = -50;
        while(true) {
            int sum = 0;
            for(int i=0; i<num; i++) {
                sum = sum+ans+i;
            }
            if(sum==total) {
                break;
            } else {
                ans++;
            }
        }
        
        for(int i=0; i<num; i++) {
            answer[i] = ans+i;
        }
        
        return answer;
    }
}