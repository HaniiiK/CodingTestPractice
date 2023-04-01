class Solution {
    public int solution(String[] babbling) {
        String[] pron = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for(int i=0; i<babbling.length; i++) {
            for(int j=0; j<pron.length; j++) {
                if(babbling[i].contains(pron[j])) {
                    babbling[i] = babbling[i].replace(pron[j]," ");
                }
            }
            if(babbling[i].isBlank()) { //공백 제거한 babbling이 
                answer++;
            }
        }
        
        return answer;
    }
}