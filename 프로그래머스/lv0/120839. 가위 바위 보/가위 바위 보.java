class Solution {
    public String solution(String rsp) {
        String answer = "";
        char[] arr = new char[rsp.length()];
        
        for(int i=0; i<rsp.length(); i++) {
            if(rsp.charAt(i)=='2') {
                arr[i] = '0';    
            } else if(rsp.charAt(i)=='0') {
                arr[i] = '5';    
            } else if(rsp.charAt(i)=='5') {
                arr[i] = '2';    
            }
        }
        answer = String.valueOf(arr);
        return answer;
    }
}