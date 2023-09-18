import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        //jobs 정렬하기
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        
        int cnt = 0;
        int idx = 0;
        int sum = 0;
        int endTime = 0;

        while(cnt<jobs.length) {
            
            while(idx < jobs.length && jobs[idx][0] <= endTime) {
                queue.offer(jobs[idx++]);
            }
            
            if(queue.isEmpty()) {
                endTime = jobs[idx][0];
            }else {
                int[] tmp = queue.poll();
//                System.out.println(tmp[0] + " " + tmp[1]);
//                sum += tmp[1];
                endTime += tmp[1];
                answer += endTime - tmp[0];
                
                cnt++;
            }
        }

        return (int)answer/jobs.length;
    }
}