import java.io.*;
import java.util.*;

public class Main {
    static int n, m, w;
    static List<Node>[] load;

    static class Node {
        int v;
        int weight;
        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<TC; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //지점 수
            m = Integer.parseInt(st.nextToken()); //도로 수
            w = Integer.parseInt(st.nextToken()); //웜홀 수

            load = new ArrayList[n+1];
            for(int j=0; j<=n; j++) {
                load[j] = new ArrayList<>();
            }

            //도로
            for(int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                load[S].add(new Node(E, T));
                load[E].add(new Node(S, T));
            }

            //웜홀
            for(int j=0; j<w; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                load[S].add(new Node(E, -T));
            }

            if(bellmanford()) {
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static boolean bellmanford() {
        long[] distance = new long[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        boolean updated = false;

        for(int k=0; k<n; k++) {
            updated = false;

            for(int i=1; i<=n; i++) {
                for(int j=0; j<load[i].size(); j++) {
                    Node node = load[i].get(j);

                    if(distance[node.v] > distance[i] + node.weight) {
                        distance[node.v] = distance[i] + node.weight;
                        updated = true;
                    }
                }
            }
            if(!updated) {
                break;
            }
        }

        if(updated) {
            for(int i=1; i<=n; i++) {
                for(int j=0; j<load[i].size(); j++) {
                    Node node = load[i].get(j);
                    if(distance[node.v] > distance[i] + node.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}