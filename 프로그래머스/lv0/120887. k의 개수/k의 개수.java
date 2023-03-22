class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String str = "";
        int[] c = new int[j-i+1];
        
        for(int p=0; p<c.length; p++) {
        	c[p] = i;
        	i++;
            str += c[p]+"";
        }
        
        for(int p=0; p<str.length(); p++) {
            if((str.charAt(p)-'0')==k) {
                answer++;
            }
        }
        
        return answer;
    }
}