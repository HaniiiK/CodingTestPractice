class Solution {
    public int[] solution(int[] numlist, int n) {
        int len = numlist.length;
        int[] answer = new int[len];

        for(int i=0; i<len; i++) {
            answer[i] = numlist[i]-n;
        }
        
        int temp=0;
        for(int i=0; i<len-1; i++) {
            for(int j=i+1; j<len; j++) {
                if((Math.abs(answer[i]) > Math.abs(answer[j])) || ((Math.abs(answer[i]) == Math.abs(answer[j]))&&(answer[i] < answer[j]))) {
                    temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }
        for(int i=0; i<len; i++) {
            answer[i] += n;
        }
        return answer;
    }
}