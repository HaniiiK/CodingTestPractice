import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<int[]>[] list;
    static boolean[] visited;
    static int max, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());

            int tmp = 0;
            while(true) {
                tmp = Integer.parseInt(st.nextToken());
                if(tmp==-1) {
                    break;
                }
                list[idx].add(new int[]{tmp, Integer.parseInt(st.nextToken())});
            }
        }

        max = 0;
        dfs(1, 0);

        visited = new boolean[N+1];
        dfs(idx, 0);

        System.out.println(max);
    }

    public static void dfs(int start, int sum) {
        visited[start] = true;

        if(max<sum) {
            max = sum;
            idx = start;
        }

        for(int i=0; i<list[start].size(); i++) {
            int[] arr = list[start].get(i);
            if(!visited[arr[0]]) {
                visited[arr[0]] = true;
                dfs(arr[0], sum+arr[1]);
            }
        }
    }
}