class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long num=0;
        for(int i=0; i<=t.length()-len; i++) {
            num = Long.parseLong(t.substring(i,len+i));
            if(num <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}