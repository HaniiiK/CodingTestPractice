class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n); //이진수로 변환
    
        int zero_cnt = 0;
        int one_cnt = 0;
        int chkk = 100; //현재 0과 1의 개수로 만들 수 있는 숫자의 최대치인지 체크

        for(int i=0; i<binary.length(); i++) {
            if(binary.charAt(i)=='0') {
                zero_cnt++;
            }else {
                one_cnt++;
            }            
        }
        for(int i=0; i<binary.length()-1; i++) {
            if(binary.charAt(i)=='0') {
                chkk = 200; //첫번째 0이 나오면 200
            }
            if(chkk!=200 && binary.charAt(i)=='1') {
                chkk = 300;
            }
        }
        // if(zero_cnt==0) {
        //     zero_cnt++;
        // }
        if(chkk==300) {
            zero_cnt++;
        }
        
        int answer = n;
        String chk="";
        int zero_cnt_answer = 0;
        int one_cnt_answer = 0;
        while(true) {
            chk = Integer.toBinaryString(++answer);
            zero_cnt_answer = 0;
            one_cnt_answer = 0;
            for(int j=0; j<chk.length(); j++) {
                if(chk.charAt(j)=='0') {
                    zero_cnt_answer++;
                }else {
                    one_cnt_answer++;
                }
            }
            
            if(zero_cnt==zero_cnt_answer && one_cnt==one_cnt_answer) {
                break;
            }
        }
        
        return answer;
    }
}