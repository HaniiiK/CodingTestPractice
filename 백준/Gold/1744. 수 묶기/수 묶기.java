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

        /**
         * 음수, 0, 1, 2 이상
         */
        List<Integer> minus = new ArrayList<>();
        int zeroCnt = 0;
        int oneCnt = 0;
        List<Integer> plus = new ArrayList<>();

        int num = 0;
        for(int i=0; i<N; i++) {
            num = queue.poll();
            if(num<0) {
                minus.add(num);
            }else if(num==0) {
                zeroCnt++;
            }else if(num==1) {
                oneCnt++;
            }else if(num>1) {
                plus.add(num);
            }
        }

        int answer = 0;

        //2 이상
        int startIdx = 0;
        if(plus.size()%2==1) {
            answer += plus.get(startIdx++);
        }
        for(int i=startIdx; i<plus.size(); i+=2) {
            answer += (plus.get(i) * plus.get(i+1));
        }

        //1
        answer += oneCnt;

        //음수 & 0
        int lastIdx = minus.size()-1;
        if(minus.size()%2==1) {
            if(zeroCnt<=0) {
                answer += minus.get(lastIdx--);
            }
        }
        for(int i=0; i<lastIdx; i+=2) {
            answer += (minus.get(i) * minus.get(i+1));
        }

        System.out.println(answer);
    }
}