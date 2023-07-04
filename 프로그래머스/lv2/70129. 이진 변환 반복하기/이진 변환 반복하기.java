class Solution {
    
    int zeroCnt = 0;
    int binaryCnt = 0;
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        delete(s);
        answer[0] = binaryCnt;
        answer[1] = zeroCnt;

        return answer;
    }
    
    public void delete(String str) {
        if(str.equals("1")) {
            return;
        }
        
        String newBinary = "";
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='0') { //0 제거
                zeroCnt++;
                continue;
            }else {
                newBinary += str.charAt(i);
            }
        }
        
        newBinary = Integer.toBinaryString(newBinary.length());
        binaryCnt++;
        
        delete(newBinary);
    }
}