class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = n+"";
        char[] c = new char[str.length()];
        int[] num = new int[str.length()];
        
        for(int i=0; i<str.length(); i++) {
            answer += str.charAt(i)-'0';
        }
        
/*        for(int i=0; i<str.length(); i++) {
            c[i] = str.charAt(i);
            num[i] = c[i] - '0';
        }        
        for(int i=0; i<num.length; i++) {
            answer += num[i];
        }*/
        
        return answer;
    }
}