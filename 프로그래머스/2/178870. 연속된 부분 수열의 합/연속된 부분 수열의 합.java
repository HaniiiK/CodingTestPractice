class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int idx = 0;
        int first = 0, last = 0;
        int sum = 0, cnt = 1000001;

        while(idx<sequence.length) {
            sum += sequence[idx];
            last = idx++;
            
            if(sum>=k) {
                while(true) {
                    if(sum==k && last-first+1 < cnt) {
                        answer[0] = first;
                        answer[1] = last;
                        cnt = last-first+1;
                    }
                    
                    sum -= sequence[first++];
                    
                    if(sum<k) {
                        break;
                    }
                }
            }        
        }
        
        return answer;
    }
}