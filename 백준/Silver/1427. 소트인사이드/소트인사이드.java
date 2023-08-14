import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();

        int[] arr = new int[N.length()];
        for(int i=0; i<N.length(); i++) {
            arr[i] = N.charAt(i)-'0';
        }

        int maxIdx;
        int tmp;
        for(int i=0; i<N.length()-1; i++) {
            maxIdx = i;
            for (int j = i + 1; j < N.length(); j++) {
                if (arr[maxIdx] < arr[j]) {
                    maxIdx = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = tmp;
            System.out.print(arr[i]);
        }
        System.out.print(arr[N.length()-1]);

    }
}