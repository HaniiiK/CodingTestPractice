class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i=my_string.length()-1; i>=1; i--) {
        	for(int j=0; j<i; j++) {

        		if(my_string.charAt(j)==my_string.charAt(i)) {
                    if(i==my_string.length()-1) {
                    	my_string = my_string.substring(0,i);
                    }else {
                        my_string = (my_string.substring(0,i)).concat(my_string.substring(i+1));
                    }
                    break;
                }
            }
        }
        answer = my_string;
        return answer;
    }
}