import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        //시간을 분 단위로 저장
        int[][] time = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++) {
            for(int j=0; j<2; j++) {
                String[] strs = book_time[i][j].split(":");
                time[i][j] = Integer.parseInt(strs[0])*60 + Integer.parseInt(strs[1]);
            }
        }
        
        //시작 시간이 이른 순서대로 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        
        //큐 안에 존재하는 요소의 개수가 방 개수
        //종료 시간이 이른 순서대로 정렬
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
            if(tmp[1]+10 > time[i][0]) {
                queue.offer(tmp);
            }
            queue.offer(time[i]);
        }
        
        int answer = queue.size();
        
        return answer;
    }
}