import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = i+1;
        }
        
        int[] nu = new int[N]; //분자
        int[] demo = new int[N]; //분모
        double[] arr = new double[N]; //값
        
        for(int i=0; i<stages.length; i++) { //분자
            if(stages[i]<=N) {
                nu[stages[i]-1]++;
            }
        }
        for(int i=0; i<stages.length; i++) { //분모
        	for(int j=0; j<N; j++) {
        		if(stages[i]>=j+1) {
        			demo[j]++;
        		}
        	}
        }
        
        for(int i=0; i<N; i++) {
        	arr[i] = (double)nu[i]/demo[i];
        }        

        int tmpI = 0;
        double tmpD = 0;        
        for(int i=0; i<N-1; i++) { //정렬
            for(int j=i+1; j<N; j++) {
                if((arr[i] < arr[j]) || (arr[i]==arr[j] && answer[i]>answer[j])) {
                    tmpI = answer[i];
                    answer[i] = answer[j];
                    answer[j] = tmpI;
                    tmpD = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmpD;
                }
            }
        }
        
        for(int i=0; i<N; i++) {
        	System.out.println(arr[i]);
        }        
		
        return answer;
    }
}