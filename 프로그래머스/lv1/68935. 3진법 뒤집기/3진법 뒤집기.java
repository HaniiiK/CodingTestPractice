class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==1) {
            return 1;
        }else if (n==2) {
            return 2;
        }
        
        String s = "";
        while(true) { //3진법 수 구하기
            s = n%3+"".concat(s);
            n = n/3;
            if(n<3) {
                s = n+"".concat(s);
                break;
            }
        }
        int tmp = 0; //계산
        for(int i=0; i<s.length(); i++) {
            tmp = s.charAt(i)-'0';
            answer += tmp*Math.pow(3, i);
        }
        return answer;
    }
}