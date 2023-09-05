import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        
        long num = 1;
        int i;
        for(i=1; i<=n-1; i++) {
            num *= i;
        }
        
        int ans = 0;
        for(int j=0; j<n; j++) {
            ans = (int)(k/num);
            if(k%num!=0) {
                ans++;
            }
            answer[j] = list.get(ans-1);
            list.remove(ans-1);
//            System.out.print(answer[j]+" ");
            
            k = k - num*(ans-1);
            i--;
            if(i!=0) {
                num /= i;
            }
  //          System.out.println(k+" "+i+" "+num);
        }
        
        return answer;
    }
}