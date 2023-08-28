class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number]; //약수 담기
        for(int i=1; i<=number; i++) {
            for(int j=1; j<=Math.sqrt(i); j++) {
                if(i%j==0) {
                    if(Math.sqrt(i)==j) {
                        arr[i-1]++;
                    }else {
                        arr[i-1]+=2;
                    }
                }
            }
        }
        
        for(int i=0; i<number; i++) {
            if(arr[i]>limit) {
                arr[i] = power;
            }
            answer += arr[i];
        }
        return answer;
    }
}