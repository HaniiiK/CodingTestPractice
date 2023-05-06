class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
        int cnt=0;
        for(int i=1; i<=total; i++) {
            if(total%i==0) {
                cnt++;
            }
        }

        int[][] arr = new int[(cnt+1)/2][2];
        cnt = 0;
        for(int i=0; i<total; i++) {
            if(total%(i+1)==0) {
                arr[cnt][0] = total/(i+1);
                arr[cnt][1] = i+1;
                cnt++;
            }
            if(cnt>=arr.length) {
                break;
            }
        }
        
        for(int i=0; i<arr.length; i++) {
            if((arr[i][0]+arr[i][1])*2-4==brown) {
                answer[0] = arr[i][0];
                answer[1] = arr[i][1];
                break;
            }
        }
        return answer;
    }
}