class Solution {
    public int solution(int hp) {
        int answer = 0;
        int a=0, b=0, c=0;
        int a_res=0, b_res=0;
        
        a = hp/5;
        a_res = hp%5;
        b = a_res/3;
        b_res = a_res%3;
        c = b_res;
        answer = a+b+c;
        return answer;
    }
}