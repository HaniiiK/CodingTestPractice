class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        String[] s1 = new String[n];
        String[] s2 = new String[n];
        int len = 0;
        
        for(int i=0; i<arr1.length; i++) {            //이진수 String 배열에 저장
            s1[i] = Integer.toBinaryString(arr1[i])+"";
            len = s1[i].length();
            if(len<n) {
                for(int j=0; j<n-len; j++) {
                    s1[i] = "0".concat(s1[i]);
                }
            }
            s2[i] = Integer.toBinaryString(arr2[i])+"";
            len = s2[i].length();
            if(len<n) {
                for(int j=0; j<n-len; j++) {
                    s2[i] = "0".concat(s2[i]);
                }
            }            

            answer[i] = ""; //값 대입
            for(int j=0; j<n; j++) {
                if(s1[i].charAt(j)=='0' && s2[i].charAt(j)=='0') {
                    answer[i] += " ";
                }else {
                    answer[i] += "#";
                }                
            }
        }
        return answer;
    }
}