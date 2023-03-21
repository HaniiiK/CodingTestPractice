class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] ans = new int[numlist.length];
        int index=0;
        for(int i=0; i<numlist.length; i++) {
            if(numlist[i]%n==0) {
                ans[index] = numlist[i];
                index++;
            }
        }
        int[] answer = new int[index];
        for(int i=0; i<index; i++) {
            answer[i] = ans[i];
        }
    
        return answer;
    }
}