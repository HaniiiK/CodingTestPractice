import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n, m, max;
    boolean[] visit;
    List<Integer>[] g;
    int[] res;
    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = new int[n+1];
        g = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            g[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
        }
        for(int i=1; i<=n; i++){
            visit = new boolean[n+1];
            dfs(i);
        }
        max = Arrays.stream(res).max().getAsInt();
        for(int i = 1; i <= n; i++){
            if(res[i] != max) continue;
            bw.write(i + " ");
        }
        bw.flush();
    }

    private void dfs(int v) {
        if(visit[v]) return;
        visit[v] = true;
        res[v]++;
        for(int a: g[v]){
            dfs(a);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}