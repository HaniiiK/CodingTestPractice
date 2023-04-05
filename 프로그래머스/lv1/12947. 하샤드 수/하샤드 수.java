class Solution {
    public boolean solution(int x) {
        String s = x+"";
        int[] arr = new int[s.length()];
        int sum=0;
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i)-'0';
            sum += arr[i];
        }
        
        boolean answer = true;
        if(x%sum==0) {
            answer = true;
        }else {
            answer = false;
        }
        return answer;
    }
}