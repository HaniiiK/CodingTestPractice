import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idxB = 0;
        for(int i=0; i<A.length; i++) {
            while(true) {
                if(idxB >= B.length) {
                    break;
                }
                
                if(A[i]<B[idxB]) {
//                    System.out.println(A[i]+" "+B[idxB]);
                    answer++;
                    idxB++;
                    break;
                }
                idxB++;
            }
        }
        
        return answer;
    }
}