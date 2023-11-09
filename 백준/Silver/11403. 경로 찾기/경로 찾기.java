import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] distance = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
                if(distance[i][j]==0) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i=0; i<n; i++) { //중간점
            for(int j=0; j<n; j++) { //시작점
                if(distance[j][i] == Integer.MAX_VALUE) {
                    continue;
                }
                for(int k=0; k<n; k++) { //끝점
                    if(distance[i][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    distance[j][k] = Math.min(distance[j][i] + distance[i][k], distance[j][k]);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(distance[i][j]==Integer.MAX_VALUE) {
                    System.out.print("0 ");
                }else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
}