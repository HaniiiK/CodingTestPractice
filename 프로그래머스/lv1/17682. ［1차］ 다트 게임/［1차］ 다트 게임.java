class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int tmp = 0;
        int tmp2 = 0;
        
        for(int i=0; i<dartResult.length(); i++) {
            if(dartResult.charAt(i)>='0' && dartResult.charAt(i)<='9') {
                tmp2 = tmp;
                if(i!=dartResult.length()-2 && (dartResult.charAt(i+1)=='0')) {
                    tmp = 10;
                    i++;
                }else {
                    tmp = dartResult.charAt(i)-'0';
                }
            }else {
                if(dartResult.charAt(i)=='S') {
                    tmp = (int)Math.pow(tmp, 1);
                    answer += tmp;
                }else if(dartResult.charAt(i)=='D') {
                    tmp = (int)Math.pow(tmp, 2);
                    answer += tmp;
                }else if(dartResult.charAt(i)=='T') {
                    tmp = (int)Math.pow(tmp, 3);
                    answer += tmp;
                }else if(dartResult.charAt(i)=='*') {
                    answer = answer + tmp + tmp2;
                    tmp *= 2;
                }else if(dartResult.charAt(i)=='#') {
                    answer -= tmp*2;
                    tmp *= -1;
                }
            }
        }
        return answer;
    }
}