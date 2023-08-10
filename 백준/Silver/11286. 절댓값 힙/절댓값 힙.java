import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(Math.abs(o1)>Math.abs(o2)) {
                    return 1;
                }else if(Math.abs(o1)==Math.abs(o2)) {
                    return o1-o2; //return값이 양수면 뒤에 저장될테고 음수면 앞에 저장될테임
                }else {
                    return -1;
                }
            }
        });

        StringBuffer sb = new StringBuffer();

        int x;
        for(int i=0; i<N; i++) {
            x = Integer.parseInt(br.readLine());

            if(x!=0) {
                pq.offer(x);
            }else {
                if(pq.size()==0) {
                    sb.append("0\n");
                }else {
                    sb.append(pq.remove()+"\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}