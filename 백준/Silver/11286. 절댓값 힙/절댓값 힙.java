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
                /**
                 * return값이 양수: o1(새로 들어온 값)이 o2 뒤에 추가됨
                 * return값이 음수: o1(새로 들어온 값)이 o2 앞에 추가됨
                 * else if 케이스: o1이 양수면 o2 뒤에, o1이 음수면 o2 앞에
                 */
                if(Math.abs(o1)>Math.abs(o2)) {
                    return 1;
                }else if(Math.abs(o1)==Math.abs(o2)) {
                    return o1-o2;
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
                if(pq.isEmpty()) {
                    sb.append("0\n");
                }else {
                    sb.append(pq.poll()+"\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}