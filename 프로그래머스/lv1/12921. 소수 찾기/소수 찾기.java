class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[1000001];

        for(int i=2; i<=n; i++) {
            if(prime[i] || isPrime(i)) {
                prime[i] = true;
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isPrime(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) {
                return false;
            }
        }
        return true;        
    }
}