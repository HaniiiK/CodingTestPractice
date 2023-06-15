class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt=0; //이미 맞춘 숫자 개수
        int z_cnt=0; //잃어버린 숫자 개수
        for(int i=0; i<lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i]==win_nums[j]) {
                    cnt++;
                    win_nums[j] = -1;
                }
            }
            if(lottos[i]==0) {
                z_cnt++;
            }
        }
        
        int min = cnt;
        int max = cnt+z_cnt;
        if(min==0) {min = 1;}
        if(max==0) {max = 1;}
        int[] answer = {7-max, 7-min};
        return answer;
    }
}