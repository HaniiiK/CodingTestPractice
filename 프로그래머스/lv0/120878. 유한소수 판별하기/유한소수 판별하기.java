class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int index1 = 0;
        int index2 = 0;
        for(int i=1; i<=a; i++) {
            if(a%i==0) {
                index1++;
            }
        }        
        for(int i=1; i<=b; i++) {
            if(b%i==0) {
                index2++;
            }
        }
        int[] arr1 = new int[index1];
        int[] arr2 = new int[index2];
        index1=0; index2=0;
        for(int i=1; i<=a; i++) {
            if(a%i==0) {
                arr1[index1] = i;
                index1++;
            }
        }        
        for(int i=1; i<=b; i++) {
            if(b%i==0) {
                arr2[index2] = i;
                index2++;
            }
        }
        
        for(int i=0; i<index1; i++) {
            for(int j=0; j<index2; j++) {
                if(arr1[i]==arr2[j]) {
                    arr1[i] = 0;
                    arr2[j] = 0;
                    continue;
                }
            }
        }
        answer = 1;
        for(int i=0; i<index2; i++) {
            if(arr2[i]!=0) {
                if(arr2[i]%2==0 || arr2[i]%5==0) {
                    continue;
                } else {
                	answer=2;
                	break;
                }
            }
        }
        
        return answer;
    }
}