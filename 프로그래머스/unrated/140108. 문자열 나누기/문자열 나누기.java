class Solution {
    public int solution(String s) {
        int answer = 0;
        int x = 0;
        int y = 0;

        char c = s.charAt(0);
        x = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i)==c) {
                x++;
            }else {
                y++;
            }
            if(x==y && i+1<s.length()) {
                answer++;
                c = s.charAt(i+1);
            }
        }
        answer++;
        return answer;
    }
}