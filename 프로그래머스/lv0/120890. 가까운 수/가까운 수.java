class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int[] sub = new int[array.length];
        
        for(int i=0; i<array.length; i++) {
            sub[i] = array[i]-n;
        }
        int min=sub[0];
        answer = array[0];
        for(int i=1; i<sub.length; i++) {
            if(Math.abs(min) > Math.abs(sub[i])) {
                min = sub[i];
                answer = array[i];
            } else if(Math.abs(min) == Math.abs(sub[i]))  {
                if(min<0) {
                    continue;
                } else {
                    min = sub[i];
                    answer = array[i];
                }
            }            
        }
        return answer;
    }
}