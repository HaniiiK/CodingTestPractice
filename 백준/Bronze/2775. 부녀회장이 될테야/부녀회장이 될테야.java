import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] house = new int[15][15];
        for (int i = 0; i <= 14; i++) {
            house[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                if(j==1) {
                    house[i][j] = house[i-1][j];
                    continue;
                }
                house[i][j] = house[i-1][j] + house[i][j-1];
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(house[k][n] + "\n");
        }
        
        System.out.print(sb.toString());
    }
}