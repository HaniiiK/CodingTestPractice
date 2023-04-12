class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] s = my_string.split("[a-zA-Z]");
        for(int i=0; i<s.length; i++) {
            if(!s[i].isEmpty()) {
                answer += Integer.parseInt(s[i]);
            }
        }
        return answer;
    }
}