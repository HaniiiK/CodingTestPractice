import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list, tree;
    static int[] parentArr, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        tree = new ArrayList[N+1];
        parentArr = new int[N+1];
        size = new int[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list[U].add(V);
            list[V].add(U);
        }

        makeTree(R, -1);
        countSubtreeNodes(R);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());

            sb.append(size[U]+"\n");
        }

        System.out.print(sb.toString());
    }

    private static void makeTree(int currentNode, int parent) {
        for (int node : list[currentNode]) {
            if (node != parent) {
                tree[currentNode].add(node);
                parentArr[node] = currentNode;
                makeTree(node, currentNode);
            }
        }
    }

    private static void countSubtreeNodes(int currentNode) {
        size[currentNode] = 1;
        for (int node : tree[currentNode]) {
            countSubtreeNodes(node);
            size[currentNode] += size[node];
        }
    }
}