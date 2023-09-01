import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int sum = 0;
        while(true) {
            if (queue.size()<=1) {
                break;
            }

            sum = queue.poll() + queue.poll();
            queue.offer(sum);
            answer += sum;
        }

        System.out.println(answer);
    }
}