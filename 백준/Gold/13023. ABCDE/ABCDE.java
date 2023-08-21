import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;   //방문여부를 체크하는 배열
    static ArrayList<Integer>[] graph;  //친구 관계를 담을 리스트배열
    static boolean result = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];


        for (int i = 0; i < N; i++) {   //리스트 배열 초기화
            graph[i] = new ArrayList<Integer>();
        }

        for (int j = 0; j < M; j++) {   //각각의 사람이 어떤 친구관계를 가지고 있는지 넣어줌
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);

        }

        for (int i = 0; i < N; i++) {
            if (result == false) {
                dfs(0, i);
            }
        }

        if (result) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();

    }

    private static void dfs(int depth, int visitedIdx) {    //서로 이어지는 친구관계가 4개인지 확인

        if (depth == 4) {
            result = true;
            return;
        }

        visited[visitedIdx] = true;
        for (int i = 0; i < graph[visitedIdx].size(); i++) {
            if (visited[graph[visitedIdx].get(i)] == false) {
                dfs(depth + 1, graph[visitedIdx].get(i));
            }
        }
        visited[visitedIdx] = false;

    }

}