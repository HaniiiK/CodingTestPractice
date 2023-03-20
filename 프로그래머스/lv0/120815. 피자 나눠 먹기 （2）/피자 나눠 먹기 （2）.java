class Solution {
    public int solution(int n) {
        int answer = 0;
        int max = n*6;
        int len = 0;
        for(int i=1; i<=max; i++) {
            if(max%i==0) {
                len++;
            }
        }
        int[] a = new int[len]; //약수 저장할 배열
        int index = 0; //a 배열의 index
        for(int i=1; i<=max; i++) {
            if(max%i==0) {
                a[index] = i;
                index++;
            }
        }
        int spI=0; //a 배열에서 n값이 있는 인덱스
        for(int i=0; i<index; i++) {
            if(a[i] == n) {
                spI = i;
            }
        }
        
        for(int j=spI; j<index; j++) {
            if(a[j]%n==0 && a[j]%6==0) {
                answer = a[j];
                break;
            }
        }
        answer /= 6;
        return answer;
    }
}