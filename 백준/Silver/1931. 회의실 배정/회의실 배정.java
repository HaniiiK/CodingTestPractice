import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        Map<Long, Long> map = new HashMap<>();

        int answer = 0;
        long start=0, end=0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());

            //시작&종료 같은건 바로 카운팅
            if(start==end) {
                answer++;
            }

            if(map.containsKey(start)) {
                long value = map.get(start);

                //더 짧은 시간으로 저장하되, 시작&종료 같은건 무시함
                if((start!=end && value>end) || start==value) {
                    map.replace(start, end);
                }
            }else {
                map.put(start, end);
            }
        }

        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0] > o2[0]) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        Set<Map.Entry<Long, Long>> set = map.entrySet();
        Iterator<Map.Entry<Long, Long>> iter = set.iterator();
        while(iter.hasNext()) {
            Map.Entry<Long, Long> next = iter.next();
            queue.offer(new long[]{next.getKey(), next.getValue()});
        }

        long[] pre = queue.poll();
        long saveEnd = pre[1];
        if(pre[0]!=pre[1]) {
            answer++;
        }

        while (!queue.isEmpty()) {
            long[] poll = queue.poll();

            if(pre[1] > poll[1]) { //0 6, 1 4같은 경우
                if(poll[0] == poll[1]) { //0 6, 1 1같은 경우
                    answer--;
                }
                saveEnd = poll[1];
                pre[0] = poll[0];
                pre[1] = poll[1];
            }else if(pre[1] <= poll[1] && saveEnd <= poll[0]) { //0 6, 6 7같은 경우
                if(poll[0]!=poll[1]) {
                    answer++;
                }
                saveEnd = poll[1];
                pre[0] = poll[0];
                pre[1] = poll[1];
            }
        }

        System.out.println(answer);
    }
}