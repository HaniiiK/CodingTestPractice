class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int sum = 0;
        for(int i=0; i<numbers.length; i++) {
            sum += numbers[i];
        }
        answer = sum/numbers.length;
        double answerD = (double)sum/numbers.length;

        if(answerD-answer==0.5 || answerD-answer==0) {
		    return answerD;
		} else {
		    return answer;
		}
        
    }
}