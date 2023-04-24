class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String str = "";
        
        for(int l=0; l<j-i+1; l++) { //i부터 j 사이 숫자를 나열해서 String으로 저장
            str += i+l+"";
        }
        for(int l=0; l<str.length(); l++) {
            if((str.charAt(l)-'0')==k) {
                answer++;
            }
        }
        return answer;
    }
}