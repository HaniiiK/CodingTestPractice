import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] inDeg;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        inDeg = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            inDeg[b]++;
        }

        sort();
    }

    static private void sort() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            if(inDeg[i]==0) {
                queue.offer(i);
            }
        }

        for(int i=0; i<n; i++) {
            int poll = queue.poll();
            System.out.print(poll+" ");

            for(int nextV : list[poll]) {
                inDeg[nextV]--;

                if(inDeg[nextV]==0) {
                    queue.offer(nextV);
                }
            }
        }
    }
}