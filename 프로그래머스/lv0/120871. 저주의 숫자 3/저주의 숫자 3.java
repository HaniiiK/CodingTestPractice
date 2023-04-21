class Solution {
	public  int Myfunction(int n) {
		n++;
		return (n%3==0 || (n+"").contains("3")) ? Myfunction(n) : n ;
	}
    
	public int solution(int n) {
		int threeTimes = 0;

		for (int i = 1; i <= n; i++) {
			threeTimes = Myfunction(threeTimes);
		}
		return threeTimes;
	}
}