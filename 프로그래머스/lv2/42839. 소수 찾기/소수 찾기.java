import java.util.*;

class Solution {
    
    Set<Integer> answerSet = new HashSet<>();
    
    public int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        boolean[] isUsed = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i)-'0';
        }
        
        dfs(arr, isUsed, "");

        // Iterator<Integer> iter = answerSet.iterator();
        // while(iter.hasNext()) {
        //     System.out.println(iter.next());
        // }
        int answer = answerSet.size();
        return answer;
    }
    
    public void dfs(int[] arr, boolean[] isUsed, String num) {
        
        for(int i=0; i<arr.length; i++) {
            if(!isUsed[i]) {
                num += arr[i];
                isUsed[i] = true;
                dfs(arr, isUsed, num);
                num = num.substring(0, num.length()-1);
                isUsed[i] = false;
            }else {
                if(isPrime(Integer.parseInt(num))) {
                    answerSet.add(Integer.parseInt(num));
                }
            }

        }
    }
    
    public boolean isPrime(int num) {        
        if(num==0 || num==1) {
            return false;
        }
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) {
                return false;
            }
        }
        return true;
    }
}