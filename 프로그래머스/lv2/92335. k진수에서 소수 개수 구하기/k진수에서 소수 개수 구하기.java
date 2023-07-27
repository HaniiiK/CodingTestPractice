class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = ""; //k진수
        while(true) { //k진수 구하기
            s = (n%k+"").concat(s);
            if(n<k) {
                break;
            }
            n = n/k;
        }
        
        String[] p = s.split("0{1,}"); //정규표현식. '0'이 '1'개 이상 {반복}될 때
        boolean chk = true; //소수인지 chk. 소수면 true
        if(p.length==0) {
            answer = 0;
        }else {
            for(int i=0; i<p.length; i++) {
                if(p[i].equals("1")) {
                    continue; //1은 소수 아님
                }else {
                    chk = true;
                    for(int j=2; j<=(int)Math.sqrt(Long.parseLong(p[i])); j++) {
                        if(Long.parseLong(p[i])%j==0) { //소수가 아님
                            chk = false;
                            break;
                        }
                    }
                    if(chk) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}