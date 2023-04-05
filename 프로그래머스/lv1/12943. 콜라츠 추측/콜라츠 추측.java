class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = (long) num;
        while(true) {
            if(n%2==0) {
                n = n/2;
            }else {
                n = n*3+1;
            }
            answer++;
            if(n==1) {
                break;
            }
        }
        if(answer >=500) {
            answer = -1;
        }
        if(num==1) {
            answer = 0;
        }
        return answer;
    }
}