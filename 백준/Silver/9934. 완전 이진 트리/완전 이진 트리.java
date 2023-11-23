import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] input;
    static List<Integer>[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int idx = (int) Math.pow(2, n) - 1;
        input = new int[idx];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<idx; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        answer = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            answer[i] = new ArrayList<>();
        }

        search(0, input.length-1, 0);

        for(int i=0; i<n; i++) {
            for(int j=0; j<answer[i].size(); j++) {
                System.out.print(answer[i].get(j)+" ");
            }
            System.out.println();
        }
    }

    private static void search(int first, int last, int depth) {
        if (depth == n) {
            return;
        }

        int idx = (first + last) / 2;

        answer[depth].add(input[idx]);
        search(first, idx-1, depth+1);
        search(idx+1, last, depth+1);
    }
}