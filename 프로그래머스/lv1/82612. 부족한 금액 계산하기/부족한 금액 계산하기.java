class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        //count번 타게 되면 필요한 돈
        long total = 0;
        for(int i=0; i<count; i++) {
            total += price*(i+1);
            System.out.println(total);
        }
        
        answer = total - money;
        if(answer<0) {
            answer = 0;
        }
        
        return answer;
    }
}