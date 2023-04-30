class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==' ') {
                answer += " ";
            }else if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
                if(s.charAt(i)+n <= 'Z') {
                    answer += (char)(s.charAt(i)+n);
                }else if(s.charAt(i)+n > 'Z') {
                    answer += (char)(s.charAt(i)+n-26);
                }
            }else if(s.charAt(i)>='a' && s.charAt(i)<='z') {
                if(s.charAt(i)+n <= 'z') {
                    answer += (char)(s.charAt(i)+n);
                }else if(s.charAt(i)+n > 'z') {
                    answer += (char)(s.charAt(i)+n-26);
                }
            }
        }
        
        
        
        // char[] c = new char[s.length()];
        // c = s.toCharArray();
        // for(int i=0; i<s.length(); i++) {
        //     if(c[i]==' ') {
        //         continue;
        //     }else if(c[i]+n <= 'z') {
        //         c[i] += n;                
        //     } else if(c[i]+n > 'z'){
        //         c[i] = (char)(c[i]+n-26);
        //     }
        // }
        // String answer = String.valueOf(c);
        return answer;
    }
}