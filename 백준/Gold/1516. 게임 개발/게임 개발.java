import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] inDeg;
    static List<Integer>[] list;
    static StringBuffer sb;
    static int[] time;
    static int[] addedTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        inDeg = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        time = new int[n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int a = Integer.parseInt(st.nextToken());
                if(a==-1) {
                    break;
                }

                list[a].add(i);
                inDeg[i]++;
            }
        }

        sb = new StringBuffer();
        addedTime = new int[n+1];
        sort();

        for(int i=1; i<=n; i++) {
            System.out.println(time[i] + addedTime[i]);
        }
    }

    static private void sort() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            if(inDeg[i]==0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int poll = queue.poll();

            for(int nextV : list[poll]) {
                if(time[poll]+addedTime[poll] > addedTime[nextV]) {
                    addedTime[nextV] = time[poll]+addedTime[poll];
                }
                inDeg[nextV]--;

                if(inDeg[nextV]==0) {
                    queue.offer(nextV);
                }
            }
        }
    }
}