class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        boolean flag = false;

        for(int i=1; i<words.length; i++) {
            for(int j=0; j<i; j++) {
                if(words[j].equals(words[i])) {
                    flag = true;
                    break;
                }
            }
            if(words[i].charAt(0)==words[i-1].charAt(words[i-1].length()-1) && !flag) {
                continue;
            }else {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
        }
        return answer;
    }
}