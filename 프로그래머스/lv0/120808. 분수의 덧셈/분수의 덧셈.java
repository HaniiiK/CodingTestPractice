class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {0,0};
     
        answer[0] = numer1*denom2 + numer2*denom1;
        answer[1] = denom1*denom2;      
        
        int[] n1 = new int[100];
        int cnt1 = 0;
        for(int i=1; i<=answer[0]; i++){
            if(answer[0]%i==0) {
                n1[cnt1]=i;
                cnt1++;
            }
        } 
        int[] n2 = new int[100];
        int cnt2 = 0;
        for(int i=1; i<=answer[1]; i++){
            if(answer[1]%i==0) {
                n2[cnt2]=i;
                cnt2++;
            }
        }
        
        int sameN=0;
        for(int i=0; i<cnt1; i++) {
            for(int j=0; j<cnt2; j++) {
                if(n1[i] == n2[j]) {
                    sameN = n1[i];
                }
            }
         }
        
        answer[0] = answer[0]/sameN;
        answer[1] = answer[1]/sameN;
            
        return answer;
    }
}