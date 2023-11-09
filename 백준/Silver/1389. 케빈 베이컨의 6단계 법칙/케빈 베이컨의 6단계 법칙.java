import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] distance = new int[n+1][n+1];
        for(int j=0; j<=n; j++) {
            Arrays.fill(distance[j], Integer.MAX_VALUE);
            distance[j][j] = 0;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        for(int i=1; i<=n; i++) { //중간점
            for(int j=1; j<=n; j++) { //시작점
                if(distance[j][i] == Integer.MAX_VALUE) {
                    continue;
                }
                for(int k=1; k<=n; k++) { //끝점
                    if(distance[i][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    distance[j][k] = Math.min(distance[j][i] + distance[i][k], distance[j][k]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        int sum;
        for(int i=1; i<=n; i++) {
            sum = 0;
            for(int j=1; j<=n; j++) {
                sum += distance[i][j];
            }
            if(min > sum) {
                min = sum;
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }
}