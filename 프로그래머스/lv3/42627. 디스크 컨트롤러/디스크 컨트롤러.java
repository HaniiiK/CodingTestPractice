import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        //jobs 정렬하기
        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        
        int cnt = 0;
        int idx = 0;
        int endTime = 0;

        while(cnt<jobs.length) {            
            while(idx < jobs.length && jobs[idx][0] <= endTime) {
                System.out.println(endTime+">="+jobs[idx][0]+" "+jobs[idx][1]);
                queue.offer(jobs[idx++]);
            }
            
            if(queue.isEmpty()) {
                endTime = jobs[idx][0]; //이전의 요청들과 무관하게 나중에 들어온 것 처리
            }else {
                int[] tmp = queue.poll();
                endTime += tmp[1];
                answer += endTime - tmp[0];
                cnt++;
            }
        }

        return (int)answer/jobs.length;
    }
}