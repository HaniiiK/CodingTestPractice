import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        
        for(int i=0; i<book_time.length; i++) {
            for(int j=0; j<2; j++) {
                String[] strs = book_time[i][j].split(":");
                time[i][j] = Integer.parseInt(strs[0])*60 + Integer.parseInt(strs[1]);
            }
        }
        
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }            
        });
        
        for(int i=0; i<time.length; i++) {
            if(queue.isEmpty()) {
                queue.offer(time[i]);
                continue;
            }
            
            int[] tmp = queue.poll();
            if(tmp[1]+10 <= time[i][0]) {
                queue.offer(time[i]);
            }else {
                queue.offer(time[i]);
                queue.offer(tmp);
            }
            
        }
        
        int answer = queue.size();
        
        return answer;
    }
}