class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[array.length];
        for(int i=0; i<array.length; i++) {
            cnt[i] = 0;
        }
        for(int i=0; i<array.length; i++) {
            for(int j=i+1; j<array.length; j++) {
                if(array[i]==array[j]) {
                    cnt[i]++;
                }
            }
        }
      
        int maxN=0, maxI=0;
        for(int i=0; i<array.length; i++) {
        	if(cnt[i]>maxN) {
        		maxN = cnt[i];
        		maxI = i;
        	}
        }
        int chk=0;
        for(int i=0; i<array.length; i++) {
        	if(cnt[i] == maxN) {
        		chk++;
        	}
        }
        int answer = array[maxI];
        if(chk>=2) {
        	answer = -1;
        }
        return answer;
    }
}