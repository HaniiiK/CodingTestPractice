import java.io.*;
import java.util.*;

public class Main {
    static StringBuffer sb;
    static List<Integer>[] list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        sb = new StringBuffer();

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N+1];
            for(int j=0; j<=N; j++) {
                list[j] = new ArrayList<>();
            }

            for(int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            int answer = N-1;
            sb.append(answer + "\n");
        }

        System.out.println(sb.toString());
    }
}