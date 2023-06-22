class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int share = 0;
        int rest = 0;
        while(n>=a) {
            answer += n/a*b;
            share = n/a*b;
            rest = n%a;
            n = share+rest;
        }
        
        return answer;
    }
}