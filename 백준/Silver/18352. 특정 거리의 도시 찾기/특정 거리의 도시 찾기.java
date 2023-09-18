import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static List<Integer>[] list;
    static boolean[] visited;
    static Queue<int[]> queue;
    static List<Integer> answerList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a-1].add(b-1);
        }

        queue = new LinkedList<>();
        queue.offer(new int[]{x-1, 0});
        answerList = new ArrayList<>();
        graph();

        if(answerList.size()==0) {
            System.out.println("-1");
        }else {
            Collections.sort(answerList);
            for(int i=0; i<answerList.size(); i++) {
                System.out.println(answerList.get(i));
            }
        }
    }

    private static void graph() {
        if(queue.isEmpty()) {
            return;
        }
        int[] node = queue.poll();
        visited[node[0]] = true;

        if(node[1]==k) {
            answerList.add(node[0]+1);
        }

        for(int i=0; i<list[node[0]].size(); i++) {
            if (!visited[list[node[0]].get(i)]) {
                visited[list[node[0]].get(i)] = true;
                queue.offer(new int[]{list[node[0]].get(i), node[1]+1});
            }
        }

        graph();
    }

}