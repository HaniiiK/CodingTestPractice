class Solution {
    public String solution(String my_string, int n) {
		char[] arr = new char[my_string.length()*n];
        String answer = "";
        
        for(int i=0; i<my_string.length(); i++) {
            for(int j=i*n; j<i*n+n; j++) {
            	arr[j] = my_string.charAt(i);
            }
        }
        answer = String.valueOf(arr);
        
        return answer;
    }
}