import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
		int answer = 0;
		
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");

		for(int i=1; i<=share; i++) {
			a = a.multiply(BigInteger.valueOf(balls+1-i));
			b = b.multiply(BigInteger.valueOf(i));
		}
		answer = a.divide(b).intValue();
        System.out.println(answer);
        
        return answer;
    }
}