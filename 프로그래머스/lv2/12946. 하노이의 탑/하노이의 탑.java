import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Integer> list = new ArrayList<>();

    public void hanoi(int n, int a, int b, int c) {
        if(n<1) {
            return;
        }
        hanoi(n-1, a, c, b);
        list.add(a);
        list.add(c);
        hanoi(n-1, b, a, c);
    }
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()/2][2];

        int idx=0;
        for(int i=0; i<list.size(); i+=2) {
            answer[idx][0] = list.get(i);
            answer[idx][1] = list.get(i+1);
            idx++;
        }
        return answer;
    }
}