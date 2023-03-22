class Solution {
    public String solution(String s) {
        String answer = "";
        int[] cnt = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            cnt[i] = 0;
        }
        //걸러내기
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    cnt[i]++;
                }                
            }
        }
        int index=0;
        for(int i=0; i<s.length(); i++) {
            if(cnt[i]==1) {
                index++;
            }
        }        
        char[] c = new char[index];
        index=0;
        for(int i=0; i<s.length(); i++) {
            if(cnt[i]==1) {
                c[index] = s.charAt(i);
                index++;
            }
        }
        
        char temp = 'a';
        for(int i=0; i<index-1; i++) {
            for(int j=i; j<index; j++) {
                if(c[i]>c[j]) {
                    temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                }
            }
        }
        
        for(int i=0; i<index; i++) {
            answer += c[i];
        }
        
        return answer;
    }
}