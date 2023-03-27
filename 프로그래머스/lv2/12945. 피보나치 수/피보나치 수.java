import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        int answer = 0;
        BigInteger ans = new BigInteger("0");
        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("0");
//        long ans = 0;
 //       long n1=1, n2=0;
        
        for(int i=2; i<=n; i++) {
            ans = n1.add(n2);
            n2 = n1;
            n1 = ans;
        }
        ans = ans.remainder(BigInteger.valueOf(1234567));
        answer = ans.intValue();
//        answer = (int)ans%1234567;
        return answer;
    }
}