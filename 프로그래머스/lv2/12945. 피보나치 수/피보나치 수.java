//import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        
        for(int i=2; i<=n; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        answer= fibo[n];
        
/*        BigInteger ans = new BigInteger("0");
        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("0");
        
        for(int i=2; i<=n; i++) {
            ans = n1.add(n2);
            n2 = n1;
            n1 = ans;
        }
        ans = ans.remainder(BigInteger.valueOf(1234567));
        answer = ans.intValue();*/
        return answer;
    }
}