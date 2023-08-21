import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, List<Integer>> map = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            map.put(i, new ArrayList<>());
        }

        int a, b;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        visited = new boolean[N+1];
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        for(int i=0; i<map.get(idx).size(); i++) {
            if(!visited[map.get(idx).get(i)]) {
                dfs(map.get(idx).get(i));
            }
        }
    }

}