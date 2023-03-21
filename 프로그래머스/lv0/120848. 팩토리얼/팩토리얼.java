class Solution {
    public int solution(int n) {
        int answer = 0;
        int i=1, res=n;
        while(true) {
            res = res/i;
            if(res>i) {
                i++;
            } else {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}