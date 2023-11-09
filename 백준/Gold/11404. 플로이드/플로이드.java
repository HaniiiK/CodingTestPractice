import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        int[][] distance = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            distance[a][b] = Integer.min(c, distance[a][b]);
        }

        for(int i=1; i<=n; i++) { //중간점
            for(int j=1; j<=n; j++) { //시작점
                if(distance[j][i] == Integer.MAX_VALUE || j==i) {
                    continue;
                }
                for(int k=1; k<=n; k++) { //끝점
                    if(distance[i][k] == Integer.MAX_VALUE || k==j || k==i) {
                        continue;
                    }

                    distance[j][k] = Math.min(distance[j][i] + distance[i][k], distance[j][k]);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(distance[i][j]==Integer.MAX_VALUE) {
                    System.out.print("0 ");
                }else {
                    System.out.print(distance[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}