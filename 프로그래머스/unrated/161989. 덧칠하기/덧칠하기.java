class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] sec = new int[n];
        int idx=0;
        for(int i=0; i<n; i++) {
            if(idx<section.length && i+1 == section[idx]) {
                sec[i] = 0;
                idx++;
            }else {
                sec[i] = 1;            
            }
        }
        
        for(int i=0; i<n; i++) {
            if(sec[i]==0) {
                if(i>n-m) {
                    for(int j=i; j<n; j++) {
                        sec[j] = 1;
                    }
                }else {
                    for(int j=i; j<i+m; j++) {
                        sec[j] = 1;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}