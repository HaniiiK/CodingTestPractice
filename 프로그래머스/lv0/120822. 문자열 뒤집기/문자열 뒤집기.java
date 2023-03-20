class Solution {
    public String solution(String my_string) {
        String answer = "";
        int len = my_string.length();
        char[] arr = new char[len];
        
        for(int i=0; i<len; i++) {
            arr[i] = my_string.charAt(len-1-i);
        }
        answer = String.valueOf(arr);
        return answer;
    }
}