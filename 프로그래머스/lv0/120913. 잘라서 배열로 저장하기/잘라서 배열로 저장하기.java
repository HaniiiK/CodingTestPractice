class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length()+n-1)/n];    
        for(int i=0; i<answer.length; i++) {
            answer[i] = "";
        }
        
        int index=0;
        for(int i=0; i<my_str.length(); i++) {
            if(i!=0 && i%n==0) {
                index++;
            }
            answer[index] += my_str.charAt(i);         
        }
        return answer;
    }
}