class Solution {
    public String solution(String polynomial) {
        String[] s = polynomial.split(" ");

        int x=0;
        int n=0;
                
        for(int i=0; i<s.length; i+=2) {
            if(s[i].substring(0,1).equals("x") || s[i].substring(s[i].length()-1).equals("x")) {
            	if(s[i].length() == 1) {
            		x += 1;
            	}else {
                	x += Integer.parseInt(s[i].substring(0,s[i].length()-1));            		
            	}
            } else {
                n += Integer.parseInt(s[i]);
            }
        }
        String answer = "";
        if(n==0) {
        	if(x==1) {
        		answer = "x";
        	} else {
            	answer = x+"x";
        	}
        } else if(x==0) {
        	answer = n+"";
        } else {
        	if(x==1) {
                answer = "x + "+n;        		
        	} else {
                answer = x+"x + "+n;
        	}
        }
        return answer;
    }
}