class Solution {
    public int solution(int chicken) {
        String s = chicken+"";
        int len = s.length();

//        int answer = chicken%10;
        int answer = 0;
        for(int i=1; i<len; i++) {
            answer += chicken/10;
            chicken = chicken/10 + chicken%10;
            System.out.println(chicken);
        }
        answer += chicken/10;
        return answer;
    }
}